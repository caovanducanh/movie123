package hsf302.myMovie.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class GoogleController {

    @GetMapping("/login")
    public String googleLoginPage() {
        return "login";  // Trả về trang đăng nhập Google
    }


}
