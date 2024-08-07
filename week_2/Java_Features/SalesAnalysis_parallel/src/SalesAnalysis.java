import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> records = Arrays.asList(
            new SalesRecord(1, "Afsha", "North", 1200.0, LocalDate.of(2024, 1, 15), "Electronics", 5),
            new SalesRecord(2, "Bob", "South", 1500.0, LocalDate.of(2024, 2, 10), "Furniture", 3),
            new SalesRecord(3, "Charlie", "North", 900.0, LocalDate.of(2024, 3, 12), "Electronics", 2),
            new SalesRecord(4, "samba", "East", 1700.0, LocalDate.of(2024, 4, 20), "Clothing", 7),
            new SalesRecord(5, "Swathi", "North", 1300.0, LocalDate.of(2024, 5, 25), "Electronics", 4)
        );

        System.out.println("Filtered and Sorted Records:");
        records.stream()
               .filter(record -> "Electronics".equals(record.getProductCategory()))
               .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
               .forEach(System.out::println);
        
        double averageSales = records.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .mapToDouble(SalesRecord::getAmount)
                .average()
                .orElse(0.0);
        System.out.println("Average Sales for North region: " + averageSales);

        SalesRecord topSalesRecord = records.stream()
                .max((r1, r2) -> Double.compare(r1.getAmount(), r2.getAmount()))
                .orElse(null);
        System.out.println("Top Sales Record: " + (topSalesRecord != null ? topSalesRecord : "No records found"));
        
        long startTime = System.nanoTime();

        records.stream()
               .filter(record -> "Electronics".equals(record.getProductCategory()))
               .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
               .forEach(System.out::println);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("Time taken (Sequential): " + duration + " ms");

        	
        startTime = System.nanoTime();

        records.parallelStream()
               .filter(record -> "Electronics".equals(record.getProductCategory()))
               .sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate()))
               .forEach(System.out::println);

        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("Time taken (Parallel): " + duration + " ms");


    }
}
