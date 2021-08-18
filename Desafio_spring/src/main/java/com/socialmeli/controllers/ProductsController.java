package com.socialmeli.controllers;

import com.socialmeli.dtos.products.PostRequestDTO;
import com.socialmeli.dtos.products.PostXUserDTO;
import com.socialmeli.dtos.user.UserDTO;
import com.socialmeli.exceptions.PostException;
import com.socialmeli.exceptions.UserException;
import com.socialmeli.models.products.PostModel;
import com.socialmeli.service.products.IProductsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private IProductsService productsService;
    private ModelMapper modelMapper;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
        this.modelMapper = new ModelMapper();
    }

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/newpost")
    public void newPost(@RequestBody PostRequestDTO postModel) throws PostException, HttpMessageNotReadableException {
        this.productsService.newPost(this.modelMapper.map(postModel, PostModel.class));
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que
    //un usuario sigue en las últimas dos semanas (para esto tener en cuenta
    //ordenamiento por fecha, publicaciones más recientes primero).
    //US 0009: Ordenamiento por fecha ascendente y descendente
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostXUserDTO> getPostsByUserId(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order) throws PostException {
        PostXUserDTO postXUser = this.modelMapper.map(this.productsService.getPostsByUserId(userId, order), PostXUserDTO.class);
        return new ResponseEntity<>(postXUser, HttpStatus.OK);
    }

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/newpromopost")
    public void newPromoPost(@RequestBody PostRequestDTO postModel) throws PostException, HttpMessageNotReadableException {
        this.productsService.newPromoPost(this.modelMapper.map(postModel, PostModel.class));
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado
    //vendedor
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<UserDTO> getUserCountPromo(@PathVariable Integer userId) throws UserException {
        UserDTO userDTO = this.modelMapper.map(this.productsService.getUserCountPromoById(userId),UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //US 0012: Obtener un listado de todos los productos en promoción de un
    //determinado vendedor
    @GetMapping("/{userId}/list")
    public ResponseEntity<PostXUserDTO> getPromotiosByUser(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order) throws PostException {
        PostXUserDTO postXUser = this.modelMapper.map(this.productsService.getPromotionsByUser(userId, order), PostXUserDTO.class);
        return new ResponseEntity<>(postXUser, HttpStatus.OK);
    }

}
