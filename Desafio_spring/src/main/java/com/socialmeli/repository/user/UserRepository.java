package com.socialmeli.repository.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.user.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    private static List<UserModel> userModelList;

    public UserRepository() throws UserException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:socialmeli.json");
            this.userModelList = objectMapper.readValue(file, new TypeReference<List<UserModel>>() {});
        }catch ( Exception exception)
        {
            throw new UserException(exception.getMessage());
        }
    }

    @Override
    public UserModel getUserById(Integer userId) throws UserException {
        return this.userModelList
                .stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserException("Usuario no encontrado"));
    }

    @Override
    public UserModel getUserInList(Integer userId, List<UserModel> userModelList) {
        return userModelList
                .stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actionOfUser(Integer actionUserId, Integer userToAction, String action) throws UserException {
        UserModel userModel = getUserById(actionUserId);
        UserModel userModelToFollow = getUserById(userToAction);

        List<UserModel> userModelsFollowers = userModel.getFollowers();
        List<UserModel> userModelsFollowed = userModel.getFollowed();
        List<UserModel> userFollowFollowers = userModelToFollow.getFollowers();
        List<UserModel> userFollowFollowed = userModelToFollow.getFollowed();

        this.userModelList.remove(userModel);
        this.userModelList.remove(userModelToFollow);

        if (action.equals("follow")){

            UserModel userModel1 = new UserModel();
            userModel1.setUserId(userModel.getUserId());
            userModel1.setUserName(userModel.getUserName());

            UserModel userModelToFollow1 = new UserModel();
            userModelToFollow1.setUserId(userModelToFollow.getUserId());
            userModelToFollow1.setUserName(userModelToFollow.getUserName());

            userFollowFollowers.add(userModel1);
            userModelsFollowed.add(userModelToFollow1);
        }else {
            userFollowFollowers.removeIf(users -> users.getUserId() == actionUserId);
            userModelsFollowed.removeIf(used -> used.getUserId() == userToAction);
        }

        userModel.setFollowers(userModelsFollowers);
        userModel.setFollowed(userModelsFollowed);
        userModelToFollow.setFollowed(userFollowFollowed);
        userModelToFollow.setFollowers(userFollowFollowers);

        this.userModelList.add(userModel);
        this.userModelList.add(userModelToFollow);
    }

}
