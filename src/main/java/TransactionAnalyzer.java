
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionAnalyzer {

    private final List<Transaction> transactions;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // 1. بیشترین مبلغ تراکنش
    public long getMaxAmount() {

        long max = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > max) {
                max = transaction.getAmount();
            }
        }

        return max;
    }

    // 2. پرتکرارترین نوع تراکنش
    public String getMostCommonType() {

        Map<TransferType, Integer> counts = new HashMap<>();

        for (Transaction transaction : transactions) {

            TransferType type = transaction.getTransferType();

            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        TransferType mostCommon = null;
        int maxCount = 0;

        for (Map.Entry<TransferType, Integer> entry : counts.entrySet()) {

            if (entry.getValue() > maxCount) {

                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        if (mostCommon == null) {
            return "No transactions found";
        }

        return mostCommon + " (" + maxCount + " times)";
    }

    // 3. حساب مبدأ با بیشترین تعداد تراکنش
    public String getAccountWithMostTransactions() {

        Map<String, Integer> counts = new HashMap<>();

        for (Transaction transaction : transactions) {
            String account = transaction.getSourceAccount();

            counts.put(account, counts.getOrDefault(account, 0) + 1);
        }

        String mostCommon = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon + " (" + maxCount + " transactions)";
    }

    // 4. مجموع مبالغ تراکنش‌ها
    public long getTotalAmount() {

        long total = 0;

        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }

        return total;
    }
}
