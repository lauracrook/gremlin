package org.gremlin;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForismaticFetcher implements QuoteFetcher {

    private HttpURLConnection connection;

    // Method for setting the connection (for testing purposes)
    public void setConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    @Override
    public String fetchQuote(String language) {
        if (language.equals("english") || language.equals("e")) {
            language = "en";
        } else if (language.equals("russian") || language.equals("r")) {
            language = "ru";
        } else {
            throw new IllegalArgumentException("Invalid language. Please use 'english', 'e', 'russian', or 'r'.");
        }

        try {
            // Use the injected connection if available, otherwise create a new one
            HttpURLConnection urlConnection = (connection != null) ? connection : (HttpURLConnection) new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=" + language).openConnection();
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
System.out.println(responseCode + " " + response.toString());
                JSONObject jsonResponse = new JSONObject(response.toString());

                String quote = jsonResponse.getString("quoteText");
                String author = jsonResponse.getString("quoteAuthor");

                return "Quote: " + quote + "\nAuthor: " + author;
            } else {
                return "Failed to fetch quote. HTTP error code: " + responseCode;
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
