package com.hhx.common.config.security;

import com.hhx.common.constants.JwtPayload;
import com.hhx.common.constants.exceptions.NoTokenFoundException;
import com.hhx.common.utils.CurrentRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author su Lichen
 * @Date 2020/5/18 14:02
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        JwtPayload jwtPayload = null;

        try {
            jwtPayload = CurrentRequest.getJwtPayload();
        } catch (NoTokenFoundException e) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        if (!ObjectUtils.isEmpty(jwtPayload) && !StringUtils.isEmpty(jwtPayload.getUserId())) {

            List<String> roleList = jwtPayload.getAuthorities();

            List<GrantedAuthority> authorities = new ArrayList<>();

            if (!ObjectUtils.isEmpty(roleList)) {
                authorities = roleList.stream()
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            }

            Authentication authentication = new UsernamePasswordAuthenticationToken(null, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
