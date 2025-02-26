package com.sistema.biblioteca.service;

import com.sistema.biblioteca.DTO.UserRequestDTO;
import com.sistema.biblioteca.DTO.UserResponseDTO;
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

    public List<UserResponseDTO> findUserByStatusActive(){
        List<Users> userList = userRepository.findByStatusActive();
        return userList.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public UserResponseDTO findUserById(Long id){
      Optional<Users> user = userRepository.findById(id);
      if(!user.isPresent()){
          throw new RuntimeException("not_found");
      }
        return new UserResponseDTO(user.get());
    }

    public List<UserResponseDTO> findByName(String name){
        List<Users> userList  = userRepository.findByName(name);
        if(userList.isEmpty()){
            throw new RuntimeException("not_found");
        }
        return userList.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public UserResponseDTO createUser(UserRequestDTO userDto){
        Users users = new Users();//create Request DTO
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setBirthdate(userDto.getBirthdate());
        users.setTelephone(userDto.getTelephone());
        users.setType_doc(userDto.getType_doc());
        users.setDoc(userDto.getDoc());
        users.setStatus(userDto.getStatus());
        userRepository.save(users);
        return new UserResponseDTO(users); // Response user dto
    }

    public UserResponseDTO updateUser(Users user){//create Request DTO
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
        return new UserResponseDTO(userUpdate);// Response user dto
    }

    public void deleteUser(Long id){
        try{
            //passar metodo finduser
            Optional<Users> user = userRepository.findById(id);
            if(user.get().getStatus().equals("Ativo")){
                Users userDelete = user.get();
                userDelete.setStatus("Inativo");
                userRepository.save(userDelete);

            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Id não corresponde a nenhum usuário");
        }

    }
}
