package com.socialmeli.service.products;

import com.socialmeli.exceptions.PostException;
import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.products.PostModel;
import com.socialmeli.models.products.PostXUserModel;
import com.socialmeli.models.user.UserModel;
import com.socialmeli.repository.products.IProductsRepository;
import com.socialmeli.repository.user.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService{

    private IProductsRepository productsRepository;
    private IUserRepository userRepository;

    public ProductsService(IProductsRepository productsRepository, IUserRepository userRepository) {
        this.productsRepository = productsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void newPost(PostModel postModel) throws PostException {
        PostModel validatePost = this.productsRepository.getPostById(postModel.getId_post());
        if (validatePost != null)
            throw new PostException("El post ya ha sido creado");
        postModel.setHasPromo(false);
        postModel.setDiscount(0.0);
        this.productsRepository.newPost(postModel);
    }

    @Override
    public PostXUserModel getPostsByUserId(Integer userId, String order) throws PostException {
        PostXUserModel userModel = new PostXUserModel();
        List<PostModel> postModelList = this.productsRepository.getPostsByUserId(userId);
        if (postModelList.size() == 0)
            throw new PostException("No se encontraron post de ese usuario.");

        postModelList.stream().forEach((ps) -> {
            ps.setUserId(null);
            ps.setHasPromo(null);
            ps.setDiscount(null);
        });

        if(order != null)
            switch (order){
                case "date_asc" : postModelList.sort((o1,o2) -> o1.getDate().compareTo(o2.getDate())); break;
                case "date_desc" : postModelList.sort((o1,o2) -> o2.getDate().compareTo(o1.getDate())); break;
            }

        userModel.setUserId(userId);
        userModel.setPosts(postModelList);
        return userModel;
    }

    @Override
    public void newPromoPost(PostModel postModel) throws PostException {
        PostModel validatePost = this.productsRepository.getPostById(postModel.getId_post());
        if (validatePost != null)
            throw new PostException("El post ya ha sido creado");
        if(postModel.getHasPromo() == null) postModel.setHasPromo(false);
        if(postModel.getDiscount() == null) postModel.setDiscount(0.0);

        if (postModel.getHasPromo() == false || postModel.getDiscount() == 0.0)
            throw new PostException("Este post no califica como promoción");

        this.productsRepository.newPost(postModel);
    }

    @Override
    public UserModel getUserCountPromoById(Integer userId) throws UserException {
        UserModel userModel = new UserModel();
        UserModel entUser = this.userRepository.getUserById(userId);
        userModel.setUserId(entUser.getUserId());
        userModel.setUserName(entUser.getUserName());
        userModel.setFollowers_count(this.productsRepository.getUserCountPromoById(userId).size());
        return userModel;
    }

    @Override
    public PostXUserModel getPromotionsByUser(Integer userId, String order) throws PostException {
        PostXUserModel userModel = new PostXUserModel();
        List<PostModel> postModelList = this.productsRepository.getUserCountPromoById(userId);
        if (postModelList.size() == 0)
            throw new PostException("No se encontraron post de ese usuario.");

        if(order != null)
            switch (order){
                case "name_asc" : postModelList.sort((o1,o2) -> o1.getDetail().getProductName().compareTo(o2.getDetail().getProductName())); break;
                case "name_desc" : postModelList.sort((o1,o2) -> o2.getDetail().getProductName().compareTo(o1.getDetail().getProductName())); break;
            }

        postModelList.stream().forEach(p -> p.setUserId(null));
        userModel.setUserId(userId);
        userModel.setPosts(postModelList);
        return userModel;
    }
}
