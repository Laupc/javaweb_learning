package dao;

import pojo.User;

public interface LoginDao {
    User checkLoginDao(String username,String password);
    User checkUseridDao(String user_id);
}
