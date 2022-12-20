package com.controller;

import com.entity.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String ShowOrders(Model model){
        List<Order> orderList = orderService.getAll();
        model.addAttribute("orderList", orderList);
        return "order/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "order/save";
    }
    @GetMapping("/update-form")
    public String updateOrder(@RequestParam("orderId") int id, Model model){
        Order order = orderService.getById(id);
        model.addAttribute("order", order);
        return "order/save";
    }
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("order") @Valid Order order,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "order/save";
        }else{
            orderService.save(order);
            return "redirect:/order/list";
        }
    }
    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("orderId") int id){
        orderService.delete(id);
        return "redirect:/order/list";
    }
}
