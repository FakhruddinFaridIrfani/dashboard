package com.project.dashboard.service;


import com.project.dashboard.model.*;
import com.project.dashboard.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MasterDataService {
    @Autowired
    SystemParameterRepository systemParameterRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    RateJisdorRepository rateJisdorRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    TransactionPurposeRepository transactionPurposeRepository;


    //BANK ACCOUNT
    public BaseResponse getBankAccountList(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;
        int limit = 0;
        int offset = 0;
        int startingData = 0;
        int maxPage = 0;

        List<BankAccount> bankAccountList;
        List<BankAccount> bankAccountListPaged;
        try {
            jsonInput = new JSONObject(input);
            limit = jsonInput.getInt("limit");
            offset = jsonInput.getInt("offset");
            startingData = (offset - 1) * limit;
            bankAccountList = bankAccountRepository.findAll();
            if (bankAccountList.size() > 0) {
                maxPage = (int) Math.ceil(bankAccountList.size() / (limit * 1.0));
                bankAccountListPaged = bankAccountList.subList(startingData, Math.min((startingData + limit), bankAccountList.size()));
            } else {
                bankAccountListPaged = new ArrayList<>();
            }
            Map<String, Object> results = new HashMap<>();
            results.put("data", bankAccountListPaged);
            results.put("maxPage", maxPage);
            response.setData(results);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Bank account listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list bank account :" + e.getMessage());
        }

        return response;

    }

    public BaseResponse getBankAccountListAll() throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        List<BankAccount> bankAccountList;
        try {
            bankAccountList = bankAccountRepository.findAll();
            response.setData(bankAccountList);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Bank account listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list bank account :" + e.getMessage());
        }

        return response;

    }

    //VENDOR
    public BaseResponse getVendorList(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;
        int limit = 0;
        int offset = 0;
        int startingData = 0;
        int maxPage = 0;

        List<Vendor> vendorList;
        List<Vendor> vendorListPaged;
        try {
            jsonInput = new JSONObject(input);
            limit = jsonInput.getInt("limit");
            offset = jsonInput.getInt("offset");
            startingData = (offset - 1) * limit;
            vendorList = vendorRepository.findAll();
            if (vendorList.size() > 0) {
                maxPage = (int) Math.ceil(vendorList.size() / (limit * 1.0));
                vendorListPaged = vendorList.subList(startingData, Math.min((startingData + limit), vendorList.size()));
            } else {
                vendorListPaged = new ArrayList<>();
            }
            Map<String, Object> results = new HashMap<>();
            results.put("data", vendorListPaged);
            results.put("maxPage", maxPage);
            response.setData(results);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Vendor listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list vendor :" + e.getMessage());
        }

        return response;

    }

    public BaseResponse getVendorListAll() throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        List<Vendor> vendorList;
        try {
            vendorList = vendorRepository.findAll();
            response.setData(vendorList);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Vendor listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list vendor :" + e.getMessage());
        }

        return response;

    }

    //RATE JISDOR
    public BaseResponse getRateJisdorList(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;
        int limit = 0;
        int offset = 0;
        int startingData = 0;
        int maxPage = 0;

        List<RateJisdor> rateJisdorList;
        List<RateJisdor> rateJisdorListPaged;
        try {
            jsonInput = new JSONObject(input);
            limit = jsonInput.getInt("limit");
            offset = jsonInput.getInt("offset");
            startingData = (offset - 1) * limit;
            rateJisdorList = rateJisdorRepository.findAll();
            if (rateJisdorList.size() > 0) {
                maxPage = (int) Math.ceil(rateJisdorList.size() / (limit * 1.0));
                rateJisdorListPaged = rateJisdorList.subList(startingData, Math.min((startingData + limit), rateJisdorList.size()));
            } else {
                rateJisdorListPaged = new ArrayList<>();
            }
            Map<String, Object> results = new HashMap<>();
            results.put("data", rateJisdorListPaged);
            results.put("maxPage", maxPage);
            response.setData(results);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Rate jisdor listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list rate jisdor :" + e.getMessage());
        }

        return response;

    }

    public BaseResponse getLatestRateJisdor() throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        List<RateJisdor> rateJisdorList;
        try {
            rateJisdorList = rateJisdorRepository.getLatestRateJisdor();

            if (rateJisdorList.size() > 0) {
                response.setData(rateJisdorList.get(0));
                response.setStatus("200");
                response.setSuccess(true);
                response.setMessage("Rate jisdor listed");
            } else {
                response.setStatus("404");
                response.setSuccess(false);
                response.setMessage("No rate jisdor found");
            }


        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to get rate jisdor :" + e.getMessage());
        }

        return response;

    }

    //TRANSACTION PURPOSE
    public BaseResponse getTransactionPurposeList(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;
        int limit = 0;
        int offset = 0;
        int startingData = 0;
        int maxPage = 0;

        List<TransactionPurpose> transactionPurposeList;
        List<TransactionPurpose> transactionPurposeListPaged;
        try {
            jsonInput = new JSONObject(input);
            limit = jsonInput.getInt("limit");
            offset = jsonInput.getInt("offset");
            startingData = (offset - 1) * limit;
            transactionPurposeList = transactionPurposeRepository.findAll();
            if (transactionPurposeList.size() > 0) {
                maxPage = (int) Math.ceil(transactionPurposeList.size() / (limit * 1.0));
                transactionPurposeListPaged = transactionPurposeList.subList(startingData, Math.min((startingData + limit), transactionPurposeList.size()));
            } else {
                transactionPurposeListPaged = new ArrayList<>();
            }
            Map<String, Object> results = new HashMap<>();
            results.put("data", transactionPurposeListPaged);
            results.put("maxPage", maxPage);
            response.setData(results);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Transaction purpose listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list transaction purpose :" + e.getMessage());
        }

        return response;

    }

    public BaseResponse getTransactionListAll() throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        List<TransactionPurpose> transactionPurposeList;
        try {
            transactionPurposeList = transactionPurposeRepository.findAll();
            response.setData(transactionPurposeList);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Transaction purpose listed");

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to list transaction purpose :" + e.getMessage());
        }

        return response;

    }
}
