package com.hhx.common.config.security;



import com.alibaba.fastjson.JSONObject;
import com.hhx.common.constants.Error;
import com.hhx.common.constants.ResponseData;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 认证失败处理类，返回401
 * @Author su Lichen
 * @Date 2020/7/20 14:33
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String body = JSONObject.toJSONString(ResponseData.error(Error.UNAUTHORIZED_USER));
        printWriter.write(body);
        printWriter.flush();
    }
}
