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
        System.out.println(q);
        assert (q != null);
    }

    @Test
    void addQuote() {
        int before = Historian.getAllUserQuotes().size();
//        Historian.addQuote("test_quote_add", "test_quote_add_author", "test_quote_add_type");
        Historian.addQuote("test_quote_add", "test_quote_add_author", "test_quote_add_type");
        int after = Historian.getAllUserQuotes().size();
        assert(before < after);
    }
}
