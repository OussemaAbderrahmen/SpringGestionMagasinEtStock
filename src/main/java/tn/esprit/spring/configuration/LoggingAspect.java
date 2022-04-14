package tn.esprit.spring.configuration;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect

public class LoggingAspect {
		/*@Before("execution(* tn.esprit.spring.service.*.*(..))")
		public void logMethodEntry(JoinPoint joinPoint){
			String name = joinPoint.getSignature().getName();
			log.info("In Method :"+name + ":");
		}
		
		@AfterReturning("execution(* tn.esprit.spring.service.*.*(..))")
		public void logMethodExit1(JoinPoint joinPoint){
			String name = joinPoint.getSignature().getName();
			log.info("Out of Method without errors :"+name );
		
		}*/

}
