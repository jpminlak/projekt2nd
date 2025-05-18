package viewtemp.vt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import viewtemp.vt1.util.FileDataUtil;
import viewtemp.vt1.vo.WriteVO;

import java.util.List;

@Controller
public class WriteController {

    @GetMapping("/write")
    public String write() {
        return "/write/write";
    }

    //@Inject
    //FileDataUtil filedatautil;

//    @PostMapping(value = "/write/accident")
//    public String writeAccident(@ModelAttribute WriteVO writevo, MultipartFile[] file) throws Exception{
//        List<String> files = filedatautil.fileUpload(file);
//        return "redirect:/";
//    }

}
