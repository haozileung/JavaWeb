package com.haozileung.manager.velocity;

import java.util.List;
import java.util.Map;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;

import com.google.common.collect.Maps;
import com.haozileung.infra.utils.SpringContextUtil;
import com.haozileung.manager.model.security.Resource;
import com.haozileung.manager.service.security.IResourceService;

@DefaultKey("dic")
@ValidScope(Scope.APPLICATION)
public class DictionaryTool {
	private static Map<String, Object> status;
	private static Map<String, Object> resourceType;

	public Map<String, Object> getStatus() {
		if (null == status) {
			status = Maps.newHashMap();
			status.put("0", "启用");
			status.put("1", "禁用");
		}
		return status;
	}

	public Map<String, Object> getResourceType() {
		if (null == resourceType) {
			resourceType = Maps.newHashMap();
			resourceType.put("0", "菜单组");
			resourceType.put("1", "菜单项");
			resourceType.put("2", "控件");
			resourceType.put("3", "方法");
		}
		return resourceType;
	}

	public List<Resource> getResourceGroup() {
		IResourceService service = (IResourceService) SpringContextUtil
				.getBean("resourceServiceImpl");
		List<Resource> list = service.getResourceGroups();
		return list;
	}

	public List<Resource> getMenu() {
		IResourceService service = (IResourceService) SpringContextUtil
				.getBean("resourceServiceImpl");
		List<Resource> list = service.findMenu();
		return list;
	}

}
