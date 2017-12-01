package som.make.chengcheng.shiro.chapter6.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import som.make.chengcheng.shiro.chapter6.entity.User;
import som.make.chengcheng.shiro.chapter6.service.UserService;
import som.make.chengcheng.shiro.chapter6.service.UserServiceImpl;

public class UserRealm extends AuthorizingRealm {

    private UserService userService = new UserServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo =new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.findRoles(username));
        simpleAuthorizationInfo.setStringPermissions(userService.findPermissions(username));

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UnknownAccountException();
        }

        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
        return simpleAuthenticationInfo;
    }
}
