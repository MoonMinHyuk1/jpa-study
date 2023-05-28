package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")    //링크에 슬래시
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello";     //hello.html
    }

}
