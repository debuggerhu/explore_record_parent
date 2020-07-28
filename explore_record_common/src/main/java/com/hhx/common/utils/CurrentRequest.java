package com.hhx.common.utils;

import com.hhx.common.constants.JwtPayload;
import com.hhx.common.constants.exceptions.NoTokenFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
public class CurrentRequest {

    private static final String SIGNING_KEY = "dgsghglk24wqf3gsd2dev";

    private static String getJwt() throws NoTokenFoundException {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        String authorizationHeader = "Authorization";
        String bearerToken = request.getHeader(authorizationHeader);
        String authorizationHeaderPrefix = "Bearer ";
        if (StringUtils.isEmpty(bearerToken)) {
            throw new NoTokenFoundException();
        }
        return bearerToken.substring(authorizationHeaderPrefix.length());
    }

    public static JwtPayload getJwtPayload() throws NoTokenFoundException {
        String jwt = getJwt();
        return getJwtPayload(jwt);
    }

    public static JwtPayload getJwtPayload(String jwt) {
        JwtPayload jwtPayload = new JwtPayload();

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(new SecretKeySpec(SIGNING_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName()))
                    .parseClaimsJws(jwt)
                    .getBody();
            BeanUtils.populate(jwtPayload, claims);
        } catch (Exception e) {
            log.error("Parser Jwt Error :" + e.toString());
        }

        return jwtPayload;
    }

    public static Long getHospitalId() {
        try {
            JwtPayload jwtPayload = getJwtPayload();
            return jwtPayload.getHospitalId();
        } catch (Exception e) {
            log.error("Get Hospital Error :" + e.toString());
            return -1L;
        }
    }

    public static List<Long> getHospitalIdList() {
        try {
            JwtPayload jwtPayload = getJwtPayload();
            return jwtPayload.getHospitalIdList();
        } catch (Exception e) {
            log.error("Get Hospital List Error :" + e.toString());
            return null;
        }
    }

    public static String getUserName() {
        try {
            JwtPayload jwtPayload = getJwtPayload();
            return jwtPayload.getUsername();
        } catch (Exception e) {
            log.error("Get User Name Error :" + e.toString());
            return "";
        }
    }

    public static String getUserId() {
        try {
            JwtPayload jwtPayload = getJwtPayload();
            return jwtPayload.getUserId();
        } catch (Exception e) {
            log.error("Get User Id Error :" + e.toString());
            return "";
        }
    }

}
