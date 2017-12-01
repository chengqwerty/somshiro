package som.make.chengcheng.shiro.chapter6.service;

import som.make.chengcheng.shiro.chapter6.dao.UserDao;
import som.make.chengcheng.shiro.chapter6.dao.UserDapImpl;
import som.make.chengcheng.shiro.chapter6.entity.User;

import java.util.Set;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDapImpl();
    private PasswordHelper passwordHelper = new PasswordHelper();

    @Override
    public User createUser(User user) {
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
