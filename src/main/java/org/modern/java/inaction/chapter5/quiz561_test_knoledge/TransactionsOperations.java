package org.modern.java.inaction.chapter5.quiz561_test_knoledge;

import org.modern.java.inaction.domain.MarketTrades;
import org.modern.java.inaction.domain.Trader;
import org.modern.java.inaction.domain.Transaction;

import java.util.Comparator;

public class TransactionsOperations {
    public static void main(String args[]){
        System.out.println("Find all transactions in the year 2011 and sort them by value (small to high).");
        MarketTrades.transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("What are all the unique cities where the traders work?");
        MarketTrades.transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        System.out.println("Find all traders from Cambridge and sort them by name.");
        MarketTrades.transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("Return a string of all traders’ names sorted alphabetically.");
        MarketTrades.transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .reduce((n1,n2) -> n1+" "+n2)
                .ifPresent(System.out::println);

        System.out.println("Are any traders based in Milan?");
        boolean anyMilanTrader = MarketTrades.transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(anyMilanTrader);

        System.out.println("Print the values of all transactions from the traders living in Cambridge.");
        MarketTrades.transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);

        System.out.println("What is the highest value of all the transactions?");
        MarketTrades.transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .ifPresent(System.out::println);

        System.out.println("Find the transaction with the smallest value.");
        MarketTrades.transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
