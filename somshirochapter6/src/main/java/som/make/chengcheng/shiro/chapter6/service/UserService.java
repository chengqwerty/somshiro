package som.make.chengcheng.shiro.chapter6.service;

import som.make.chengcheng.shiro.chapter6.entity.User;

import java.util.Set;

public interface UserService {

    public User createUser(User user);

    public void changePassword(Long userId, String newPassword);

    public void correlationRoles(Long userId, Long... roleIds);

    public void uncorrelationRoles(Long userId, Long... roleIds);

    public User findByUsername(String username);

    public Set<String> findRoles(String username);

    public Set<String> findPermissions(String username);
}
