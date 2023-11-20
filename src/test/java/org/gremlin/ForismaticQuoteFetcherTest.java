package org.gremlin;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForismaticQuoteFetcherTest {

    private ForismaticFetcher forismaticFetcher;
    private HttpURLConnection mockConnection;

    @Before
    public void setUp() {
        forismaticFetcher = new ForismaticFetcher();
        // Create a mock implementation of HttpURLConnection to simulate API response
        mockConnection = mock(HttpURLConnection.class);
        // Inject the mock connection into the forismaticFetcher
        forismaticFetcher.setConnection(mockConnection);
    }

    @Test
    public void testFetchQuoteHappyPath() throws IOException {
        // Test case for a successful quote fetch
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream("{\"quoteText\":\"Test Quote\",\"quoteAuthor\":\"Test Author\"}".getBytes()));

        String result = forismaticFetcher.fetchQuote("english");

        assertEquals("Quote: Test Quote\nAuthor: Test Author", result);
    }

    @Test
    public void testFailedToFetchQuote() throws IOException {

        // Test case for a failed quote fetch
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_BAD_REQUEST);

        String result = forismaticFetcher.fetchQuote("english");

        assertEquals("Failed to fetch quote. HTTP error code: 400", result);
    }
}
