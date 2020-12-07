package com.restservices.restwebservices.helloworldbean;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.Context;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping(value="/hello-world/path-variable/{name}")
	public BeanMessage messageBeanReturn(@PathVariable String name) {
		return new BeanMessage(String.format("Hello word mei aapka swagat hai %s", name));
	}
	
//	@GetMapping(value="/hello-world/internationalization")
//	public String messageReturn(@RequestHeader(name="Accept-language",required=false) Locale locale) {
//		return messageSource.getMessage("good.morning.message",null, locale);
//	}
	@GetMapping(value="/hello-world/internationalization")
	public String messageReturn() {
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
	}
	
}

@RestController
class ErrorController {

	@GetMapping(value="/errors")
	public ErrorBeanMessage ErrormessageBeanReturn() {
		return new ErrorBeanMessage("The page is showing error");
	}

	
}