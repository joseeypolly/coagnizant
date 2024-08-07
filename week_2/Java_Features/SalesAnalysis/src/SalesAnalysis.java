import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalysis {
        public static void main(String[] args) {
            List<SalesRecord> records = Arrays.asList(
                new SalesRecord(1, "Afsha", "North", 1200.0, LocalDate.of(2024, 1, 15)),
                new SalesRecord(2, "Samba", "South", 1500.0, LocalDate.of(2024, 2, 10)),
                new SalesRecord(3, "Charlie", "North", 900.0, LocalDate.of(2024, 3, 12)),
                new SalesRecord(4, "Swathi", "East", 1700.0, LocalDate.of(2024, 4, 20)),
                new SalesRecord(5, "Teja", "North", 1300.0, LocalDate.of(2024, 5, 25))
            );

            // Perform Stream API operations
            
            records.stream()
            .filter(record -> "North".equals(record.getRegion()))
            .forEach(System.out::println);
            
            records.stream()
            .filter(record -> "North".equals(record.getRegion()))
            .map(SalesRecord::getAmount)
            .forEach(System.out::println);
            
            double totalSales = records.stream()
                    .filter(record -> "North".equals(record.getRegion()))
                    .mapToDouble(SalesRecord::getAmount)
                    .sum();
            System.out.println("Total Sales for North region: " + totalSales);

            

            Map<String, List<SalesRecord>> salesByPerson = records.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson));

            salesByPerson.forEach((salesPerson, salesList) -> {
                System.out.println("SalesPerson: " + salesPerson);
                salesList.forEach(System.out::println);
            });
            
            Map<String, Double> salesReport = records.stream()
            	    .collect(Collectors.groupingBy(
            	        SalesRecord::getSalesPerson,
            	        Collectors.summingDouble(SalesRecord::getAmount)
            	    ));

            	salesReport.forEach((salesPerson, totalAmount) -> {
            	    System.out.println("SalesPerson: " + salesPerson + ", Total Sales: " + totalAmount);
            	});

        }
    }