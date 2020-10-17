package dao.impl;

import dao.IDao;
import entity.Entity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.ConnectionPool;

import java.sql.SQLException;

public class DaoImpl implements IDao {
    final QueryRunner queryRunner = new QueryRunner(ConnectionPool.dataSource);

    @Override
    public Entity login(String name, String password, String role) throws SQLException {
        String sql = "SELECT name,password,gender,birthday,email,city,hobby,avatar,role FROM t_user WHERE `name` =? AND `password` =? AND role =?";
        return queryRunner.query(sql, new BeanHandler<>(Entity.class), name, password, role);
    }

    @Override
    public int modifyPassword(String name, String oldPassword, String newPassword) throws SQLException {
        String sql = "UPDATE t_user SET `password` =? WHERE `name` =? AND `password` =?";
        return queryRunner.update(sql, newPassword, name, oldPassword);
    }
}
