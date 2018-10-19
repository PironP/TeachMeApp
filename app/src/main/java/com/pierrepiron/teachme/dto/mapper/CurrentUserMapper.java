package com.pierrepiron.teachme.dto.mapper;

import com.pierrepiron.teachme.dto.model.CurrentUser;
import com.pierrepiron.teachme.dto.model.ECurrentUser;

public class CurrentUserMapper {

    public void map(ECurrentUser eCurrentUser) {

        CurrentUser currentUser = CurrentUser.getInstance();

        currentUser.setId(eCurrentUser.getId());
        currentUser.setToken(eCurrentUser.getToken());
        currentUser.setLoggedIn(true);
    }
}
