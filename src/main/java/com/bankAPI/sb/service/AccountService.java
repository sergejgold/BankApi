package com.bankAPI.sb.service;

import com.bankAPI.sb.dto.CheckBalanceDto;
import com.bankAPI.sb.dto.DepositAccountDto;

public interface AccountService {
    DepositAccountDto addMoneyToAccount(DepositAccountDto accountDto);
    CheckBalanceDto checkBalance(long accountNumber);
}
