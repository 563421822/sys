package service;

import entity.Entity;

import java.sql.SQLException;

public interface ICommonService {
    //    公共登录
    Entity login(String name, String password, String role) throws SQLException;

    //公共修改密码
    int modifyPassword(String name, String oldPassword, String newPassword) throws SQLException;
}
