package com.java.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class HeaderFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
	/*	RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		String headerValue=request.getHeader("Authorization");
		return headerValue== null;*/
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletResponse response=context.getResponse();
		response.addHeader("Content-Type", "application/json");
		//set jwt token
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
		
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
