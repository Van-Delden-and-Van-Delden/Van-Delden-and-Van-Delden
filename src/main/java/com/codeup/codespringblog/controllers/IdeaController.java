package com.codeup.codespringblog.controllers;

import com.codeup.codespringblog.models.Idea;
import com.codeup.codespringblog.models.Post;
import com.codeup.codespringblog.models.User;
import com.codeup.codespringblog.repositories.IdeaRepository;
import com.codeup.codespringblog.repositories.PostRepository;
import com.codeup.codespringblog.repositories.UserRepository;
import com.codeup.codespringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IdeaController {
    private final IdeaRepository ideaDao;

    private final UserRepository userDao;

    private final EmailService emailService;

    public IdeaController(IdeaRepository ideaDao, UserRepository userDao, EmailService emailService) {
        this.ideaDao = ideaDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }



    @GetMapping("/ideas")
    public String index(Model model) {
        List<Idea> ideaslist = ideaDao.findAll();
        model.addAttribute("ideaslist", ideaslist);
        return "ideas/index";
    }

    @GetMapping("/ideas/{id}")
    public String idpage(@PathVariable Long id, Model model) {
        Idea ideas = ideaDao.findIdeasById(id);
        model.addAttribute("ideas", ideas);
        return "ideas/show";
    }

    @GetMapping("/ideas/create")
    public String create(Model model) {
        model.addAttribute("idea", new Idea());
        return "ideas/create";
    }

    @PostMapping("ideas/create")
    public String createIdea(@ModelAttribute Idea idea) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        idea.setUser(user);
        ideaDao.save(idea);
//        emailService.prepareAndSend(idea);
        return "redirect:/ideas";
    }

    @GetMapping("ideas/{id}/edit")
    public String editIdea(Model model, @PathVariable long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Idea idea = ideaDao.findIdeasById(id);
        if (user.getId() != idea.getUser().getId()){
            List<Idea> ideaslist = ideaDao.findAll();
            model.addAttribute("ideaslist", ideaslist);
            return "redirect:/ideas";
        }
        model.addAttribute("idea", ideaDao.findIdeasById(id));
        return "ideas/edit";
    }

}
