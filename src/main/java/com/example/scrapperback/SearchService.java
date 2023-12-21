package com.example.scrapperback;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public List<SearchResult> performSearch(String query) {
        // Process the query with NLP
        List<String> keywords = processQueryWithNLP(query);

        // Call eBay API with processed keywords
        return callEbayApi(keywords);
    }

    private List<String> processQueryWithNLP(String query) {
        // NLP processing logic here
        List<String> keywords = new ArrayList<>();
        keywords.add(query);  // Replace this with actual NLP extraction logic
        return keywords;
    }

    private List<SearchResult> callEbayApi(List<String> keywords) {
        // Placeholder for the eBay API call
        String apiUrl = "https://api.ebay.com/...";  // Update with actual eBay API endpoint
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        // Process the response and convert it to a list of SearchResult objects
        return processApiResponse(response.getBody());
    }

    private List<SearchResult> processApiResponse(String responseBody) {
        // Process the API response and extract search results
        List<SearchResult> results = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray items = jsonObject.getJSONArray("items"); // Replace "items" with the actual JSON field

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String title = item.getString("title"); // Replace "title" with the actual JSON field
            double price = item.getDouble("price"); // Replace "price" with the actual JSON field
            String url = item.getString("url"); // Replace "url" with the actual JSON field
            String description = item.getString("description"); // Replace "description" with the actual JSON field

            SearchResult searchResult = new SearchResult(title, price, url, description);
            results.add(searchResult);
        }

        return results;
    }
}
