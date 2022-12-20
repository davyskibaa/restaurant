package com.controller;

import com.entity.Booking;
import com.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/list")
    public String ShowList(Model model){
        List<Booking> bookingList = bookingService.getAll();
        model.addAttribute("bookingList", bookingList);
        return "booking/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "booking/save";
    }
    @GetMapping("/update-form")
    public String update(@RequestParam("bookingId") int id, Model model){
        Booking booking = bookingService.getById(id);
        model.addAttribute("booking", booking);
        return "booking/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("booking") @Valid Booking booking,
                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "booking/save";
        }else{
            bookingService.save(booking);
            return "redirect:/booking/list";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("bookingId") int id){
        bookingService.delete(id);
        return "redirect:/booking/list";
    }
}
