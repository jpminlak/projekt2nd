package viewtemp.vt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping ("/")
    public String start() {
        return "start";
    }

    @GetMapping ("/board")
    public String board() {
        return "board";
    }

    @GetMapping ("/accident")
    public String accident() {
        return "accident";
    }

    @GetMapping ("/law")
    public String law() {
        return "law";
    }

    @GetMapping ("/insurance")
    public String insurance() {
        return "insurance";
    }

    @GetMapping ("/map")
    public String map() {
        return "map";
    }

    @GetMapping ("/message")
    public String message() {
        return "message";
    }
}
