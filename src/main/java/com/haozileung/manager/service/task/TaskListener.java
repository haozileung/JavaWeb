package com.haozileung.manager.service.task;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TaskListener implements ApplicationListener<UserRoleChangedEvent> {
	@Async
	@Override
	public void onApplicationEvent(UserRoleChangedEvent event) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(event.getSource() + "===" + event.getUid());
	}
}
