package com.codeup.codespringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String diceGuess() {
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{diceroll}")
    public String numberPicked(@PathVariable String diceroll, Model model) {
        model.addAttribute("diceroll", diceroll);
        int random = (int) (Math.random() * 6) + 1;
        model.addAttribute("random", random);
        return "guessed";
    }

    }

