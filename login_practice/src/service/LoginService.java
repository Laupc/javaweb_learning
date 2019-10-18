package service;

import pojo.User;

public interface LoginService {
    User checkLoginService(String username, String password);
    User checkUseridService(String user_id);
}
