package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test.model.Order;
import test.repository.OrderRepository;
import test.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userRepository.getAll());
        return "users";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);

        switch (userRepository.get(userId).getRole()) {
            case ROLE_USER:
                return "redirect:orderForm";
            case ROLE_ADMIN:
                return "redirect:users";
            case ROLE_OPERATOR:
                return "redirect:orders";
            default:
                return "redirect:index";
        }
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders",
                orderRepository.getAll());
        return "orders";
    }

    @GetMapping("/orderForm")
    public String createOrder(Model model) {
        model.addAttribute("order", new Order(""));
        return "orderForm";
    }
}

