package hsf302.myMovie.controllers;

import hsf302.myMovie.models.User;
import hsf302.myMovie.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({ "/login"})
    public String showLoginPage() {
        return "login";
    }

    @GetMapping({"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("emailOrUsername") String emailOrUsername, @RequestParam("password") String password, Model model, HttpSession session) {

        // Kiểm tra xem emailOrUsername có phải là email hợp lệ không
        User acc = null;
        if (emailOrUsername.contains("@")) {
            // Nếu có "@" là email, tìm người dùng bằng email
            acc = userService.findByEmail(emailOrUsername);
        } else {
            // Nếu không phải email, tìm người dùng bằng username
            acc = userService.findByUsername(emailOrUsername);
        }

        // Kiểm tra mật khẩu
        if (acc != null && acc.getPassword().equals(password)) {
            session.setAttribute("acc", acc);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Wrong email/username or password");
            return "login";
        }
    }


}



