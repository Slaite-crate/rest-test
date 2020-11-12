package dk.kea.resttest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteList {

    private ArrayList<Quote> quoteArrayList;

    public QuoteList() {
    }

    public ArrayList<Quote> getQuotes() {
        return quoteArrayList;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quoteArrayList = quotes;
    }

    @Override
    public String toString() {
        return "QuoteList{" +
                "quotes=" + quoteArrayList +
                '}';
    }
}
