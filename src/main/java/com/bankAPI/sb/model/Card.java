package com.bankAPI.sb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name= Card.GetAll, query = "FROM CARDS")
})
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "CARDS")
public class Card {
    public static final String GetAll = "Card.GetAll";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int acc_id;
    private String card_number;

}



