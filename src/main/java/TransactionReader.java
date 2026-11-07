
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader {

    public List<Transaction> readTransactions() throws IOException {

        InputStream input =
                TransactionReader.class.getResourceAsStream(
                        "/sample_transactions.csv");

        if (input == null) {
            throw new IOException("CSV file not found!");
        }

        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(input))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {

                if (header) {
                    header = false;
                    continue;
                }

                String[] data = line.split(",", -1);

                long amount = Long.parseLong(data[0].trim());

                Currency currency = Currency.valueOf(
                        data[1].trim().toUpperCase()
                );

                String date = data[2].trim();
                String source = data[3].trim();
                String destination = data[4].trim();

                TransferType type = TransferType.valueOf(
                        data[5].trim().toUpperCase()
                );

                Transaction transaction = new Transaction(
                        amount,
                        currency,
                        date,
                        source,
                        destination,
                        type
                );

                transactions.add(transaction);
            }
        }

        return transactions;
    }
}
