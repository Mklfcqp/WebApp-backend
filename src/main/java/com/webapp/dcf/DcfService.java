package com.webapp.dcf;


import com.webapp.watchlist.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DcfService {

    private final DcfRepository dcfRepository;
    private final DcfMapper dcfMapper;


    //---------------addManualyDcf()---------------

    public void addManualyDcf(DcfAddManualRequest request) {

        Dcf dcf = dcfMapper.manualToDcf(request);
        dcfRepository.save(dcf);

    }

    //---------------addCalcDcf()---------------
    public void addCalcDcf(DcfAddCalcRequest request) {

        Dcf dcf = dcfMapper.calcToDcf(request);
        dcfRepository.save(dcf);

    }

    //---------------getDcf()---------------

    public List<DcfGetDcfRequest> getDcf() {

        return dcfRepository.findById().stream()
                .map(dcfMapper::toDcfGetDcfRequest)
                .toList();
    }

    //---------------getFinancial()---------------


    public List<DcfGetFinancialRequest> getFinancial() {

        return dcfRepository.findById().stream()
                .map(dcfMapper::toDcfGetFinancialRequest)
                .toList();
    }

    //---------------updateDcfManual()---------------

    public void updateDcfManual(DcfAddManualRequest request) {

        Dcf dcf = dcfMapper.manualToDcf(request);
        dcfRepository.save(dcf);
    }

    //---------------updateDcfCalc()---------------

    public void updateDcfCalc(DcfAddCalcRequest request) {

        Dcf dcf = dcfMapper.calcToDcf(request);
        dcfRepository.save(dcf);
    }

    //---------------deleteDcf()---------------

    public void deleteDcf(Long id) {
        dcfRepository.deleteById(id);
    }


}
