package com.github.joshpetit.remotequote.api;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.github.joshpetit.remotequote.model.Quote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Historian {

    private static CqlSession session;
    private static String username;

    Historian() {
    }

    public static void initializeHistorian(String username) {
        Properties creds = new Properties();
        try {
            Historian.username = username;
            creds.load(Historian.class.getResourceAsStream("cred.conf"));
            String dbUser = creds.getProperty("username");
            String dbPass = creds.getProperty("password");
            session = CqlSession.builder()
                    .withCloudSecureConnectBundle(Historian.class.getResource("secure-connect-central.zip"))
                    .withAuthCredentials(dbUser, dbPass)
                    .withKeyspace("quotes")
                    .build();
        } catch (IOException e) {
            System.err.println("Unable to connect to database");
            System.exit(1);
        }
    }

    public static List<Quote> getAllUserQuotes() {
        List<Quote> quotes = new ArrayList<>();
        String query = String.format("select * from user_quotes where username='%s'", username);
        ResultSet rs = session.execute(query);
        rs.forEach(row -> quotes.add(new Quote(row.getString("quote"),
                row.getString("author"), row.getUuid("quote_id"), row.getString("username"))));
        return quotes;
    }
}