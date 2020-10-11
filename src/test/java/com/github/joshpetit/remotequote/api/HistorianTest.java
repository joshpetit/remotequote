package com.github.joshpetit.remotequote.api;


import com.github.joshpetit.remotequote.model.Quote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HistorianTest {
    static Historian historian;

    @BeforeAll
    static void setup() {
        historian = new Historian("test_user1");
    }

    @Test
    void getAllQuotes() {
        Quote q = historian.getAllUserQuotes().get(0);
        assert (q != null);
    }

    @Test
    void getQuotesFrom() {

    }

    @Test
    void addQuote() {
    }
}
