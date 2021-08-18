package com.socialmeli.repository.products;

import com.socialmeli.models.products.PostModel;

import java.util.List;

public interface IProductsRepository {
    PostModel getPostById(Integer postId);
    List<PostModel> getPostsByUserId(Integer userId);
    void newPost(PostModel postRequest);
    List<PostModel>  getUserCountPromoById(Integer userId);

}
