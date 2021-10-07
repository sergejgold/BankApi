package com.bankAPI.sb.service;

import com.bankAPI.sb.model.Account;
import com.bankAPI.sb.model.Card;
import com.bankAPI.sb.repository.AccountRepository;
import com.bankAPI.sb.repository.CardRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;
    private AccountRepository accountRepository;

    public CardServiceImpl(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    private int getRandom(){
        int a = 1000;
        int b = 9100;
        int random_number1 = a + (int) (Math.random() * b);
        return random_number1;
    }

    @Override
    public List<Card> getCardsAll(long numberAccount) {
        List<Account> list = accountRepository.findAccountByNumber(numberAccount);
        Account account = list.get(0);
        int idAccount = account.getId();
        List<Card> list2 = cardRepository.findByAccountId(idAccount);
        return list2;
    }

    @Override
    public String makeNewCard(long numberAccount) {
        List<Account> list = accountRepository.findAccountByNumber(numberAccount);
        Account account = list.get(0);
        Card card = new Card();
        card.setAcc_id(account.getId());
        int i = getRandom();
        String number = "427639001122" + String.valueOf(i);
        card.setCard_number(number);
        cardRepository.persist(card);
        String code = "Карта с номером " + number + " успешно добавлена!";
        return code;
    }
}
