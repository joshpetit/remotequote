package com.github.joshpetit.remotequote.api;


import com.github.joshpetit.remotequote.model.Quote;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HistorianTest {

    @BeforeAll
    static void setup() {
        Historian.initialize("test_user1");
    }

    @Test
    void getAllQuotes() {
        Quote q = Historian.getAllUserQuotes().get(0);
        assert (q != null);
    }

    @Test
    void addQuote() {
    }
}
