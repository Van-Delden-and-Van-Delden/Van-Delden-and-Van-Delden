package com.codeup.codespringblog.controllers;

import com.codeup.codespringblog.models.Post;
import com.codeup.codespringblog.models.User;
import com.codeup.codespringblog.repositories.PostRepository;
import com.codeup.codespringblog.repositories.UserRepository;
import com.codeup.codespringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }



    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> postslist = postDao.findAll();
        model.addAttribute("postslist", postslist);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String idpage(@PathVariable Long id, Model model) {
        Post posts = postDao.findPostsById(id);
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostsById(id);
        if (user.getId() != post.getUser().getId()){
            List<Post> postslist = postDao.findAll();
            model.addAttribute("postslist", postslist);
            return "redirect:/posts";
        }
        model.addAttribute("post", postDao.findPostsById(id));
        return "posts/edit";
    }

}
