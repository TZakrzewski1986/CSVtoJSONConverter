package com.example.cardapp2.service;

import com.example.cardapp2.model.Card;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service with filter methods
 */
@Service
public class CardService implements ICardService {

    private final ArrayList<Card> cards;

    public CardService() {
        cards = new ArrayList();
    }

    /**
     * Filter by name
     * @return array - column with names
     */
    @Override
    public ArrayList<String> filterByName() {
        ArrayList<String> listByName = new ArrayList<>();
        for (Card card : cards) {
            String cardName = card.getName();
            listByName.add(cardName);
        }
        return listByName;
    }

    /**
     * Filter by surname
     * @return array - column with surnames
     */
    @Override
    public ArrayList<String> filterBySurname() {
        ArrayList<String> listBySurname = new ArrayList<>();
        for (Card card : cards) {
            String cardSurname = card.getSurname();
            listBySurname.add(cardSurname);
        }
        return listBySurname;
    }

    /**
     * filter by phone
     * @return array - column with phones
     */
    @Override
    public ArrayList<String> filterByPhone() {
        ArrayList<String> listByPhone = new ArrayList<>();
        for (Card card : cards) {
            String cardPhone = card.getPhone();
            listByPhone.add(cardPhone);
        }
        return listByPhone;
    }

    /**
     * Uses CSVReader to read a CSV file
     * @return array with all cards converts to JSON format
     */
    @Override
    public ArrayList<Card> findAll() {

        FileInputStream fileInputStream = null;

        try {

            fileInputStream = new FileInputStream(new File("cards.csv"));
            CSVReader reader = new CSVReader(new InputStreamReader(fileInputStream));
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {

                Card newCard = new Card(nextLine[0], nextLine[1], nextLine[2]);
                cards.add(newCard);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CardService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CardService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(CardService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CardService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cards;
    }

}
