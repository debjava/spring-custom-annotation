package com.ddlab.rnd.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AppLoggerAspect {

	@Autowired
	private HttpServletRequest request;

	@Around("@annotation(AppLogger)")
	public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("Incoming Request: {}", request.getRequestURI());
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		log.debug("Invoked Method Name : {}", codeSignature.getName());
		// Extracting method arguments name
		String[] parameterNames = codeSignature.getParameterNames();
		// Extracting method arguments value
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < parameterNames.length; i++) {
			log.debug("Argument Name: {}, Argument value: {}", parameterNames[i], args[i]);
		}
		Object obj = joinPoint.proceed();
		return obj;

	}
}
