package com.codeup.codespringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
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
    public String create() {
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name="body") String body) {
        Post post = new Post(title,body);
        postDao.save(post);
        return "redirect:/posts";
    }

}
