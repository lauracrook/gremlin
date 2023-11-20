package org.gremlin;

public class QuoteFetcherMain {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java QuoteFetcherMain <language>");
            System.exit(1);
        }

        String language = args[0].toLowerCase();

        QuoteFetcher quoteFetcher = new ForismaticFetcher();
        String result = quoteFetcher.fetchQuote(language);

        System.out.println(result);
    }
}