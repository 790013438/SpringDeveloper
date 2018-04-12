package cn.pzhu.spring.web;

@Controller
@RequestMapping("/")
public class SpringBootVueLoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
