package com.webapp.dcf;

import com.webapp.watchlist.Watchlist;
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
@Table(name = "dcf")
public class Dcf {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal freeCashFlow0;
    private BigDecimal freeCashFlow1;
    private BigDecimal freeCashFlow2;
    private BigDecimal freeCashFlow3;
    private BigDecimal freeCashFlow4;
    private BigDecimal freeCashFlow5;
    private BigDecimal freeCashFlow6;
    private BigDecimal freeCashFlow7;

    private BigDecimal growth0;
    private BigDecimal growth1;
    private BigDecimal growth2;
    private BigDecimal growth3;
    private BigDecimal growth4;
    private BigDecimal growth5;
    private BigDecimal growth6;

    private BigDecimal growthRate;
    private BigDecimal avgGrowthRate;

    private BigDecimal futureFreeCashFlow0;
    private BigDecimal futureFreeCashFlow1;
    private BigDecimal futureFreeCashFlow2;
    private BigDecimal futureFreeCashFlow3;
    private BigDecimal futureFreeCashFlow4;
    private BigDecimal futureFreeCashFlow5;
    private BigDecimal futureFreeCashFlow6;

    private BigDecimal terminalValue;

    private BigDecimal pvOfFreeCashFlow0;
    private BigDecimal pvOfFreeCashFlow1;
    private BigDecimal pvOfFreeCashFlow2;
    private BigDecimal pvOfFreeCashFlow3;
    private BigDecimal pvOfFreeCashFlow4;
    private BigDecimal pvOfFreeCashFlow5;
    private BigDecimal pvOfFreeCashFlow6;
    private BigDecimal pvOfFreeCashFlow7;

    private BigDecimal perpetualGrowthRate;
    private BigDecimal discountRate;

    private BigDecimal sumPvOfFcf;
    private BigDecimal cash;
    private BigDecimal totalDebt;

    private BigDecimal equityValue;
    private BigDecimal sharesOutstanding;

    private BigDecimal dcfWithoutMarginOfSafety;
    private BigDecimal dcfWithMarginOfSafety;


    @OneToOne
    @JoinColumn(name = "watchlist_id")
    private Watchlist watchlist;



}
