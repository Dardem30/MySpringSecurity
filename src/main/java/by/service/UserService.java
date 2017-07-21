package by.service;

import by.DAO.DAOUserImpl;
import by.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Роман on 21.07.2017.
 */
@Service
public class UserService {
    private DAOUserImpl daoUser;

    public void setDaoUser(DAOUserImpl daoUser) {
        this.daoUser = daoUser;
    }
    @Transactional
    public User findByUsername(String username){
        return this.daoUser.findByUsername(username);
    }
}
