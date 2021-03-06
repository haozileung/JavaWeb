package com.haozileung.infra.dao.interceptor;

import java.sql.DatabaseMetaData;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.core.JdbcTemplate;

import com.haozileung.infra.dao.pager.Pager;

/**
 * 分页拦截器
 */
@Aspect
public class PageControl {

	/**
	 * 分页线程变量
	 */
	public static final ThreadLocal<Pager> LOCAL_PAGER = new ThreadLocal<Pager>();

	/**
	 * 获取总记录数
	 */
	private static final ThreadLocal<Boolean> GET_ITEMS_TOTAL = new ThreadLocal<Boolean>();

	/**
	 * 数据库
	 */
	public static String DATABASE;

	/**
	 * 执行分页
	 *
	 * @param curPage
	 * @param itemsPerPage
	 */
	public static void performPage(int curPage, int itemsPerPage) {
		performPage(curPage, itemsPerPage, true);
	}

	/**
	 * 执行分页
	 *
	 * @param curPage
	 * @param itemsPerPage
	 * @param isGetCount
	 */
	public static void performPage(int curPage, int itemsPerPage,
			boolean isGetCount) {
		Pager pager = new Pager();
		pager.setCurPage(curPage);
		pager.setItemsPerPage(itemsPerPage);
		GET_ITEMS_TOTAL.set(isGetCount);
		LOCAL_PAGER.set(pager);
	}

	/**
	 * 获取Pager对象
	 *
	 * @return
	 */
	public static Pager getPager() {
		Pager pager = LOCAL_PAGER.get();
		// 获取数据时清除
		LOCAL_PAGER.remove();
		GET_ITEMS_TOTAL.remove();
		return pager;
	}

	@Pointcut("execution(* org.springframework.jdbc.core.JdbcTemplate.query*(..))")
	public void queryMethod() {
		// 该方法没实际作用，只是切面声明对象，声明一个切面的表达式
		// 下面使用时，只需要写入这个表达式名(方法名)即可 等同于
		// @Before("anyMethod()") ==
		// @Before("execution(* com.liyd.sample.service.impl.*.*(..))")
		// 可以是private修饰符，但是会有never used的警告，所以这里用了public
	}

	@Around("queryMethod()")
	public Object pagerAspect(ProceedingJoinPoint pjp) throws Throwable {

		if (LOCAL_PAGER.get() == null) {
			return pjp.proceed();
		}

		JdbcTemplate target = (JdbcTemplate) pjp.getTarget();
		if (DATABASE == null) {
			DatabaseMetaData metaData = target.getDataSource().getConnection()
					.getMetaData();
			DATABASE = metaData.getDatabaseProductName().toUpperCase();
		}

		Object[] args = pjp.getArgs();
		String querySql = (String) args[0];
		Pager pager = LOCAL_PAGER.get();
		args[0] = this.getPageSql(querySql, pager);

		if (GET_ITEMS_TOTAL.get()) {

			String countSql = this.getCountSql(querySql);
			Object[] countArgs = null;
			for (Object obj : args) {
				if (obj instanceof Object[]) {
					countArgs = (Object[]) obj;
				}
			}
			Long itemsTotal = target.queryForObject(countSql, countArgs,
					Long.class);
			pager.setItemsTotal(itemsTotal);
		}
		Object result = pjp.proceed(args);
		pager.setList((List<?>) result);

		return null;
	}

	/**
	 * 获取总数sql - 如果要支持其他数据库，修改这里就可以
	 *
	 * @param sql
	 * @return
	 */
	private String getCountSql(String sql) {
		return "SELECT COUNT(*) FROM (" + sql + ") tmp_count";
	}

	/**
	 * 获取分页查询sql
	 *
	 * @param sql
	 * @param pager
	 * @return
	 */
	private String getPageSql(String sql, Pager pager) {
		StringBuilder pageSql = new StringBuilder(200);
		pageSql.append(sql);
		pageSql.append(" LIMIT ");
		pageSql.append(pager.getBeginIndex());
		pageSql.append(",");
		pageSql.append(pager.getItemsPerPage());
		return pageSql.toString();
	}
}
