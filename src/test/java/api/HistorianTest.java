package api;


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
        Assertions.assertNotEquals(0, historian.getAllQuotes());
    }

    @Test
    void getQuotesFrom() {

    }

    @Test
    void addQuote() {
    }
}
