package com.cg.joblisting.repo;

import com.cg.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepo extends MongoRepository<Post,String> {

}
