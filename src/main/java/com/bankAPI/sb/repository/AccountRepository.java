package com.bankAPI.sb.repository;
import com.bankAPI.sb.model.Account;
import java.util.List;

public interface AccountRepository {
    List<Account> findAccountByNumber(long numberAccount);
    void persist(Account account);
    Account merge(Account account);
}
