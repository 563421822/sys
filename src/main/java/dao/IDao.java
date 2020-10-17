package dao;

import entity.Entity;

import java.sql.SQLException;

public interface IDao {
    Entity login(String role, String name, String password) throws SQLException;

    int modifyPassword(String name, String oldPassword, String newPassword) throws SQLException;
}
