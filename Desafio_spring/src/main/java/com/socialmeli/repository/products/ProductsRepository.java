package com.socialmeli.repository.products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.exceptions.PostException;
import com.socialmeli.models.products.PostModel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductsRepository implements IProductsRepository{

    private static List<PostModel> postModelList;

    public ProductsRepository() throws PostException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File filePost = ResourceUtils.getFile("classpath:posts.json");
            this.postModelList = objectMapper.readValue(filePost, new TypeReference<List<PostModel>>() {});
        }catch ( Exception exception)
        {
            throw new PostException(exception.getMessage());
        }
    }

    @Override
    public PostModel getPostById(Integer postId) {
        return this.postModelList
                .stream()
                .filter(p -> p.getId_post() == postId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PostModel> getPostsByUserId(Integer userId) {
        return this.postModelList
                .stream()
                // El localdate se usa para comparar entre fechas
                .filter(p -> p.getUserId() == userId && p.getHasPromo() == false && LocalDate.now()
                        .minusDays(14)
                        .isBefore(p.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                .collect(Collectors.toList());
    }

    @Override
    public void newPost(PostModel postRequest) {
        this.postModelList.add(postRequest);
    }

    @Override
    public List<PostModel> getUserCountPromoById(Integer userId) {
        return this.postModelList
                .stream()
                .filter(user -> user.getUserId() == userId && user.getHasPromo() == true)
                .collect(Collectors.toList());
    }


}
