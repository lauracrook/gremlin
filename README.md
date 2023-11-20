# gremlin
Take-home backend developer exam

This is a Java program which: 
1. Operates on the command line
2. Accepts a language as an argument (either English or Russian)
3. Fetches results from the forismatic.com quote api (http://forismatic.com/en/api/)
4. Displays to stdout the quote and author

## Some thoughts:

If this were intended as more than an exercise, the exception handling in
ForismaticFetcher would be more robust, i.e., it would probably
(depending on the business/front-end needs) differentiate
between ProtocolException, MalformedURLException, and the other potential
RuntimeExceptions that can occur.

## Some caveats:
The tests are set up for JUnit 4, and while the ./gradlew test task runs successfully, running the tests
in my IDE continues to fail, probably due to some fiddly configuration around JUnit 4 versus JUnit Jupiter, 
or conceivably because I've mostly used the IDE for Kotlin and there's something in the settings that I can't 
find. 

I ran out of time, so I couldn't drill any deeper (sad face). I still feel confident in my code, however,
so I'm sending it along.  Thank you for your consideration and time!

## Pre-requisites:
- Java version 8 or later (built at home using Java 8, runtime is Java 17)

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/lauracrook/gremlin.git
2. Navigate to the project directory:
   ```bash
   cd gremlin
3. Build the project
   ```bash
   ./gradlew build
4. Run the program
   ```bash
   ./gradlew run

## Notes
As specified, the default language is English, but if you would like to check Russian, use
   ```bash
   ./gradlew run --args "r"