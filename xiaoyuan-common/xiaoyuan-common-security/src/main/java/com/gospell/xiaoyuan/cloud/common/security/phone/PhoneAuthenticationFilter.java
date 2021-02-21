package com.gospell.xiaoyuan.cloud.common.security.phone;

import com.gospell.xiaoyuan.cloud.common.core.constant.SecurityConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * description: 自定义登录Filter <br>
 * date: 2021/1/4 15:19 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Getter
@Setter
public class PhoneAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private String parameter = "wxOpenId";
    private boolean postOnly = true;
    private AuthenticationEventPublisher eventPublisher;
    private AuthenticationEntryPoint authenticationEntryPoint;


    public PhoneAuthenticationFilter() {
        super (new AntPathRequestMatcher (SecurityConstants.PHONE_TOKEN_URL, "POST"));
    }

    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        if (postOnly && !request.getMethod ().equals (HttpMethod.POST.name ())) {
            throw new AuthenticationServiceException (
                    "Authentication method not supported: " + request.getMethod ());
        }

        String param = request.getParameter (parameter);

        if (param == null) {
            param = "";
        }
        param = param.trim ();
        PhoneAuthenticationToken phoneAuthenticationToken = new PhoneAuthenticationToken (param);
        setDetails (request, phoneAuthenticationToken);
        Authentication authResult = null;
        try {
            authResult = this.getAuthenticationManager ().authenticate (phoneAuthenticationToken);

            logger.debug ("Authentication ok: " + authResult);
            SecurityContextHolder.getContext ().setAuthentication (authResult);

        } catch (Exception failed) {
            SecurityContextHolder.clearContext ();
            logger.debug ("Authentication request failed: " + failed);

            eventPublisher.publishAuthenticationFailure (new BadCredentialsException (failed.getMessage (), failed),
                    new PreAuthenticatedAuthenticationToken ("access-token", "N/A"));

            try {
                authenticationEntryPoint.commence (request, response,
                        new UsernameNotFoundException (failed.getMessage (), failed));
            } catch (Exception e) {
                logger.error ("authenticationEntryPoint handle error:{}", failed);
            }
        }

        return authResult;
    }

    private void setDetails(HttpServletRequest request, PhoneAuthenticationToken authRequest) {
        authRequest.setDetails (authenticationDetailsSource.buildDetails (request));
    }
}

