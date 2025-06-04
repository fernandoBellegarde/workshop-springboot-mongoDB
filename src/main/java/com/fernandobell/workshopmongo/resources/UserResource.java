package com.fernandobell.workshopmongo.resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fernandobell.workshopmongo.UserDTO.UserDTO;
import com.fernandobell.workshopmongo.domain.User;
import com.fernandobell.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Annotation para falar que a classe é um recurso REST
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping // Annotation para validar o method GET
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findeAll(); // Busca la no banco de dados os usuarios
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList(); // converte a lista de User para UserDTO
        return ResponseEntity.ok().body(listDto); // Devolve a lista
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // Annotation para validar o method GET
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // Devolve a lista
    }
}
