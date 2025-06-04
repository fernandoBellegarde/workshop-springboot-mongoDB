package com.fernandobell.workshopmongo.services;

import com.fernandobell.workshopmongo.domain.User;
import com.fernandobell.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findeAll() {
        return repo.findAll();
    }
}
