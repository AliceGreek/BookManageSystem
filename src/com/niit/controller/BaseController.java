package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.po.User;
import com.niit.util.Const;

public class BaseController {
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	/**
	 * 得到UserSession
	 */
	public User getUser(){
		HttpSession session = getRequest().getSession();
		if(session.getAttribute(Const.SESSION_USER) instanceof User){
			return (User)session.getAttribute(Const.SESSION_USER);
		}else{
			return null;
		}
	}
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}
	/**
	 * 获取登录用户的IP
	 * 
	 * @throws Exception
	 */
	public String getRemortIP() throws Exception {
		HttpServletRequest request = this.getRequest();
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		return ip;
	}
}
