
public class Transaction {

    private long amount;
    private Currency currency;
    private String transactionDate;
    private String sourceAccount;
    private String destinationAccount;
    private TransferType transferType;

    public Transaction(long amount, Currency currency,
                       String transactionDate, String sourceAccount,
                       String destinationAccount, TransferType transferType) {
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transferType = transferType;
    }

    public long getAmount() {
        return amount;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public TransferType getTransferType() {
        return transferType;
    }
}
