package cc.kotori.sboot.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import cc.kotori.sboot.web.filter.UserManageFilter;

@Configuration
public class WebConfiguration {
	
	/*@Bean
	public ServletRegistrationBean congifDispatcher(DispatcherServlet dispatcher)
	{
		ServletRegistrationBean bean = new ServletRegistrationBean(dispatcher);
		bean.addUrlMappings("*.mvc");
		return bean;
	}*/
	
	@Bean
	public FilterRegistrationBean registeFilter()
	{
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new UserManageFilter());
		bean.addUrlPatterns("/*");
		bean.setOrder(0);
		return bean;
	}
	
	/*@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> registerListener()
	{
		ServletListenerRegistrationBean<HttpSessionListener> bean = new ServletListenerRegistrationBean<HttpSessionListener>();
		bean.setListener(new HttpSessionListener() {
			
			@Override
			public void sessionDestroyed(HttpSessionEvent se) {
			}
			
			@Override
			public void sessionCreated(HttpSessionEvent se) {
			}
		});
		return bean;
	}*/
}
