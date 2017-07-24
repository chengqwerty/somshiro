package som.make.chengcheng.shiro.chapter3.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import som.make.chengcheng.shiro.chapter3.permission.BitPermission;

/**
 * Created by Think on 2017/7/18.
 */
public class MyRealm extends AuthorizingRealm{

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        System.out.println("doGetAuthorizationInfo========= principalCollection is "+principalCollection.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("role1");
        simpleAuthorizationInfo.addRole("role2");
        System.out.println("simpleAuthorizationInfo.addObjectPermission(new BitPermission(\"+user1+10\"))");
        simpleAuthorizationInfo.addObjectPermission(new BitPermission("+user1+10"));
        simpleAuthorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));
        simpleAuthorizationInfo.addStringPermission("+user2+10");
        simpleAuthorizationInfo.addStringPermission("user2:*");
        return  simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        System.out.println("========doGetAuthenticationInfo");
        String username=(String ) authenticationToken.getPrincipal();
        String password=new String((char[]) authenticationToken.getCredentials());
        if(!"zhang".equals(username)){
            throw new UnknownAccountException();
        }

        if(!"123".equals(password)){
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(username,password,getName());
    }

}
