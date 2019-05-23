package com.cafe24.mysite.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExecutionTimeAspect {

	@Around("execution(* *..repository.*.*(..)) || execution(* *..controller.*.*(..)) || execution(* *..service.*.*(..))" )
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// before advice
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();

		// after advice
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
				
		String taskName = className + "." + methodName;
		
		
		System.out.println("[Excution Time][" + taskName + "]\t\t" + totalTime + "mile sec");
		
		return result;

	}

}
