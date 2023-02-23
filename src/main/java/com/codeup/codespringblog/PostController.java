package com.codeup.codespringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String index(Model model) {
        ArrayList<Post> postslist = new ArrayList<>();
        Post first = new Post(1, "First Post", "God I hope this thing works");
        Post second = new Post(2, "Second Post", "Phew");
        postslist.add(first);
        postslist.add(second);
        model.addAttribute("postslist", postslist);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String idpage(@PathVariable int id, Model model) {
        Post posts = new Post(id, "First Post", "God I hope this thing works");
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }

}
