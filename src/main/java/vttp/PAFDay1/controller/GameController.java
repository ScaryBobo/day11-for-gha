package vttp.PAFDay1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.PAFDay1.model.Game;
import vttp.PAFDay1.repository.GameRepository;

@Controller
@RequestMapping (path="/game")
public class GameController {
    @Autowired
    private GameRepository gameRepo;
    @GetMapping(path="/{gid}")

    public String getGameDetails (@PathVariable Integer gid, Model model ){
        Optional<Game> opt = gameRepo.getGameByGid(gid);

        if (opt.isEmpty())
            return "Nothing found";
        Game g = opt.get();
    
        model.addAttribute("game", g);
        return "result";
    }
}
