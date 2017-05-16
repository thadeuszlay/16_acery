package model.exceptions;

/**
 * Created by think on 07.05.17.
 */
public class ExceedBalance extends Exception {
    public ExceedBalance(String msg) {
        super(msg);
    }
}
