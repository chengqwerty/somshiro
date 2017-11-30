package som.make.chengcheng.shiro.chapter6.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import som.make.chengcheng.shiro.chapter6.JdbcTemplateUtils;
import som.make.chengcheng.shiro.chapter6.entity.Permission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PermissionDaoImpl implements PermissionDao{

    private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

    @Override
    public Permission createPermission(final Permission permission) {
        final String sql = "insert into sys_permissions(permission, description, available) values(?,?,?)";

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[] {"id"});
                preparedStatement.setString(1, permission.getPermission());
                preparedStatement.setString(2, permission.getDescription());
                preparedStatement.setBoolean(3, permission.getAvailable());
                return preparedStatement;
            }
        }, generatedKeyHolder);
        permission.setId(generatedKeyHolder.getKey().longValue());
        return permission;
    }

    @Override
    public void deletePermission(Long permissionId) {
        String sql = "delete from sys_roles_permissions where permission_id = ?";
        jdbcTemplate.update(sql, permissionId);

        sql = "delete from sys_permissions where id=?";
        jdbcTemplate.update(sql, permissionId);
    }
}
