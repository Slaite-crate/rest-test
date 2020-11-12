package dk.kea.resttest.service;


import dk.kea.resttest.models.Quote;
import dk.kea.resttest.models.QuoteList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RestConsumeService {

    final RestTemplate restTemplate;
    private String url;

    public RestConsumeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "https://gturnquist-quoters.cfapps.io/api/random";
    }

    public Quote fetchSingleQuote(){
        String queryURL = UriComponentsBuilder
                .fromUriString(url)
                .toUriString();

        return restTemplate.getForObject(queryURL, Quote.class);
    }

    public ArrayList<Quote> fetchAllQuotes(){

        String queryURL = UriComponentsBuilder
                .fromUriString("https://gturnquist-quoters.cfapps.io/api")
                .toUriString();

        Quote[] quoteArray = restTemplate.getForObject(queryURL, Quote[].class);

        ArrayList<Quote> quotesArrayList = new ArrayList<Quote>();

        if (quoteArray != null) {
            quotesArrayList.addAll(Arrays.asList(quoteArray));
        }

        return quotesArrayList;
    }
}
