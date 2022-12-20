package com.controller;

import com.entity.Menu;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public String ShowMenu(Model model){
        List<Menu> menuList= menuService.getAll();
        model.addAttribute("menuList",menuList);
        return "menu/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Menu menu= new Menu();
        model.addAttribute("menu",menu);
        return "menu/save";
    }
    @GetMapping("/update-form")
    public String updateMenu(@RequestParam("menuId") int id, Model model){
        Menu menu = menuService.getById(id);
        model.addAttribute("menu",menu);
        return "menu/save";
    }
    @PostMapping("/save")
    public String saveMenu(@ModelAttribute("menu") @Valid Menu menu,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "menu/save";
        }else{
            menuService.save(menu);
            return "redirect:/menu/list";
        }
    }
    @GetMapping("/delete")
    public String deleteMenu(@RequestParam("menuId") int id){
        menuService.delete(id);
        return "redirect:/menu/list";
    }
}
