package com.webapp.watchlist;

import com.webapp.dcf.Dcf;
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
@Table(name = "watchlist")
public class Watchlist {

    @Id
    @GeneratedValue
    private Long id;
    private String ticker;
    private String company;
    private BigDecimal price;
    private String currencyPrice;
    private String currencyDcf;
    private BigDecimal dividendY;
    private String currencyDividendY;
    private BigDecimal dividendQ;
    private String currencyDividendQ;
    private BigDecimal dividendYield;
    private String overValuedUnderValued;

    private BigDecimal dcf;
//    @OneToOne(mappedBy = "watchlist")
//    private Dcf dcf;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
