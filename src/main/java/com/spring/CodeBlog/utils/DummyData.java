package com.spring.CodeBlog.utils;

import com.spring.CodeBlog.Repository.PostRepository;
import com.spring.CodeBlog.model.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    PostRepository postRepository;

    //@PostConstruct
    public void savePosts() {

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Samuel Silva");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("asddomdsaldamsodmoasmdomasomdoamsdomaosmdosmodmoasmdomasomdoasmdomasomdo");

        Post post2 = new Post();
        post2.setAutor("Matheus Silva");
        post2.setData(LocalDate.now());
        post2.setTitulo("Python");
        post2.setTexto("asddomdsaldamsodmoasmdomasomdoamsdomaosmdosmodmoasmdomasomdoasmdomasomdo");

        postList.add(post1);
        postList.add(post2);

        for (Post post:postList) {
            Post postSaved = postRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
