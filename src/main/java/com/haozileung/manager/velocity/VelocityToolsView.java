package com.haozileung.manager.velocity;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.config.ConfigurationUtils;
import org.apache.velocity.tools.config.FactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.apache.velocity.tools.view.ViewToolManager;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class VelocityToolsView extends VelocityLayoutView {

	private static final String TOOL_MANAGER_KEY = ViewToolManager.class
			.getName();

	private ViewToolManager createToolManager(VelocityEngine velocity,
			String toolFile, ServletContext application) {
		ViewToolManager toolManager = new ViewToolManager(application, false,
				false);
		toolManager.setVelocityEngine(velocity);
		// generic & view tools config
		FactoryConfiguration config = ConfigurationUtils.getVelocityView();
		// user defined tools config
		if (toolFile != null) {
			FactoryConfiguration userConfig = ConfigurationUtils
					.load(application.getRealPath(toolFile));
			config.addConfiguration(userConfig);
		}
		toolManager.configure(config);
		return toolManager;
	}

	@Override
	protected Context createVelocityContext(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = getServletContext();
		// use a shared instance of ViewToolManager
		ViewToolManager toolManager = (ViewToolManager) application
				.getAttribute(TOOL_MANAGER_KEY);
		if (toolManager == null) {
			toolManager = createToolManager(getVelocityEngine(),
					getToolboxConfigLocation(), application);
			application.setAttribute(TOOL_MANAGER_KEY, toolManager);
		}
		ViewToolContext toolContext = toolManager.createContext(request,
				response);
		if (model != null) {
			toolContext.putAll(model);
		}
		return toolContext;
	}
}