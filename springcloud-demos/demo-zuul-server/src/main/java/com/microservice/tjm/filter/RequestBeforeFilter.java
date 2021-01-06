package com.microservice.tjm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * RequestBeforeFilter
 *
 * @author: tjm
 * @date: 2020/12/14 19:41
 */
public class RequestBeforeFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestBeforeFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        final RequestContext ctx = RequestContext.getCurrentContext();
        final HttpServletRequest request = ctx.getRequest();
        logger.info("###################### request start #####################");
        logger.info("request method: {}", request.getMethod());
        logger.info("request uri: {}", request.getRequestURI());
        logger.info("###################### request end #####################");

        return null;
    }
}
