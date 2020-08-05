package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.UserDAO;
import pl.patryk.wine.model.User;
import pl.patryk.wine.service.IUserService;

@Service
public class UserService implements IUserService {

    private UserDAO userDAO;

    public UserService() {
    }

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findUserById(Long id) {
        return this.userDAO.getOne(id);
    }
}
