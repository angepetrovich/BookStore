package org.example.dao;

import org.example.entity.User;

public interface UserDAO {
    User getUser(String username);

    public void saveUser(User user);
}
