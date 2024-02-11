package com.webapp.dcf;

import com.webapp.portfolio.Portfolio;
import com.webapp.portfolio.PortfolioAddRequest;
import com.webapp.portfolio.PortfolioGetRequest;
import com.webapp.portfolio.PortfolioGetRequestSUM;
import com.webapp.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DcfMapper {

    public DcfGetDcfRequest toDcfGetDcfRequest(Dcf dcf) {

        return DcfGetDcfRequest.builder()
                .id(dcf.getId())
                .dcfWithMarginOfSafety(dcf.getDcfWithMarginOfSafety())
                .build();
    }

    public DcfGetFinancialRequest toDcfGetFinancialRequest(Dcf dcf) {

        return DcfGetFinancialRequest.builder()
                .id(dcf.getId())
                .freeCashFlow0(dcf.getFreeCashFlow0())
                .freeCashFlow1(dcf.getFreeCashFlow1())
                .freeCashFlow2(dcf.getFreeCashFlow2())
                .freeCashFlow3(dcf.getFreeCashFlow3())
                .freeCashFlow4(dcf.getFreeCashFlow4())
                .freeCashFlow5(dcf.getFreeCashFlow5())
                .freeCashFlow6(dcf.getFreeCashFlow6())
                .freeCashFlow7(dcf.getFreeCashFlow7())
                .growthRate(dcf.getGrowthRate())
                .perpetualGrowthRate(dcf.getPerpetualGrowthRate())
                .discountRate(dcf.getDiscountRate())
                .cash(dcf.getCash())
                .totalDebt(dcf.getTotalDebt())
                .sharesOutstanding(dcf.getSharesOutstanding())
                .dcfWithMarginOfSafety(dcf.getDcfWithMarginOfSafety())
                .build();
    }

    public Dcf manualToDcf(DcfAddManualRequest dcfAddManualRequest) {

        return Dcf.builder()
                .id(dcfAddManualRequest.getId())
                .dcfWithMarginOfSafety(dcfAddManualRequest.getDcfWithMarginOfSafety())
                .build();
    }

    public Dcf calcToDcf(DcfAddCalcRequest dcfAddCalcRequest) {

        return Dcf.builder()
                .id(dcfAddCalcRequest.getId())
                .freeCashFlow0(dcfAddCalcRequest.getFreeCashFlow0())
                .freeCashFlow1(dcfAddCalcRequest.getFreeCashFlow1())
                .freeCashFlow2(dcfAddCalcRequest.getFreeCashFlow2())
                .freeCashFlow3(dcfAddCalcRequest.getFreeCashFlow3())
                .freeCashFlow4(dcfAddCalcRequest.getFreeCashFlow4())
                .freeCashFlow5(dcfAddCalcRequest.getFreeCashFlow5())
                .freeCashFlow6(dcfAddCalcRequest.getFreeCashFlow6())
                .freeCashFlow7(dcfAddCalcRequest.getFreeCashFlow7())
                .growth0(dcfAddCalcRequest.getGrowth0())
                .growth1(dcfAddCalcRequest.getGrowth1())
                .growth2(dcfAddCalcRequest.getGrowth2())
                .growth3(dcfAddCalcRequest.getGrowth3())
                .growth4(dcfAddCalcRequest.getGrowth4())
                .growth5(dcfAddCalcRequest.getGrowth5())
                .growth6(dcfAddCalcRequest.getGrowth6())
                .growthRate(dcfAddCalcRequest.getGrowthRate())
                .avgGrowthRate(dcfAddCalcRequest.getAvgGrowthRate())
                .futureFreeCashFlow0(dcfAddCalcRequest.getFutureFreeCashFlow0())
                .futureFreeCashFlow1(dcfAddCalcRequest.getFutureFreeCashFlow1())
                .futureFreeCashFlow2(dcfAddCalcRequest.getFutureFreeCashFlow2())
                .futureFreeCashFlow3(dcfAddCalcRequest.getFutureFreeCashFlow3())
                .futureFreeCashFlow4(dcfAddCalcRequest.getFutureFreeCashFlow4())
                .futureFreeCashFlow5(dcfAddCalcRequest.getFutureFreeCashFlow5())
                .futureFreeCashFlow6(dcfAddCalcRequest.getFutureFreeCashFlow6())
                .terminalValue(dcfAddCalcRequest.getTerminalValue())
                .pvOfFreeCashFlow0(dcfAddCalcRequest.getPvOfFreeCashFlow0())
                .pvOfFreeCashFlow1(dcfAddCalcRequest.getPvOfFreeCashFlow1())
                .pvOfFreeCashFlow2(dcfAddCalcRequest.getPvOfFreeCashFlow2())
                .pvOfFreeCashFlow3(dcfAddCalcRequest.getPvOfFreeCashFlow3())
                .pvOfFreeCashFlow4(dcfAddCalcRequest.getPvOfFreeCashFlow4())
                .pvOfFreeCashFlow5(dcfAddCalcRequest.getPvOfFreeCashFlow5())
                .pvOfFreeCashFlow6(dcfAddCalcRequest.getPvOfFreeCashFlow6())
                .pvOfFreeCashFlow7(dcfAddCalcRequest.getPvOfFreeCashFlow7())
                .perpetualGrowthRate(dcfAddCalcRequest.getPerpetualGrowthRate())
                .discountRate(dcfAddCalcRequest.getDiscountRate())
                .sumPvOfFcf(dcfAddCalcRequest.getSumPvOfFcf())
                .cash(dcfAddCalcRequest.getCash())
                .totalDebt(dcfAddCalcRequest.getTotalDebt())
                .equityValue(dcfAddCalcRequest.getEquityValue())
                .sharesOutstanding(dcfAddCalcRequest.getSharesOutstanding())
                .dcfWithoutMarginOfSafety(dcfAddCalcRequest.getDcfWithoutMarginOfSafety())
                .dcfWithMarginOfSafety(dcfAddCalcRequest.getDcfWithMarginOfSafety())
                .build();
    }

}
