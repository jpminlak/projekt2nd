package tv2.demotv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String start(){
        System.out.println("첫 페이지 출력");
        return "start";
    }
}
