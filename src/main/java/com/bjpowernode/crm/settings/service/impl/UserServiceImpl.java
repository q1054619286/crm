package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.SqlSessionUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct,String loginPwd,String ip) throws LoginException {

        User u=new User();
        u.setLoginAct(loginAct);
        u.setLoginPwd(loginPwd);


        User user=userDao.login(u);
        if(user==null){
            throw new LoginException("账号密码错误");
        }

        //如果程序能够成功的执行到该行，说明账号密码正确
        //需要继续向下验证其他3项信息

        //验证失效时间
        String expireTime=user.getExpireTime();
        String currentTime=DateTimeUtil.getSysTime();
        int count=expireTime.compareTo(currentTime);
        if(count<0){
            throw new LoginException("账号已失效");
        }

        //判定锁定状态
        String lockState=user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }

        /*String allowIps=user.getAllowIps();
        if(!allowIps.contains(ip)){
            throw new LoginException("ip地址受限");
        }*/


        return user;
    }
    @Override
    public List<User> getUserList() {
        List<User> list=  userDao.getUserList();
        return list;
    }
}
