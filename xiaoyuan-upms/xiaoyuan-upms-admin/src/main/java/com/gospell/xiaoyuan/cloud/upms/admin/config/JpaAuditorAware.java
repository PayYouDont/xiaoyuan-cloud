package com.gospell.xiaoyuan.cloud.upms.admin.config;

import com.gospell.xiaoyuan.cloud.common.security.entity.BaseUser;
import com.gospell.xiaoyuan.cloud.common.security.util.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @ClassName AuditingEntityListener
 * @Description TODO
 * @Author pay
 * @DATE 2019/3/20 15:48
 **/
@Configuration
public class JpaAuditorAware implements AuditorAware<String> {
   @Override
   public Optional<String> getCurrentAuditor() {
       BaseUser user = SecurityUtils.getUser ();
      return user!=null?Optional.of (user.getUsername ()):Optional.of ("");
   }
}
