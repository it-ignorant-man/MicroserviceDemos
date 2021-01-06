package com.microservice.tjm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * RequestAfterFilter
 *
 * @author: tjm
 * @date: 2020/12/14 19:46
 */
public class RequestAfterFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestAfterFilter.class);

    @Override
    public String filterType() {
        return "post";
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
        final HttpServletResponse response = ctx.getResponse();
        logger.info("###################### response start #####################");
        logger.info("response headerNames: {}", response.getHeaderNames());
        logger.info("response status: {}", response.getStatus());
        logger.info("###################### response end #####################");
        return null;
    }
}
