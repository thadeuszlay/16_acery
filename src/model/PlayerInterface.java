package model;

/**
 * Created by think on 08.05.17.
 */
public interface PlayerInterface {
    int getMoney();
    void withdrawMoney(int amount);
    void depositMoney(int amount);
}
