package com.bankAPI.sb.dto;

import java.math.BigDecimal;

public class CheckBalanceDto {
    private long account_number;
    private BigDecimal balance;

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
