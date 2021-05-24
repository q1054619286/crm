package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.settings.domain.User;

import java.util.List;

public interface UserDao {

     List<User> getUserList();

    User login(User user);
}
