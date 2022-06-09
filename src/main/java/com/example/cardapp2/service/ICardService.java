package com.example.cardapp2.service;

import com.example.cardapp2.model.Card;

import java.util.ArrayList;

public interface ICardService {

    public ArrayList<Card> findAll();

    public ArrayList<String> filterByName();

    public ArrayList<String> filterBySurname();

    public ArrayList<String> filterByPhone();
}
