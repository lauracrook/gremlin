package org.gremlin;

/*
 * This is probably overkill, but I added an Interface to show that I was aware
 * of the theoretical possibility of future expansions to use different
 * quote-fetching APIs.
 */
public interface QuoteFetcher {
    String fetchQuote(String language);
}
