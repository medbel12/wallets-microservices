package ma.enset.wallet_service.exceptions;

public class ClientException extends Exception {
    public ClientException(String customerNotFound) {
        super(customerNotFound);
    }
}
