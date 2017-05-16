package model;

import model.exceptions.ExceedBalance;
import model.exceptions.NegativeNumber;
import model.exceptions.ZeroNumber;

/**
 * Created by think on 02.05.17.
 */
public class Player implements PlayerInterface{
    private int money = 0;

    public Player(int money) {
        if (isDepositMoneySmallerThanZero(money)) {
            try {
                throw new NegativeNumber("Negative amount of mon");
            } catch (NegativeNumber negativeNumber) {
                negativeNumber.printStackTrace();
            }
        }
        if (isTransferredMoneyEqualsZero(money)) {
            try {
                throw new ZeroNumber("Initial money has to be larger than 0.");
            } catch (ZeroNumber zeroNumber) {
                zeroNumber.printStackTrace();
            }
        }
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public void withdrawMoney(int amount){
        if (isWithdrawMoneyExceedBalance(amount)) {
            try {
                throw new ExceedBalance("Not enough money");
            } catch (ExceedBalance exceedBalance) {
                exceedBalance.printStackTrace();
            }
        }
        this.money -= amount;
    }
    private boolean isWithdrawMoneyExceedBalance(int amount) {
        return amount > this.money;
    }

    public void depositMoney(int amount){
        if (isDepositMoneySmallerThanZero(amount)) {
            try {
                throw new NegativeNumber("Negative amount not allowed as disposal");
            } catch (NegativeNumber negativeNumber) {
                negativeNumber.printStackTrace();
            }
        }
        this.money += amount;
    }
    private boolean isDepositMoneySmallerThanZero(int amount) {
        return amount < 0;
    }
    private boolean isTransferredMoneyEqualsZero(int amount) {
        return amount == this.money;
    }
}