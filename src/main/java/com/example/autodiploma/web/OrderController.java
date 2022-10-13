package com.example.autodiploma.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;
import com.example.autodiploma.SpareOrder;
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("spareOrder")
public class OrderController {
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }
    @PostMapping
    public String processOrder(SpareOrder order,
                               SessionStatus sessionStatus) {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
