package com.fernandobell.workshopmongo.resources;

import com.fernandobell.workshopmongo.UserDTO.UserDTO;
import com.fernandobell.workshopmongo.domain.Post;
import com.fernandobell.workshopmongo.domain.User;
import com.fernandobell.workshopmongo.services.PostService;
import com.fernandobell.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // ✅ Indica que essa classe é um controlador REST
@RequestMapping(value = "/posts") // ✅ Define o endpoint base como /users
public class PostResource {

    @Autowired // ✅ Injeta a dependência do serviço
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
