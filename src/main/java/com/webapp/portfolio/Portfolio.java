package com.webapp.portfolio;

import com.webapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue
    private Long id;
    private String ticker;
    private String company;

    private Long shares;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal interestBuySell;
    private BigDecimal profitLossBuySell;
    private BigDecimal dividend;
    private BigDecimal interestDividend;
    private BigDecimal profitLossDividend;
    private BigDecimal sumProfitLoss;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ?? Celkem (nákup i s prodejem + nákup za dividendy) ??
}
