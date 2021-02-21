package com.gospell.xiaoyuan.cloud.common.security.service;

import com.gospell.xiaoyuan.cloud.common.core.constant.CacheConstants;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * description: RedisClientDetailsService <br>
 * date: 2020/12/30 13:39 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
public class RedisClientDetailsService extends JdbcClientDetailsService {
    public RedisClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * 重写原生方法支持redis缓存
     *
     * @param clientId
     * @return
     * @throws InvalidClientException
     */
    @Override
    @Cacheable(value = CacheConstants.OAUTH_CLIENT_CACHE+":client:cache", key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) {
        return super.loadClientByClientId(clientId);
    }
}
