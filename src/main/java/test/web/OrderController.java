package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import test.model.Order;
import test.repository.OrderRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @PostMapping("/save")
    public String save(HttpServletRequest request) {
        Order order = new Order(request.getParameter("num"));
        repository.save(order);
        return "redirect:/";
    }

    public List<Order> getAll() {
        return repository.getAll();
    }

    @PostMapping("/filter")
    public String getByNumber(HttpServletRequest request, Model model) {
        String num = request.getParameter("num");
        model.addAttribute("orders", Collections.singletonList(repository.get(num)));
        return "orders";
    }
}
