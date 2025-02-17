package com.sistema.biblioteca.service;

import com.sistema.biblioteca.DTO.UserDTO;
import com.sistema.biblioteca.model.Users;
import com.sistema.biblioteca.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<UserDTO> findUserByStatusActive(){
        List<Users> userList = userRepository.findByStatusActive();
        return userList.stream()
                .map(com.sistema.biblioteca.DTO.UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO findUserById(Long id){
      Users user = userRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        return new UserDTO(user);
    }

    public UserDTO saveUser(Users user){
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    public UserDTO updateUser(Users user){
        Users userUpdate = userRepository.findById(user.getId())
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

        if(userUpdate.getId().equals(user.getId())) {
            userUpdate.setName(user.getName());
            userUpdate.setDoc(user.getDoc());
            userUpdate.setType_doc(user.getType_doc());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setTelephone(user.getTelephone());
            userUpdate.setBirthdate(user.getBirthdate());
            userUpdate.setStatus(user.getStatus());
            userUpdate = userRepository.save(userUpdate);
        }
        return new UserDTO(userUpdate);
    }

    public void deleteUser(Long id){
        try{
            Optional<Users> user = userRepository.findById(id);
            if(user.get().getStatus().contains("Ativo")){
                Users userDelete = user.get();
                userDelete.setStatus("Inativo");
                userRepository.save(userDelete);
                this.saveUser(userDelete);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Id não corresponde a nenhum usuário");
        }

    }
}
