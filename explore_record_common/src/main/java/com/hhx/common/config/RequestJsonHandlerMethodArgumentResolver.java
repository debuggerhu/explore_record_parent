package com.hhx.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hhx.common.config.annotetion.ParseBaseTypeJson;
import com.hhx.common.utils.ObjUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;


/**
 * @Author qinx
 * @Date 2019年12月11日15:42:26
 */

/**
 * 使用restful风格代替
 */
@Deprecated
public class RequestJsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String JSONBODY_ATTRIBUTE = "JSON_REQUEST_BODY";

    /**
     * 设置支持的方法参数类型
     *
     * @param methodParameter 方法参数
     * @return 支持的类型
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(ParseBaseTypeJson.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取到请求的json参数
        String jsonBody = getRequestBody(webRequest);

        JSONObject jsonObject = JSON.parseObject(jsonBody);

        ParseBaseTypeJson parameterAnnotation = parameter.getParameterAnnotation(ParseBaseTypeJson.class);
        //注解的value是JSON的key
        String key = parameterAnnotation.value();
        if (!StringUtils.isNotEmpty(key)) {
            //注解中没有定义value，则直接方法参数中获取
            key = parameter.getParameterName();
        }
        Object value = jsonObject.get(key);

        Class<?> parameterType = parameter.getParameterType();
        if (value == null && parameterAnnotation.required()) {
            throw new IllegalArgumentException(String.format("required param %s is not present", key));
        }

        //判断是否为基本类型
        if (isBasicDataTypes(parameterType)) {
            return ObjUtil.convert(value, parameterType);
        }

        //当为对象类型又获取不到值时，直接返回错误
        if (value == null) {
            return null;
        }

        Object result = JSON.parseObject(value.toString(), parameterType);

        if (!parameterAnnotation.required()) {
            return result;
        }

        boolean haveValue = false;
        Field[] declaredFields = parameterType.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.get(result) == null) {
                break;
            }
            haveValue = true;
            break;
        }
        if (!haveValue) {
            throw new IllegalArgumentException(String.format("required param %s is not present", key));
        }
        return result;
    }

    /**
     * 基本数据类型直接返回
     */
    private boolean isBasicDataTypes(Class clazz) {
        Set<Class> classSet = new HashSet<>();
        classSet.add(String.class);
        classSet.add(Integer.class);
        classSet.add(Long.class);
        classSet.add(Short.class);
        classSet.add(Float.class);
        classSet.add(Double.class);
        classSet.add(Boolean.class);
        classSet.add(Character.class);
        return classSet.contains(clazz);
    }

    /**
     * 获取请求体JSON字符串
     */
    private String getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        // 有就直接获取
        String jsonBody = (String) webRequest.getAttribute(JSONBODY_ATTRIBUTE, NativeWebRequest.SCOPE_REQUEST);
        // 没有就从请求中读取
        if (jsonBody != null) {
            return jsonBody;
        }

        try {
            jsonBody = IOUtils.toString(servletRequest.getReader());
            webRequest.setAttribute(JSONBODY_ATTRIBUTE, jsonBody, NativeWebRequest.SCOPE_REQUEST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return jsonBody;
    }


}
