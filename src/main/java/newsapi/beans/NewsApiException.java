package newsapi.beans;

public class NewsApiException extends Exception {

    public NewsApiException(String message) {
        super(message);
        System.out.println("Fehler");
    }
}
