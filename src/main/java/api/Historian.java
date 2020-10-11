package api;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import model.Quote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Historian {

    private String dbUser;
    private String dbPass;
    private CqlSession session;

    public Historian(String username) {
        Properties creds = new Properties();
        try {
            creds.load(Historian.class.getResourceAsStream("cred.conf"));
            dbUser = creds.getProperty("username");
            dbPass = creds.getProperty("password");
            session = CqlSession.builder()
            .withCloudSecureConnectBundle(Historian.class.getResource("secure-connect-central.zip"))
            .withAuthCredentials(dbUser, dbPass)
            .withKeyspace("quotes")
            .build();
        } catch (IOException e) {
            System.err.println("Unable to load credidentials");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Historian h = new Historian("Person");
        System.out.println(h.getAllQuotes());
    }


    public List<Quote> getAllQuotes() {
        List<Quote> quotes = new ArrayList<>();
        ResultSet rs = session.execute("select * from user_quotes");
        rs.forEach(row -> quotes.add(new Quote(row.getString("quote"), row.getString("author"))));
        return quotes;
    }

    public List<Quote> getQuotesFrom(String author) {
        String query = String.format("select * from user_quotes where author = %s ALLOW FILTERING", author);
        ResultSet rs = session.execute(query);
        return fillQuotes(rs);
    }

    private List<Quote> fillQuotes(ResultSet rs) {
        return rs.map(x -> new Quote(x.getString("quote"), x.getString("author"))).all();
    }

    public void addQuote(String quote, String author) {
        String query = String.format("INSERT INTO user_quotes (quote, author) VALUES ('%s', '%s')", quote, author);
        session.execute(query);
    }
}