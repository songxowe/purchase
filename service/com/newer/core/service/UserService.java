package com.newer.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.core.dao.UserMapper;
import com.newer.core.util.Pager;
import com.newer.pojo.User;

@Service("userService")
public class UserService {
  @Resource(name = "userMapper")
  private UserMapper userMapper;

  public User login(String username, String password) {
    return userMapper.login(username, password);
  }

  public int changePassword(Integer id, String password) {
    return userMapper.changePassword(id, password);
  }

  // ** CRUD *********************************************************
  public int add(User user) {
    return userMapper.add(user);
  }

  public int modify(User user) {
    return userMapper.modify(user);
  }

  public int remove(Integer id) {
    return userMapper.remove(id);
  }

  public User findById(Integer id) {
    return userMapper.findById(id);
  }

  public Pager<User> findPager(Integer pageno, Integer pagesize, String sort, String order, String username,
      String status) {
    Pager<User> pager = new Pager<User>();
    pager.setRows(userMapper.findPager(pageno, pagesize, sort, order, username, status));
    pager.setTotal(userMapper.findPagerTotal(username, status));
    return pager;
  }
}
