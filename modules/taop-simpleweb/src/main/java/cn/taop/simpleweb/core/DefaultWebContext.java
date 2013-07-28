/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.simpleweb.core;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.taop.simpleweb.WebContext;

/**
 * 自定义的web容器上下文默认实现类，通过此容器可在web之外获取Servlet相关变量
 * 
 * @author duduwolf
 */
public class DefaultWebContext implements WebContext {
	
	public DefaultWebContext(HttpServletRequest request, HttpServletResponse response, ServletConfig config, ServletContext context) {
		this.request = request;
		this.response = response;
		this.serlvetConfig = config;
		this.servletContext = context;
	}

	/* (non-Javadoc)
	 * @see cn.taop.simpleweb.WebContext#getHttpServletRequest()
	 */
	@Override
	public HttpServletRequest getHttpServletRequest() {
		return this.request;
	}

	/* (non-Javadoc)
	 * @see cn.taop.simpleweb.WebContext#getHttpServletResponse()
	 */
	@Override
	public HttpServletResponse getHttpServletResponse() {
		return this.response;
	}

	/* (non-Javadoc)
	 * @see cn.taop.simpleweb.WebContext#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		return this.serlvetConfig;
	}

	/* (non-Javadoc)
	 * @see cn.taop.simpleweb.WebContext#getServletContext()
	 */
	@Override
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	/* (non-Javadoc)
	 * @see cn.taop.simpleweb.WebContext#getSession()
	 */
	@Override
	public HttpSession getSession() {
		this.session = (request != null ? request.getSession() : null);
		return this.session;
	}

	private HttpSession session;
	private ServletContext servletContext;
	private ServletConfig serlvetConfig;
	private HttpServletResponse response;
	private HttpServletRequest request;
}
