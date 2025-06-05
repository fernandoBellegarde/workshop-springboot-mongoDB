package com.fernandobell.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import com.fernandobell.workshopmongo.UserDTO.UserDTO;
import com.fernandobell.workshopmongo.domain.User;
import com.fernandobell.workshopmongo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController // ✅ Indica que essa classe é um controlador REST
@RequestMapping(value = "/users") // ✅ Define o endpoint base como /users
public class UserResource {

    @Autowired // ✅ Injeta a dependência do serviço
    private UserService service;

    @GetMapping // ✅ Mapeia requisições GET para /users
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll(); // ✅ Busca todos os usuários no banco
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList(); // ✅ Converte a lista de User para UserDTO
        return ResponseEntity.ok().body(listDto); // ✅ Retorna 200 OK com a lista no corpo
    }

    @GetMapping(value = "/{id}") // ✅ Outra forma (melhor) de fazer o mesmo que RequestMapping com method=GET
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id); // ✅ Busca o usuário pelo ID
        return ResponseEntity.ok().body(new UserDTO(obj)); // ✅ Retorna 200 OK com o DTO no corpo
    }

    @PostMapping // ✅ Mapeia requisições POST para /users
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto); // ✅ Converte o DTO para entidade User
        obj = service.insert(obj); // ✅ Insere o usuário no banco (ID gerado pelo MongoDB)

        // ✅ Cria a URI do novo recurso /users/{id}
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build(); // ✅ Retorna 201 Created que é o codigo que retorna que foi criado
    }

    @DeleteMapping(value = "/{id}") // ✅ Outra forma (melhor) de fazer o mesmo que RequestMapping com method=GET
    public ResponseEntity<UserDTO> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
