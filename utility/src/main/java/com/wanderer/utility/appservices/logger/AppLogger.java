/**
 * 
 */
package com.wanderer.utility.appservices.logger;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author anupam babar
 * @desc The class is used to facilitate spring aop functionality for
 *       application logging purpose
 */
public class AppLogger {

	private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

	/**
	 * Following is the definition for a pointcut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* com.df.controller.*.*(..))")
	private void selectAll() {
	}

	/**
	 * @param joinPoint
	 *            This is the method will be executed before a selected method
	 *            execution.
	 */
	@Before(value = "selectAll()", argNames = "joinPoint")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("START : Method Name : " + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
	}

	/**
	 * @param joinPoint
	 *            This is the method will be executed after a selected method
	 *            execution.
	 */
	@After("selectAll()")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info("END : Method Name : " + joinPoint.getSignature().toShortString());
	}

	/**
	 * @param joinPoint
	 * @param retVal
	 *            This is the method will be executed when any method returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturningAdvice(JoinPoint joinPoint, Object retVal) {
		logger.info("Method Name : " + joinPoint.getSignature().toShortString() + " Returning: " + retVal.toString());
	}

	/**
	 * @param joinPoint
	 * @param ex
	 *            This is the method will be executed if there is an exception
	 *            raised by any method.
	 */
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, IllegalArgumentException ex) {
		logger.info("Exception Occurred while executing method : " + joinPoint.getSignature().toShortString());
		logger.info("Exception Details : " + ex.toString());
	}
}
