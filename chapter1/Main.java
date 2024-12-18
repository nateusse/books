package chapter1;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class Play {
    String name;
    String type;

    Play(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class Performance {
    String playID;
    int audience;

    Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
}

class Invoice {
    String customer;
    List<Performance> performances;

    Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("aslike", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        List<Performance> performances = List.of(
            new Performance("hamlet", 55),
            new Performance("aslike", 35),
            new Performance("othello", 40)
        );

        Invoice invoice = new Invoice("BigCo", performances);

        System.out.println(statement(invoice, plays));
    }

    public static String statement(Invoice invoice, Map<String, Play> plays) {
        double totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder("Statement for " + invoice.customer + "\n");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);
            double thisAmount = 0;

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
                    throw new IllegalArgumentException("unknown type: " + play.type);
            }

            // Add volume credits
            volumeCredits += Math.max(perf.audience - 30, 0);
            // Add extra credit for every ten comedy attendees
            if ("comedy".equals(play.type)) {
                volumeCredits += Math.floor(perf.audience / 5);
            }

            // Print line for this order
            result.append(String.format(" %s: %s (%d seats)\n", play.name, format.format(thisAmount / 100), perf.audience));
            totalAmount += thisAmount;
        }

        result.append(String.format("Amount owed is %s\n", format.format(totalAmount / 100)));
        result.append(String.format("You earned %d credits\n", volumeCredits));
        return result.toString();
    }
}

