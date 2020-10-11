package model;

public class Quote {
    private String quote;
    private String author;

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
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
     * @return Returns the author of the specific Quote
     */
    public String getAuthor() {
        return author;
    }

    public String toString() {
        return String.format("%s%n- %s%n", quote, author);
    }
}
