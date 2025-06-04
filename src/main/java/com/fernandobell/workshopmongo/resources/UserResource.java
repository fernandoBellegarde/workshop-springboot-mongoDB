package com.fernandobell.workshopmongo.resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fernandobell.workshopmongo.UserDTO.UserDTO;
import com.fernandobell.workshopmongo.domain.User;
import com.fernandobell.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
