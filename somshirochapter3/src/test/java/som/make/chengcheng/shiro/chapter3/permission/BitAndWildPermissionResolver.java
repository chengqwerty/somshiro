package som.make.chengcheng.shiro.chapter3.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by Think on 2017/7/18.
 */
public class BitAndWildPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String permissionString){
        System.out.println("resolvePermission==========permissionString is "+permissionString);
        if(permissionString.startsWith("+")){
            return new BitPermission(permissionString);
        }
        return new WildcardPermission(permissionString);
    }
}
