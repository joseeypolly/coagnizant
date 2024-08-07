import java.util.concurrent.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WebCrawler {
    private static final int NUM_THREADS = 10; // Number of threads in the pool
    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    private static final ConcurrentMap<String, String> crawledData = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // Example URLs to crawl (in a real application, these would be dynamic)
        String[] urls = {
            "http://example.com/page1",
            "http://example.com/page2",
            "http://example.com/page3",
            // Add more URLs here
        };

        // Submit crawling tasks to the executor service
        for (String url : urls) {
            executorService.submit(new CrawlerTask(url));
        }

        // Shutdown the executor service
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Log the results
        System.out.println("Crawling complete. Crawled data:");
        crawledData.forEach((url, content) -> System.out.println(url + ": " + content));
    }

    // Define a task for crawling web pages
    static class CrawlerTask implements Runnable {
        private final String url;

        public CrawlerTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            try {
                // Simulate web page retrieval
                String content = retrievePageContent(url);
                // Store crawled data
                crawledData.put(url, content);
                System.out.println("Crawled: " + url);
            } catch (Exception e) {
                System.err.println("Failed to crawl: " + url);
                e.printStackTrace();
            }
        }

        // Simulate web page content retrieval (in a real application, this would be an HTTP request)
        private String retrievePageContent(String url) {
            try {
                Thread.sleep(2000); // Simulate network delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Content of " + url; // Simulated content
        }
    }
}
