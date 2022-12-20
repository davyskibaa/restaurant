package com.controller;

import com.entity.Staff;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/list")
    public String ShowStaff(Model model){
        List<Staff> staffList = staffService.getAll();
        model.addAttribute("staffList", staffList);
        return "staff/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Staff staff = new Staff();
        model.addAttribute("staff", staff);
        return "staff/save";
    }
    @GetMapping("/update-form")
    public String update(@RequestParam("staffId") int id, Model model){
        Staff staff = staffService.getById(id);
        model.addAttribute("staff", staff);
        return "staff/save";
    }
    @PostMapping("/save")
    public String saveStaff(@ModelAttribute("staff") @Valid Staff staff,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "staff/save";
        }else{
            staffService.save(staff);
            return "redirect:/staff/list";
        }
    }
    @GetMapping("/delete")
    public String deleteStaff(@RequestParam("staffId") int id){
        staffService.delete(id);
        return "redirect:/staff/list";
    }
}
