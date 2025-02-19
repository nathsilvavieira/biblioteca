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
      Optional<Users> user = userRepository.findById(id);
      if(!user.isPresent()){
          throw new RuntimeException("not_found");
      }
        return new UserDTO(user.get());
    }

    public UserDTO saveUser(Users user){//create Request DTO
        user = userRepository.save(user);
        return new UserDTO(user); // Response user dto
    }

    public UserDTO updateUser(Users user){//create Request DTO
        Users userUpdate = userRepository.findById(user.getId())
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

       // if(userUpdate.getId().equals(user.getId())) {
            userUpdate.setName(user.getName());
            userUpdate.setDoc(user.getDoc()); //n faz sentido
            userUpdate.setType_doc(user.getType_doc());//
            userUpdate.setEmail(user.getEmail());
            userUpdate.setTelephone(user.getTelephone());
            userUpdate.setBirthdate(user.getBirthdate());//
            userUpdate.setStatus(user.getStatus());
            userUpdate = userRepository.save(userUpdate);
        //}
        return new UserDTO(userUpdate);// Response user dto
    }

    public void deleteUser(Long id){
        try{
            //passar metodo finduser
            Optional<Users> user = userRepository.findById(id);
            if(user.get().getStatus().equals("Ativo")){
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
