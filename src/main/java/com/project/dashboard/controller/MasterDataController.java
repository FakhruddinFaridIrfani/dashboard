package com.project.dashboard.controller;

import com.project.dashboard.model.BaseResponse;
import com.project.dashboard.service.MasterDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("master")
public class MasterDataController {

    @Autowired
    MasterDataService masterDataService;


    Logger logger = LoggerFactory.getLogger(MasterDataController.class);

    @PostMapping("/getBankAccountList")
    public BaseResponse getBankAccountList(@RequestBody String input) throws Exception {
        logger.info("Get bank account list :  " + input);
        return masterDataService.getBankAccountList(input);
    }

    @GetMapping("/getBankAccountListAll")
    public BaseResponse getBankAccountListAll() throws Exception {
        logger.info("Get bank account list (all)");
        return masterDataService.getBankAccountListAll();
    }

    @PostMapping("/getVendorList")
    public BaseResponse getVendorList(@RequestBody String input) throws Exception {
        logger.info("Get vendor list :  " + input);
        return masterDataService.getVendorList(input);
    }

    @GetMapping("/getVendorListAll")
    public BaseResponse getVendorListAll() throws Exception {
        logger.info("Get vendor list (all)");
        return masterDataService.getVendorListAll();
    }

    @PostMapping("/getRateJisdorList")
    public BaseResponse getRateJisdorList(@RequestBody String input) throws Exception {
        logger.info("Get rate jisdor list :  " + input);
        return masterDataService.getRateJisdorList(input);
    }

    @GetMapping("/getLatestRateJisdor")
    public BaseResponse getLatestRateJisdor() throws Exception {
        logger.info("Get latest rate jisdor");
        return masterDataService.getLatestRateJisdor();
    }

    @PostMapping("/getTransactionPurposeList")
    public BaseResponse getTransactionPurposeList(@RequestBody String input) throws Exception {
        logger.info("Get transaction purpose list :  " + input);
        return masterDataService.getTransactionPurposeList(input);
    }

    @GetMapping("/getTransactionListAll")
    public BaseResponse getTransactionListAll() throws Exception {
        logger.info("Get transaction purpose list (all)");
        return masterDataService.getTransactionListAll();
    }
}
