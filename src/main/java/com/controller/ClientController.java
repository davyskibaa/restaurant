package com.controller;

import com.entity.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public String ShowList(Model model){
        List<Client> clientList = clientService.getAll();
        model.addAttribute("clientList", clientList);
        return "client/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "client/save";
    }
    @GetMapping("/update-form")
    public String update(@RequestParam("clientId") int id, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "client/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("client") @Valid Client client,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "client/save";
        }else{
            clientService.save(client);
            return "redirect:/client/list";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("clientId") int id){
        clientService.delete(id);
        return "redirect:/client/list";
    }
}
