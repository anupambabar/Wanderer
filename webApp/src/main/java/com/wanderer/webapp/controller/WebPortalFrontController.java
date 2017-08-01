package com.wanderer.webapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wanderer.utility.beans.LoginBean;
import com.wanderer.utility.beans.UserBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WebPortalFrontController {

	private static final Logger logger = LoggerFactory.getLogger(WebPortalFrontController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startUp() {
		return "startup";
	}

	@RequestMapping(value = "/showHome", method = RequestMethod.GET)
	public String showHome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String showLogin(Model model) { 
	    model.addAttribute("login", new LoginBean()); 
		return "login";
	}

	@RequestMapping(value = "/webLogin", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") LoginBean login) {
		ModelAndView mav = null;
		UserBean user = null;
		if("anupam".equals(login.getUsername()) && "babar".equals(login.getPassword())){
			user = new UserBean();
			user.setFirstname("Anupam");
		}
		if (null != user) {
			mav = new ModelAndView("dashboard");
			mav.addObject("firstname", user.getFirstname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

}