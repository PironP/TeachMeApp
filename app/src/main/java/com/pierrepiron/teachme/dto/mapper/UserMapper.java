package com.pierrepiron.teachme.dto.mapper;

import com.pierrepiron.teachme.dto.model.EUser;
import com.pierrepiron.teachme.dto.model.User;

import java.util.ArrayList;

public class UserMapper {

    public User map(EUser eUser) {
        User user = new User();

        user.setId_user(eUser.getId_user());
        user.setFirstname(eUser.getFirstname());
        user.setLastname(eUser.getLastname());
        user.setEmail(eUser.getEmail());
        user.setTel(eUser.getTel());
        return user;
    }

    public ArrayList<User> map(ArrayList<EUser> eUserList) {
        ArrayList<User> userList = new ArrayList<>();

        for (EUser eUser : eUserList) {
            userList.add(this.map(eUser));
        }

        return userList;
    }

}
