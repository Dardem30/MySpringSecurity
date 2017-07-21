package by.DAO;

import by.model.User;

/**
 * Created by Роман on 21.07.2017.
 */
public interface DAOUser {
    User findByUsername(String username);
}
