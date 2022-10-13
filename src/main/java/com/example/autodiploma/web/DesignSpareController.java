package com.example.autodiploma.web;

import com.example.autodiploma.Spare;
import com.example.autodiploma.SpareOrder;
import com.example.autodiploma.SpareParts;
import com.example.autodiploma.SpareParts.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("spareOrder")

public class DesignSpareController {
    public void addSparePartsToModel(Model model) {
        List<SpareParts> spareParts = Arrays.asList(
                new SpareParts("FLTO", "Flour Tortilla", Type.TRANSMISSION),
                new SpareParts("COTO", "Corn Tortilla", Type.TRANSMISSION),
                new SpareParts("GRBF", "Ground Beef", Type.ENGINE),
                new SpareParts("CARN", "Carnitas", Type.ENGINE),
                new SpareParts("TMTO", "Diced Tomatoes", Type.STEERING),
                new SpareParts("LETC", "Lettuce", Type.STEERING),
                new SpareParts("CHED", "Cheddar", Type.CHASSIS),
                new SpareParts("JACK", "Monterrey Jack", Type.CHASSIS)
        );
        Type[] types = SpareParts.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(spareParts, type));
        }
    }
    @ModelAttribute(name = "spareOrder")
    public SpareOrder order() {
        return new SpareOrder();
    }

    @ModelAttribute(name = "spare")
    public Spare spare() {
        return new Spare();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    @PostMapping
    public String processTaco(Spare spare,
                              @ModelAttribute SpareOrder spareOrder) {
        spareOrder.addSpare(spare);
        log.info("Processing taco: {}", spare);
        return "redirect:/orders/current";
    }
    private Iterable<SpareParts> filterByType(
            List<SpareParts> spareParts, Type type) {
        return spareParts
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
