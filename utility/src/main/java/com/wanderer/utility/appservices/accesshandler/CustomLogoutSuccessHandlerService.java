package com.wanderer.utility.appservices.accesshandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.wanderer.utility.utils.DateUtil;

/**
 * @author anupam.babar
 *
 */
public class CustomLogoutSuccessHandlerService implements LogoutSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomLogoutSuccessHandlerService.class);

	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		logger.info("CustomLogoutSuccessHandlerService");

		if (authentication != null && authentication.getDetails() != null) {
			try {
				request.getSession().invalidate();
			} catch (Exception e) {
				logger.debug("Exception in CustomLogoutSuccessHandlerService.onLogoutSuccess() : ", e);
			}
		}

		response.setHeader("Expires", DateUtil.getCurrentDate().toString());
		response.setHeader("Last-Modified", DateUtil.getCurrentDate().toString());
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect(request.getContextPath());
	}
}
