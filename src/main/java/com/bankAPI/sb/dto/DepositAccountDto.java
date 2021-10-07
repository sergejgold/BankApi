package com.bankAPI.sb.dto;

import java.math.BigDecimal;

public class DepositAccountDto {
    private long account_number;
    private BigDecimal sum;
    private BigDecimal balance;

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
