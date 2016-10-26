package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.po.User;
import com.niit.util.Const;

import sun.print.resources.serviceui;

@RequestMapping(value = "/login")
@Controller
public class LoginController extends BaseController{
	@RequestMapping(value = "/login")
	public ModelAndView login(String from) throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		//System.out.println(from);
		modelAndView.addObject("from", from);
		modelAndView.setViewName("login/login");
		return modelAndView;
	}
	@RequestMapping(value = "/loginvalidate")
	public ModelAndView loginvalidate(User user,String from) throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		if(login_validate(user)){
			if (null == from || "".equals(from) || "null".equals(from) || "NULL".equals(from)) {
				modelAndView.setViewName("redirect:/book/bookList");
			} else {
				modelAndView.setViewName("redirect:" + from);
			}
			return modelAndView;
		}
		modelAndView.setViewName("login/login");
		return modelAndView;
	}
	private Boolean login_validate(User user)throws Exception{
		HttpSession session = getRequest().getSession();
		if(user.getUserName().equals("R123456")&&user.getPassWord().equals("1")){
			session.setAttribute(Const.SESSION_USER, user);
			return true;
		}
		return false;
	}
	
}
