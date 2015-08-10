package com.ps.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Will log every invokation of @RequestMapping annotated methods in @Controller
 * annotated beans.
 */

@Component
@Aspect
public class ControllerLoggingAspect {

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {
	}

	@Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
	public void requestMapping() {
	}

	@Pointcut("within(@org.springframework.web.bind.annotation.PathVariable *)")
	public void pathVariable() {
	}

	@Pointcut("execution(* *(..))")
	public void methodPointcut() {
	}

	@Before("methodPointcut()")
	public void meth(JoinPoint joinPoint)throws Throwable{
		System.out.println("PATH VAR");
	}
	@Before("controller()")
	public void aroundControllerMethod(JoinPoint joinPoint) throws Throwable {

		System.out.println("Invoked: " + niceName(joinPoint));
		System.out.println("ASPECT");

	}

	@AfterReturning("controller() && methodPointcut() && requestMapping()")
	public void afterControllerMethod(JoinPoint joinPoint) {

		System.out.println("Finished: " + niceName(joinPoint));

	}

	private String niceName(JoinPoint joinPoint) {

		return joinPoint.getTarget().getClass().toString() + '#'
				+ joinPoint.getSignature().getName() + "\n\targs:"
				+ Arrays.toString(joinPoint.getArgs());

	}

}
