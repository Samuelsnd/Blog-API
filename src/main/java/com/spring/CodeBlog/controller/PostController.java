package com.spring.CodeBlog.controller;

import com.spring.CodeBlog.model.Post;
import com.spring.CodeBlog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PostController {


    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public ModelAndView getPosts() {
    ModelAndView mv = new ModelAndView("posts");
    List<Post> posts = postService.findAll();
    mv.addObject("posts", posts);
    return mv;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView getPostsDetails(@PathVariable("id") long id ) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = postService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping(value = "/newpost")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping("/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        postService.save(post);
        return "redirect:/posts";
    }

}
