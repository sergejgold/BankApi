package com.bankAPI.sb.service;

import com.bankAPI.sb.dto.CheckBalanceDto;
import com.bankAPI.sb.dto.DepositAccountDto;
import com.bankAPI.sb.model.Account;
import com.bankAPI.sb.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public DepositAccountDto addMoneyToAccount(DepositAccountDto accountDto) {
        BigDecimal sum = accountDto.getSum();
        long numberAccount = accountDto.getAccount_number();
        List<Account> list = accountRepository.findAccountByNumber(numberAccount);
        Account account = list.get(0);
        BigDecimal currentBalance =  account.getBalance();
        BigDecimal newBalance = currentBalance.add(sum);
        account.setBalance(newBalance);
        Account acc = accountRepository.merge(account);
        DepositAccountDto complete = new DepositAccountDto();
        complete.setSum(sum);
        complete.setBalance(acc.getBalance());
        complete.setAccount_number(acc.getAccount_number());
        return complete;
    }

    @Override
    public CheckBalanceDto checkBalance(long accountNumber) {
        List<Account> list = accountRepository.findAccountByNumber(accountNumber);
        Account account = list.get(0);
        CheckBalanceDto complete = new CheckBalanceDto();
        complete.setBalance(account.getBalance());
        complete.setAccount_number(account.getAccount_number());
        return complete;
    }
}