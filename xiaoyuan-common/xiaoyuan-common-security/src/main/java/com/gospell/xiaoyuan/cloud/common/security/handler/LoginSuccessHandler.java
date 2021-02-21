package com.gospell.xiaoyuan.cloud.common.security.handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.CharsetUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gospell.xiaoyuan.cloud.common.security.util.AuthUtils;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestValidator;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * description: 登陆成功后回调，返回oauth token <br>
 * date: 2020/12/29 14:37 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Slf4j
@Builder
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private static final String BASIC_ = "Basic ";
    private ObjectMapper objectMapper;
    private PasswordEncoder passwordEncoder;
    private ClientDetailsService clientDetailsService;
    private AuthorizationServerTokenServices defaultAuthorizationServerTokenServices;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String header = request.getHeader (HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith (BASIC_)) {
            throw new UnapprovedClientAuthenticationException ("请求头中client信息为空");
        }
        try {
            String[] tokens = AuthUtils.extractAndDecodeHeader (header);
            assert tokens.length == 2;
            String clientId = tokens[0];
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId (clientId);
            //校验secret
            if (!passwordEncoder.matches (tokens[1], clientDetails.getClientSecret ())) {
                throw new InvalidClientException ("Given client ID does not match authenticated client");
            }
            TokenRequest tokenRequest = new TokenRequest (MapUtil.newHashMap (), clientId, clientDetails.getScope (), "phone");
            //校验scope
            new DefaultOAuth2RequestValidator ().validateScope (tokenRequest, clientDetails);
            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request (clientDetails);
            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication (oAuth2Request, authentication);
            OAuth2AccessToken oAuth2AccessToken = defaultAuthorizationServerTokenServices.createAccessToken (oAuth2Authentication);
            log.info ("获取token 成功：{}", oAuth2AccessToken.getValue ());
            response.setCharacterEncoding (CharsetUtil.UTF_8);
            response.setContentType (MediaType.APPLICATION_JSON_VALUE);
            PrintWriter printWriter = response.getWriter ();
            printWriter.append (objectMapper.writeValueAsString (oAuth2AccessToken));
        } catch (IOException e) {
            throw new BadCredentialsException ("Failed to decode basic authentication token");
        }
    }
}
