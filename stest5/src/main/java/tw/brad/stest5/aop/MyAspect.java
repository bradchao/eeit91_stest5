package tw.brad.stest5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import tw.brad.stest5.controller.LoginController;

@Aspect
@Component
public class MyAspect {
	private static Logger log = LoggerFactory.getLogger(MyAspect.class);
	
	@Before("execution(* tw.brad.stest5..*(..))")
	public void before() {
		log.info("before()");
	}

}
