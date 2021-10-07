package com.bankAPI.sb.service;
import com.bankAPI.sb.model.Card;
import java.util.List;

public interface CardService {
    List<Card> getCardsAll(long numberAccount);
    String makeNewCard(long numberAccount);
}
