package com.storyart.apigateway;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.json.GsonJsonParser;

import javax.servlet.http.HttpServletRequest;

public class SimpleFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Gson gson= new Gson();
        System.out.println(gson.toJson(request,HttpServletRequest.class));
        return null;
    }



}