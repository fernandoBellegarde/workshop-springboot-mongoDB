package com.fernandobell.workshopmongo.repository;

import com.fernandobell.workshopmongo.domain.Post;
import com.fernandobell.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {



}
