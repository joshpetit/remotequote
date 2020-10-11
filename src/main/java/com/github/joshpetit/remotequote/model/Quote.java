package com.github.joshpetit.remotequote.model;

import java.util.UUID;

public class Quote {
    private String quote;
    private String author;
    private UUID quoteID;
    private String username;

    public Quote(String quote, String author, UUID quoteID, String username) {
        this.quote = quote;
        this.author = author;
        this.quoteID = quoteID;
        this.username = username;
    }

    /**
     *
     * @return The quote
     */
    public String getQuote() {
        return quote;
    }

    /**
     *
     * @return The username of the quote uploader
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return Returns the author of the specific Quote
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return The UUID of the quote
     */
    public UUID getQuoteID() {
        return quoteID;
    }

    public String toString() {
        return String.format("%s%n- %s%n", quote, author);
    }
}
