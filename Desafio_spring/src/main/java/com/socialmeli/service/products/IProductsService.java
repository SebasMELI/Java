package com.socialmeli.service.products;

import com.socialmeli.exceptions.PostException;
import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.products.PostModel;
import com.socialmeli.models.products.PostXUserModel;
import com.socialmeli.models.user.UserModel;

public interface IProductsService {
    void newPost(PostModel postModel) throws PostException;
    PostXUserModel getPostsByUserId(Integer userId, String order) throws PostException;
    void newPromoPost(PostModel postModel) throws PostException;
    UserModel getUserCountPromoById(Integer userId) throws UserException;
    PostXUserModel getPromotionsByUser(Integer userId, String order) throws PostException;
}
