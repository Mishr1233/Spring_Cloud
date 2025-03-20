package com.cg.joblisting.controller;

import com.cg.joblisting.model.Post;
import com.cg.joblisting.repo.PostRepo;
import com.cg.joblisting.repo.SearchRepository;
import com.cg.joblisting.repo.SearchRepositoryImp;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@ApiIgnore
@RestController
public class PostController {

     @Autowired
    PostRepo repo;

     @Autowired
     SearchRepositoryImp srepo;

@RequestMapping(value="/")
    public void  redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }

@GetMapping("/posts")
    public List<Post> getAllPosts(){
    return repo.findAll();
}

@GetMapping("/posts/{text}")
public List<Post> search(@PathVariable String text){
    return srepo.findByText(text);
}


@PostMapping("/post")
    public Post addPost(@RequestBody Post p){
    return repo.save(p);
}

}
