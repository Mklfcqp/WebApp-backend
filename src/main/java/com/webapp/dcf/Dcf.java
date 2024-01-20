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

    private String company;

    private BigDecimal freeCashFlow0; // vyplnit
    private BigDecimal freeCashFlow1; // vyplnit
    private BigDecimal freeCashFlow2; // vyplnit
    private BigDecimal freeCashFlow3; // vyplnit
    private BigDecimal freeCashFlow4; // vyplnit
    private BigDecimal freeCashFlow5; // vyplnit
    private BigDecimal freeCashFlow6; // vyplnit
    private BigDecimal freeCashFlow7; // vyplnit

    private BigDecimal growth0; // growth0 = (freeCashFlow0 - freeCashFlow1) / freeCashFlow1
    private BigDecimal growth1; // growth1 = (freeCashFlow1 - freeCashFlow2) / freeCashFlow2
    private BigDecimal growth2; // growth2 = (freeCashFlow2 - freeCashFlow3) / freeCashFlow3
    private BigDecimal growth3; // growth3 = (freeCashFlow3 - freeCashFlow4) / freeCashFlow4
    private BigDecimal growth4; // growth4 = (freeCashFlow4 - freeCashFlow5) / freeCashFlow5
    private BigDecimal growth5; // growth5 = (freeCashFlow5 - freeCashFlow6) / freeCashFlow6
    private BigDecimal growth6; // growth6 = (freeCashFlow6 - freeCashFlow7) / freeCashFlow7
    private BigDecimal growth7; // neni potreba?

    private BigDecimal growthRate; // vyplnit
    private BigDecimal avgGrowthRate; // vypocet (viz nize)

    private BigDecimal futureFreeCashFlow0; // futureFreeCashFlow0 = freeCashFlow0 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow1; // futureFreeCashFlow1 = futureFreeCashFlow0 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow2; // futureFreeCashFlow2 = futureFreeCashFlow1 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow3; // futureFreeCashFlow3 = futureFreeCashFlow2 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow4; // futureFreeCashFlow4 = futureFreeCashFlow3 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow5; // futureFreeCashFlow5 = futureFreeCashFlow4 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow6; // futureFreeCashFlow6 = futureFreeCashFlow5 * (1 + growthRate)

    private BigDecimal terminalValue; // terminalValue = futureFreeCashFlow6 * (1 + perpetualGrowthRate) / (discountRate - perpetualGrowthRate)

    private BigDecimal pvOfFreeCashFlow0; // pvOfFreeCashFlow0 = futureFreeCashFlow0 / Math.pow((1 + discountRate), 1)
    private BigDecimal pvOfFreeCashFlow1; // pvOfFreeCashFlow1 = futureFreeCashFlow1 / Math.pow((1 + discountRate), 2)
    private BigDecimal pvOfFreeCashFlow2; // pvOfFreeCashFlow2 = futureFreeCashFlow2 / Math.pow((1 + discountRate), 3)
    private BigDecimal pvOfFreeCashFlow3; // pvOfFreeCashFlow3 = futureFreeCashFlow3 / Math.pow((1 + discountRate), 4)
    private BigDecimal pvOfFreeCashFlow4; // pvOfFreeCashFlow4 = futureFreeCashFlow4 / Math.pow((1 + discountRate), 5)
    private BigDecimal pvOfFreeCashFlow5; // pvOfFreeCashFlow5 = futureFreeCashFlow5 / Math.pow((1 + discountRate), 6)
    private BigDecimal pvOfFreeCashFlow6; // pvOfFreeCashFlow6 = futureFreeCashFlow6 / Math.pow((1 + discountRate), 7)
    private BigDecimal pvOfFreeCashFlow7; // pvOfFreeCashFlow7 = futureFreeCashFlow7 / Math.pow((1 + discountRate), 8)

    private BigDecimal perpetualGrowthRate; // vyplnit
    private BigDecimal discountRate; // vyplnit

    private BigDecimal sumPvOfFcf; // vypocet (viz nize)
    private BigDecimal cash; // vyplnit
    private BigDecimal totalDebt; // vyplnit

    private BigDecimal equityValue; // equityValue = sumPvOfFcf + cash - totalDebt
    private BigDecimal sharesOutstanding; // vyplnit

    private BigDecimal dcfWithoutMarginOfSafety; // dcfWithoutMarginOfSafety = equityValue / sharesOutstanding
    private BigDecimal dcfWithMarginOfSafety; // dcfWithMarginOfSafety = dcfWithoutMarginOfSafety * 0,8


    @OneToOne
    @JoinColumn(name = "watchlist_id")
    private Watchlist watchlist;





//--------------------------------------vypocet avgGrowthRate--------------------------------------

    // poupravit - neni finalni (prace s null hodnotami?)

//    ArrayList<BigDecimal> avgGrowthRateValues = new ArrayList<>();
//
//  avgGrowthRateValues.add(pvOfFreeCashFlow0);
//  avgGrowthRateValues.add(pvOfFreeCashFlow1);
//  avgGrowthRateValues.add(pvOfFreeCashFlow2);
//  avgGrowthRateValues.add(pvOfFreeCashFlow3);
//  avgGrowthRateValues.add(pvOfFreeCashFlow4);
//  avgGrowthRateValues.add(pvOfFreeCashFlow5);
//  avgGrowthRateValues.add(pvOfFreeCashFlow6);

//    double prumer = calculationAvgGrowthRate(avgGrowthRate);
//
//
//    public static BigDecimal calculationAvgGrowthRate(ArrayList<BigDecimal> avgGrowthRateValues) {
//        BigDecimal sum = 0.0;
//
//        for (BigDecimal value : avgGrowthRateValues) {
//            sum += value;
//        }
//
//        avgGrowthRate = sum / avgGrowthRate.size();
//
//        return avgGrowthRate;
//    }
//
//
////--------------------------------------vypocet sumPvOfFcf--------------------------------------
//
//    // poupravit - neni finalni (prace s null hodnotami?)
//
//    ArrayList<BigDecimal> sumPvOfFcfValues = new ArrayList<>();
//
//  sumPvOfFcfValues.add(growth0);
//  sumPvOfFcfValues.add(growth1);
//  sumPvOfFcfValues.add(growth2);
//  sumPvOfFcfValues.add(growth3);
//  sumPvOfFcfValues.add(growth4);
//  sumPvOfFcfValues.add(growth5);
//  sumPvOfFcfValues.add(growth6);
//
//    double soucet = calculationAvgGrowthRate(avgGrowthRate);
//
//
//    public static BigDecimal calculationSumPvOfFcf(ArrayList<BigDecimal> calculationAvgGrowthRate) {
//        BigDecimal sum = 0.0;
//
//        for (BigDecimal value : calculationSumPvOfFcf) {
//            sum += value;
//        }
//
//        sumPvOfFcf = ;
//
//        return sumPvOfFcf;
//    }
}
