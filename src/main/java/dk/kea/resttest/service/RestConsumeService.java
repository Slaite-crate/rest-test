package dk.kea.resttest.service;


import dk.kea.resttest.models.Quote;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestConsumeService {

    final RestTemplate restTemplate;
    private String url;
    private String urlArray;

    public RestConsumeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "https://gturnquist-quoters.cfapps.io/api/random";
        this.urlArray = "https://gturnquist-quoters.cfapps.io/api";
    }

    public Quote fetchSingleQuote(){
        String queryURL = UriComponentsBuilder
                .fromUriString(url)
                .toUriString();

        return restTemplate.getForObject(queryURL, Quote.class);
    }

    public Quote[] fetchAllQuotes(){
        String queryURL = UriComponentsBuilder
                .fromUriString(urlArray)
                .toUriString();

        return restTemplate.getForObject(queryURL, Quote[].class);
    }
}
