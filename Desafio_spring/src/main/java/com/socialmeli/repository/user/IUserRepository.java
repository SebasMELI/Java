package com.socialmeli.repository.user;

import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.user.UserModel;

import java.util.List;

public interface IUserRepository {
    UserModel getUserById(Integer userId) throws UserException;
    UserModel getUserInList(Integer userId, List<UserModel> userModelList);
    void actionOfUser(Integer actionUserId, Integer userToAction, String action) throws UserException;
}
