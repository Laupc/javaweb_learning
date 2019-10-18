package service.impl;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import pojo.User;
import service.LoginService;

public class LoginServiceImpl implements LoginService {

    LoginDao loginDao = new LoginDaoImpl();

    @Override
    public User checkLoginService(String username, String password) {
        return loginDao.checkLoginDao(username,password);
    }

    @Override
    public User checkUseridService(String user_id) {
        return loginDao.checkUseridDao(user_id);
    }
}
