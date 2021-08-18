package com.socialmeli.service.user;

import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.user.UserModel;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow) throws UserException;
    UserModel getCountFollowersForUser(Integer userId) throws UserException;
    UserModel getfollowersByUser(Integer userId, String order) throws UserException;
    UserModel getfollowedByUser(Integer userId, String order) throws UserException;
    void unFollowUser(Integer userId, Integer userIdToUnFollow) throws UserException;
}
