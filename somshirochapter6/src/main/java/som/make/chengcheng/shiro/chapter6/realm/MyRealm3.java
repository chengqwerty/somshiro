package som.make.chengcheng.shiro.chapter6.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import som.make.chengcheng.shiro.chapter6.entity.User;

public class MyRealm3 implements Realm {

    @Override
    public String getName() {
        return "c";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        User user = new User("zhang", "123");
        return new SimpleAuthenticationInfo(user, "123", getName());
    }
}
