package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    //    预编译对象
    public static PreparedStatement preparedStatement;
    //    结果集对象
    public static ResultSet resultSet;

    //属性常量，创建配置文件对象
    private static final Properties PROP = new Properties();

    //创建一个ThreadLocal线程池常量
    static final ThreadLocal<Connection> TL = new ThreadLocal<>();

    //    创建连接池对象
    public static DataSource dataSource;


    static {
        try {
            //PROP.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\untitled\\src\\main\\resources\\jdbc.properties"));
//            读取配置文件
            PROP.load(DBUtils.class.getResourceAsStream("/jdbc.properties"));

//          用连接池工厂对象根据配置文件创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(PROP);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获得连接对象的方法,
     */
    public static Connection getConnection() throws SQLException {
       /* if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(PROP.getProperty("url"), PROP.getProperty("username"), PROP.getProperty("password"));
        }
        return connection;*/
        Connection connection = TL.get();
        System.out.println("ThreadLocal初始内存地址:" + connection);

        if (connection == null) {
//用druid连接池获得连接对象
            connection = dataSource.getConnection();
//      自己创建新的连接对象   connection=DriverManager.getConnection(PROP.getProperty("url"), PROP.getProperty("username"), PROP.getProperty("password"));
            System.out.println("第一次创建连接内存地址:" + connection);
            TL.set(connection);
        }
        return connection;
    }

    /**
     * 增删改的方法
     */
    public static int update(String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        return preparedStatement.executeUpdate();
    }

    /**
     * 查询的方法
     */
    public static ResultSet query(String sql, Object... args) throws SQLException {

        Connection connection = getConnection();
        System.out.println("查询_连接内存地址:" + connection);
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        return preparedStatement.executeQuery();
    }

    public static int[] updateBatch(String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {

            for (int j = 0; j < args.length; j++) {
                preparedStatement.setObject(j + 1, args[j]);
            }
            preparedStatement.addBatch();
            if (i % 2 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        return preparedStatement.executeBatch();
    }

    /**
     * 开启手动事务
     *
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    /**
     * 提交事务
     *
     * @throws SQLException
     */
    public static void commit() throws SQLException {
        Connection connection = getConnection();
        connection.commit();
    }

    /**
     * 事务回滚
     *
     * @throws SQLException
     */
    public static void rollback() throws SQLException {
        Connection connection = getConnection();
        connection.rollback();
    }

    /**
     * 关闭对象的方法
     */
    public static void close(AutoCloseable... objs) throws Exception {
        if (objs != null) {
//            如果动态参数不为空
            for (int i = 0; i < objs.length; i++) {
                if (objs[i] != null) {
                    objs[i].close();
                    System.out.println("第" + i + "个" + objs[i] + "已关闭");
                }
            }
//           将druid创建的连接对象从线程池中移除
            TL.remove();
        }
    }
}