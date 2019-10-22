package dao.impl;

import dao.LoginDao;
import pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String username, String password) {
        //声明JDBC对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //声明存储对象
        User user = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_javaeelearning","root","123456");
            //创建SQL命令
            String sql = "select * from user where username=? and password = ? ";
            //创建SQL命令对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //执行
            resultSet = preparedStatement.executeQuery();
            //遍历执行结果
            while (resultSet.next()){
                user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回
        return user;
    }

    @Override
    public User checkUseridDao(String user_id) {
        //声明JDBC对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //声明存储对象
        User user = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_javaeelearning","root","123456");
            //创建SQL命令
            String sql = "select * from user where user_id=?";
            //创建SQL命令对象
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,user_id);
            //执行
            resultSet = preparedStatement.executeQuery();
            //遍历执行结果
            while (resultSet.next()){
                user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回
        return user;
    }
}
