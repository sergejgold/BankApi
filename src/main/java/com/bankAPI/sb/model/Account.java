package com.bankAPI.sb.model;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ACCOUNTS")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int user_id;
    private long account_number;
    private BigDecimal balance;
}
