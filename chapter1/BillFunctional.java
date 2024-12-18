package chapter1;

//import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

class Play {
    public String name;
    public String type;

    // Default constructor for Jackson
    public Play() {}
    
    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class Performance {
    public String playID;
    public int audience;

    // Default constructor for Jackson
    public Performance() {}

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
}

class Invoice {
    public String customer;
    public List<Performance> performances;

    // Default constructor for Jackson
    public Invoice() {}

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }
}

public class BillFunctional{

    public static void main(String[] args) throws IOException {
        // Read the plays and invoice data from JSON files
        Map<String, Play> plays = loadPlays("plays.json");
        Invoice invoice = loadInvoice("invoice.json");

        // Generate the statement
        System.out.println(statement(invoice, plays));
    }

    // Load plays from JSON file
    private static Map<String, Play> loadPlays(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Play> plays = new HashMap<>();
        List<Play> playList = Arrays.asList(mapper.readValue(new File(filePath), Play[].class));
        for (Play play : playList) {
            plays.put(play.name.toLowerCase(), play);  // Using play name as key
        }
        return plays;
    }

    // Load invoice from JSON file
    private static Invoice loadInvoice(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), Invoice.class);
    }

    // Generate the statement (functional style)
    public static String statement(Invoice invoice, Map<String, Play> plays) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(2);

        // Calculate totalAmount and volumeCredits
        int[] totalAmount = {0};  // Using an array to allow mutation inside streams
        int[] volumeCredits = {0};  // Using an array to allow mutation inside streams

        String header = "Statement for " + invoice.customer + "\n";

        String performances = invoice.performances.stream()
            .map(perf -> {
                Play play = plays.get(perf.playID);
                int thisAmount = 0;

                switch (play.type) {
                    case "tragedy":
                        thisAmount = 40000;
                        if (perf.audience > 30) {
                            thisAmount += 1000 * (perf.audience - 30);
                        }
                        break;
                    case "comedy":
                        thisAmount = 30000;
                        if (perf.audience > 20) {
                            thisAmount += 10000 + 500 * (perf.audience - 20);
                        }
                        thisAmount += 300 * perf.audience;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown type: " + play.type);
                }

                // Add volume credits
                volumeCredits[0] += Math.max(perf.audience - 30, 0);
                if ("comedy".equals(play.type)) {
                    volumeCredits[0] += Math.floor(perf.audience / 5);
                }

                totalAmount[0] += thisAmount;

                return String.format(" %s: %s (%d seats)", play.name, format.format(thisAmount / 100.0), perf.audience);
            })
            .collect(Collectors.joining("\n"));

        String footer = String.format("Amount owed is %s\nYou earned %d credits\n",
                format.format(totalAmount[0] / 100.0), volumeCredits[0]);

        return header + performances + "\n" + footer;
    }
}

