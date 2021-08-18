package com.socialmeli.service.user;

import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.user.UserModel;
import com.socialmeli.repository.user.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws UserException {
        if(userId.equals(userIdToFollow))
            throw new UserException("No puedes seguirte a ti mismo");
        UserModel validateUserFollow = this.userRepository.getUserInList(userIdToFollow, this.userRepository.getUserById(userId).getFollowers());
        UserModel validateUser = this.userRepository.getUserInList(userId, this.userRepository.getUserById(userIdToFollow).getFollowers());
        if(validateUserFollow != null)
            throw new UserException("Ya sigues a este usuario");
        if (validateUser != null)
            throw new UserException("Ya sigues a este usuario");
        this.userRepository.actionOfUser(userId, userIdToFollow, "follow");
    }

    @Override
    public UserModel getCountFollowersForUser(Integer userId) throws UserException {
         UserModel userModel = this.userRepository.getUserById(userId);
         UserModel returnUser = new UserModel();
         returnUser.setUserId(userModel.getUserId());
         returnUser.setUserName(userModel.getUserName());
         returnUser.setFollowers_count(userModel.getFollowers_count());
         return returnUser;
    }

    @Override
    public UserModel getfollowersByUser(Integer userId, String order) throws UserException {
        UserModel userModel = this.userRepository.getUserById(userId);
        UserModel returnUser = new UserModel();
        returnUser.setUserId(userModel.getUserId());
        returnUser.setUserName(userModel.getUserName());
        List<UserModel> sortFollowed =userModel.getFollowers();
        if(order != null)
            switch (order){
                case "name_asc" : sortFollowed.sort((o1,o2) -> o1.getUserName().compareTo(o2.getUserName())); break;
                case "name_desc" : sortFollowed.sort((o1,o2) -> o2.getUserName().compareTo(o1.getUserName())); break;
            }
        returnUser.setFollowers(sortFollowed);
        return returnUser;
    }

    @Override
    public UserModel getfollowedByUser(Integer userId, String order) throws UserException {
        UserModel userModel = this.userRepository.getUserById(userId);
        UserModel returnUser = new UserModel();
        returnUser.setUserId(userModel.getUserId());
        returnUser.setUserName(userModel.getUserName());
        List<UserModel> sortFollowed = userModel.getFollowed();
        if(order != null)
            switch (order){
                case "name_asc" : sortFollowed.sort((o1,o2) -> o1.getUserName().compareTo(o2.getUserName())); break;
                case "name_desc" : sortFollowed.sort((o1,o2) -> o2.getUserName().compareTo(o1.getUserName())); break;
            }
        returnUser.setFollowed(sortFollowed);
        return returnUser;
    }

    @Override
    public void unFollowUser(Integer userId, Integer userIdToUnFollow) throws UserException {
        if(userId.equals(userIdToUnFollow))
            throw new UserException("No puedes quitarte el follow a ti mismo");
        if (this.userRepository.getUserById(userIdToUnFollow).getFollowers()
                .stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElse(null) == null)
            throw new UserException("No sigues a este usuario, no puedes quitarle el follow");
        this.userRepository.actionOfUser(userId, userIdToUnFollow, "unfollow");

    }
}
