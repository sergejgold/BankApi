package com.bankAPI.sb.repository;
import com.bankAPI.sb.dto.NewCardDto;
import com.bankAPI.sb.model.Card;
import java.util.List;

public interface CardRepository {
    Card find(int id);
    void persist(Card card);
    List<Card> findByAccountId(int id);
}
