package com.github.joshpetit.remotequote.api;


import com.github.joshpetit.remotequote.model.Quote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HistorianTest {

    @BeforeAll
    static void setup() {
        Historian.initializeHistorian("test_user1");
    }

    @Test
    void getAllQuotes() {
        Quote q = Historian.getAllUserQuotes().get(0);
        assert (q != null);
    }

    @Test
    void getQuotesFrom() {

    }

    @Test
    void addQuote() {
    }
}
