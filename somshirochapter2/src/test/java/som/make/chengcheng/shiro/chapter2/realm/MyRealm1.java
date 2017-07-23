package som.make.chengcheng.shiro.chapter2.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Think on 2017/7/15.
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName(){
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        String password=new String((char[])authenticationToken.getCredentials());

        if(!"zhang".equals(username)){
            throw new UnknownAccountException("username is error");
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException("password is error");
        }

        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
