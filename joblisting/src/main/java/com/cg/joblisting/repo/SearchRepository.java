package com.cg.joblisting.repo;

import com.cg.joblisting.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface SearchRepository {
    List<Post> findByText(String text);
}
