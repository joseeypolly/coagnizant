import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesRecord {
    private int recordId;
    private String salesPerson;
    private String region;
    private double amount;
    private LocalDate date;

    public SalesRecord(int recordId, String salesPerson, String region, double amount, LocalDate date) {
        this.recordId = recordId;
        this.salesPerson = salesPerson;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "recordId=" + recordId +
                ", salesPerson='" + salesPerson + '\'' +
                ", region='" + region + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
