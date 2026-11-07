
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            TransactionReader reader = new TransactionReader();

            List<Transaction> transactions = reader.readTransactions();

            TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

            System.out.println("Maximum amount: " + analyzer.getMaxAmount());

            System.out.println("Most common type: " + analyzer.getMostCommonType());

            System.out.println("Account with most transactions: " + analyzer.getAccountWithMostTransactions());

            System.out.println("Total amount: " + analyzer.getTotalAmount());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
