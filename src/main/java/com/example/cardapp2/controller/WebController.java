package com.example.cardapp2.controller;

import com.example.cardapp2.model.Card;
import com.example.cardapp2.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller
 */
@RestController
public class WebController {

    @Autowired
    private ICardService cardService;

    @RequestMapping("/")
    public List<Card> listCards() {
        return cardService.findAll();
    }

    @RequestMapping("/name")
    public List<String> filterByName() {
        return cardService.filterByName();
    }

    @RequestMapping("/surname")
    public List<String> filterBySurname() {
        return cardService.filterBySurname();
    }

    @RequestMapping("/phone")
    public List<String> filterByPhone() {
        return cardService.filterByPhone();
    }



}
