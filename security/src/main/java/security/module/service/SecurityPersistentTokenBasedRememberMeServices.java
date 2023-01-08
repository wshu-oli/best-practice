package security.module.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * ⾃定义记住我 services 实现类
 *
 * @author Oliver
 * @date 2023年01月05日 2:47
 */
public class SecurityPersistentTokenBasedRememberMeServices extends PersistentTokenBasedRememberMeServices {

    public SecurityPersistentTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService,
        PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
    }


    @Override
    protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
        String paramValue = request.getAttribute(parameter).toString();
        if (paramValue != null) {
            return paramValue.equalsIgnoreCase("true") || paramValue.equalsIgnoreCase("on")
                || paramValue.equalsIgnoreCase("yes") ||
                paramValue.equals("1");
        }
        return false;
    }
}
