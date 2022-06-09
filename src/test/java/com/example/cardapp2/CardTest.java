package com.example.cardapp2;

import com.example.cardapp2.model.Card;
import org.junit.Test;
import org.meanbean.test.BeanTester;


public class CardTest {

    @Test
    public void testCard(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Card.class);
    }

}
