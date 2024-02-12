package com.webapp.dcf;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dcf")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
//@CrossOrigin("https://web-app-frontend-jeolwgw0x-mkqps-projects.vercel.app/")
public class DcfController {

    private final DcfService dcfService;

    //---------------addManualyDcf()---------------
    @PostMapping("/add/manual")
    public ResponseEntity<String> addManualyDcf(@RequestBody DcfAddManualRequest request) {
        try {

            dcfService.addManualyDcf(request);
            return ResponseEntity.ok("Dcf added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //---------------addCalcDcf()---------------
    @PostMapping("/add/calc")
    public ResponseEntity<String> addCalcDcf(@RequestBody DcfAddCalcRequest request) {
        try {

            dcfService.addCalcDcf(request);
            return ResponseEntity.ok("Dcf added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    //---------------getDcf()---------------
//
//    @GetMapping("/load/dcf")
//    public List<DcfGetDcfRequest> getDcf(){
//        return dcfService.getDcf();
//    }
//
//    //---------------getFinancial()---------------
//
//    @GetMapping("/load/financial")
//    public List<DcfGetFinancialRequest> getFinancial(){
//        return dcfService.getFinancial();
//    }
//
//    //---------------updateDcfManual()---------------
//
//    @PutMapping("/update/manual")
//    public ResponseEntity<String> updateDcfManual(@RequestBody DcfAddManualRequest request){
//        try {
//
//            dcfService.updateDcfManual(request);
//            return ResponseEntity.ok("Dcf updated successfully");
//        } catch (IllegalStateException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    //---------------updateDcfCalc()---------------
//
//    @PutMapping("/update/calc")
//    public ResponseEntity<String> updateDcfCalc(@RequestBody DcfAddCalcRequest request){
//        try {
//
//            dcfService.updateDcfCalc(request);
//            return ResponseEntity.ok("Dcf updated successfully");
//        } catch (IllegalStateException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    //---------------deleteDcf()---------------
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteDcf(@PathVariable("id") Long id){
//        dcfService.deleteDcf(id);
//    }
//


}
