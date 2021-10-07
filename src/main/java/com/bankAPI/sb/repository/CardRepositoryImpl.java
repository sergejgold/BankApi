package com.bankAPI.sb.repository;

import com.bankAPI.sb.model.Card;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CardRepositoryImpl implements CardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Card find(int id) {
        Card card = em.find(Card.class,id);
        return card;
    }
    @Override
    public void persist(Card card) {
        em.persist(card);
    }
    @Override
    public List<Card> findByAccountId(int id) {

        return em.createQuery("select card_number from CARDS where acc_id = " + id)
                .getResultList();
    }
}
