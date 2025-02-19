package com.sistema.biblioteca.controller;


import com.sistema.biblioteca.DTO.UserDTO;
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
    public ResponseEntity<List<UserDTO>> findUserByStatusActive(){
        return ResponseEntity.ok(userService.findUserByStatusActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserById(@PathVariable Long id){
        try{
            UserDTO user = userService.findUserById(id);

        } catch (RuntimeException e) {
            if(e.getMessage().equals("not_found")){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
            }
        }
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }
   @PutMapping
    public UserDTO updateUser(@RequestBody Users user){
        return userService.updateUser(user);
    }
    @PostMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
