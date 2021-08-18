package com.socialmeli.controllers;

import com.socialmeli.dtos.user.UserDTO;
import com.socialmeli.exceptions.UserException;
import com.socialmeli.service.user.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;
    private ModelMapper modelMapper;

    public UserController(IUserService userService){
        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserException, HttpMessageNotReadableException {
        this.userService.followUser(userId, userIdToFollow);
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un
    //determinado vendedor
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDTO> getCountFollowersForUser(@PathVariable Integer userId) throws UserException {
        UserDTO userDTO = this.modelMapper.map(this.userService.getCountFollowersForUser(userId), UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado
    //vendedor (¿Quién me sigue?)
    //US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getfollowersByUser(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order) throws UserException {
        UserDTO userDTO = this.modelMapper.map(this.userService.getfollowersByUser(userId, order), UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un
    //determinado usuario (¿A quién sigo?)
    //US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getfollowedByUser(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order) throws UserException {
        UserDTO userDTO = this.modelMapper.map(this.userService.getfollowedByUser(userId, order), UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado
    //vendedor.
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public void unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserException, HttpMessageNotReadableException {
        this.userService.unFollowUser(userId, userIdToUnfollow);
    }
}
