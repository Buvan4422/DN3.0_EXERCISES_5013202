public interface PaymentProcessor {
    default void paymentProcess(String amt){
    }
}
