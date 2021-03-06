package com.github.jaredtan95.spittr.user;


import com.github.jaredtan95.spittr.user.domain.User;
import com.github.jaredtan95.spittr.user.repository.UserRepository;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 * 用户服务提供者
 */
public class UserServiceProvider implements UserService {
    private UserRepository userRepository;

    public UserServiceProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user) ? user : new User();
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public int getMax() {
        return userRepository.count();
    }

    @Override
    public User getByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    @Override
    public List<User> getByNickName(String nickname) {
        return userRepository.findByNickName(nickname);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User loginVali(String name, String pwd) {
        return userRepository.isExists(name,pwd);
    }
}
