package com.in28minutes.microservices.zuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public boolean shouldFilter() {
		// means filter every request
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// the actual filter logic
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

		logger.info("Request -> {} Request URI -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// pre, post request or only error requests,
		return "pre";
	}

	@Override
	public int filterOrder() {
		// if you have more filter, this is the order of execution
		return 1;
	}

}
