package com.fernandobell.workshopmongo.resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fernandobell.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotation para falar que a classe é um recurso REST
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping // Annotation para validar o method GET
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("1", "Alex Green", "alex@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
