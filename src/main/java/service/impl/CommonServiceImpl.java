package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import entity.Entity;
import service.ICommonService;

import java.sql.SQLException;

public class CommonServiceImpl implements ICommonService {
    /**
     * 通用的登录功能
     *
     * @param name
     * @param password
     * @param role
     * @return
     * @throws SQLException
     */
    @Override
    public Entity login(String name, String password, String role) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.login(name, password, role);
    }

    @Override
    public int modifyPassword(String name, String oldPassword, String newPassword) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.modifyPassword(name, oldPassword, newPassword);
    }
}
