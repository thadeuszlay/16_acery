package model;

/**
 * Created by think on 02.05.17.
 */
public class Player {
    private int money = 100;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) throws Exception {
        if (money > 0) {
            this.money = money;
        } else {
            throw new Exception();
        }

    }

    public void withdrawMoney(int amount) throws Exception {
        if (amount <= this.money) {
            this.money -= amount;
            return;
        }
        throw new Exception();
    }
    public void depositMoney(int amount) throws Exception {
        if (amount > 0) {
            this.money += amount;
            return;
        }
        throw new Exception();
    }
}
