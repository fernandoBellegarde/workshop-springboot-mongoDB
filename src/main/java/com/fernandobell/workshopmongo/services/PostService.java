package com.fernandobell.workshopmongo.services;

import com.fernandobell.workshopmongo.UserDTO.UserDTO;
import com.fernandobell.workshopmongo.domain.Post;
import com.fernandobell.workshopmongo.domain.User;
import com.fernandobell.workshopmongo.repository.PostRepository;
import com.fernandobell.workshopmongo.repository.UserRepository;
import com.fernandobell.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
