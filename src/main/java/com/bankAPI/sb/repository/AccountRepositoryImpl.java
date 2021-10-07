package com.bankAPI.sb.repository;

import com.bankAPI.sb.model.Account;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Account> findAccountByNumber(long numberAccount) {
        List<Account> resultList = em.createQuery("from ACCOUNTS WHERE account_number = " + numberAccount)
                .getResultList();
        return resultList;
    }
    @Override
    public void persist(Account account) {
        em.persist(account);
    }

    @Override
    public Account merge(Account account) {
        return em.merge(account);
    }
}