# Web Crawler Project

A simple web crawler implemented in Java using the Jsoup library. This crawler starting from a given URL and searches for a target URL by following links on web pages.

## Features

- Breadth-first search (BFS) crawling approach
- Basic URL validation and normalization
- Avoids revisiting URLs using a visited set
- Configurable starting and target URLs
- Basic error handling for network issues

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Gradle (for building and running)

## Dependencies

- [Jsoup](https://jsoup.org/) - Java HTML parser (version 1.18.3)

## Project Structure

```
WebCrawlerProject/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   └── Crawler.java
├── build.gradle.kts
└── README.md
```

## How to Run

1. Clone or download this repository
2. Navigate to the project directory
3. Build and run using Gradle:

```bash
# Using Gradle Wrapper (Unix/macOS)
./gradlew run

# Using Gradle Wrapper (Windows)
gradlew.bat run
```

Alternatively, you can build and run manually:

```bash
# Compile
./gradlew build

# Run (adjust main class if needed)
java -cp build/libs/WebCrawlerProject-1.0-SNAPSHOT.jar org.example.Crawler
```

## Configuration

The starting and target URLs are hardcoded in the `main` method of `Crawler.java`:

```java
public static void main(String[] args){
    String starterurl = "https://en.wikipedia.org/wiki/Apollo_10";
    String targeturl = "https://en.wikipedia.org/wiki/Human_spaceflight";
    // ...
}
```

To crawl different sites, modify these URLs and recompile.

## Efficiency Considerations

This is a basic crawler implementation. For improved efficiency and etiquette in production crawling, consider implementing:

1. **Politeness Delay**: Add a delay between requests to avoid overwhelming servers
2. **User-Agent String**: Identify your crawler with a proper user-agent string
3. **Robots.txt Compliance**: Check and respect robots.txt rules
4. **Domain Restriction**: Limit crawling to the same domain as the starting URL
5. **URL Normalization**: Properly normalize URLs to avoid duplicate visits
6. **Error Handling & Retries**: Implement retry mechanisms with exponential backoff
7. **Parallel Crawling**: Use multiple threads for faster crawling (with caution)
8. **Content Filtering**: Filter URLs by file type, path patterns, etc.
9. **Storage**: Store crawled data or visited URLs persistently for large crawls

## Limitations

- No politeness delay between requests
- No user-agent string identification
- No robots.txt compliance
- No domain restriction (may crawl external sites)
- Basic URL normalization
- No persistent storage (visited URLs are lost on exit)
- Single-threaded crawling

## Building the JAR

To create an executable JAR:

```bash
./gradlew jar
```

The JAR will be placed in `build/libs/`.

## License

This project is open source and available under the MIT License.

---

*Note: Please use web crawlers responsibly and in accordance with website terms of service and applicable laws.*