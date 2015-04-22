package com.haozileung.infra.dao.persistence;

import org.apache.commons.lang.StringUtils;

import com.haozileung.infra.utils.NameUtil;

/**
 * 默认名称处理handler
 */
public class DefaultNameHandler implements NameHandler {

	/**
	 * 根据实体名获取表名
	 *
	 * @param entityClass
	 * @return
	 */
	@Override
	public String getTableName(Class<?> entityClass) {
		// Java属性的骆驼命名法转换回数据库下划线“_”分隔的格式
		return NameUtil.getUnderlineName(entityClass.getSimpleName());
	}

	/**
	 * 根据表名获取主键名
	 *
	 * @param entityClass
	 * @return
	 */
	@Override
	public String getPKName(Class<?> entityClass) {
		return "id";
	}

	/**
	 * 根据属性名获取列名
	 *
	 * @param fieldName
	 * @return
	 */
	@Override
	public String getColumnName(String fieldName) {
		String underlineName = NameUtil.getUnderlineName(fieldName);
		return underlineName;
	}

	/**
	 * 根据实体名获取主键值 自增类主键数据库直接返回null即可
	 *
	 * @param entityClass
	 *            the entity class
	 * @param dialect
	 *            the dialect
	 * @return pK value
	 */
	@Override
	public String getPKValue(Class<?> entityClass, String dialect) {
		if (StringUtils.equalsIgnoreCase(dialect, "oracle")) {
			// 获取序列就可以了，默认seq_加上表名为序列名
			String tableName = this.getTableName(entityClass);
			return String.format("SEQ_%s.NEXTVAL", tableName);
		}
		return null;
	}
}
