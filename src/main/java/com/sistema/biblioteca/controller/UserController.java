package com.sistema.biblioteca.controller;


import com.sistema.biblioteca.DTO.UserRequestDTO;
import com.sistema.biblioteca.DTO.UserResponseDTO;
import com.sistema.biblioteca.model.Users;
import com.sistema.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findUserByStatusActive(){
        return ResponseEntity.ok(userService.findUserByStatusActive());
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseDTO>> findUserByName(@PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserById(@PathVariable Long id){
        try{
            UserResponseDTO user = userService.findUserById(id);

        } catch (RuntimeException e) {
            if(e.getMessage().equals("not_found")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
            }
        }
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }
   @PutMapping
    public UserResponseDTO updateUser(@RequestBody Users user){
        return userService.updateUser(user);
    }
    @PostMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
