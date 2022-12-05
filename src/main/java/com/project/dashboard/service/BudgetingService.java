package com.project.dashboard.service;

import com.project.dashboard.model.BankAccount;
import com.project.dashboard.model.BaseResponse;
import com.project.dashboard.model.Budgeting;
import com.project.dashboard.model.Vendor;
import com.project.dashboard.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BudgetingService {

    @Autowired
    BudgetingRepository budgetingRepository;

    @Autowired
    VendorRepository vendorRepository;


    @Autowired
    UserService userService;

    public BaseResponse getBudgetingTransactionList(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;
        List<Budgeting> budgetList;
        List<Budgeting> budgetingListPaged;
        int limit = 0;
        int offset = 0;
        int startingData = 0;
        String searchParameter;
        String budgeting_status;
        int maxPage = 0;
        int transactionCount = 0;
        int pendingApprovalCount = 0;
        int pendingReleaseCount = 0;
        try {
            jsonInput = new JSONObject(input);
            searchParameter = jsonInput.optString("searchParameter");
            budgeting_status = jsonInput.optString("budgeting_status");
            if (searchParameter.isEmpty()) {
                searchParameter = "%%";
            }
            if (budgeting_status.isEmpty()) {
                budgeting_status = "%%";
            }
            limit = jsonInput.getInt("limit");
            offset = jsonInput.getInt("offset");
            startingData = (offset - 1) * limit;

            //TOKEN AUTH
//            Map<String, Object> auth = userService.tokenAuthentication(jsonInput.optString("user_token"));
//            if (Boolean.valueOf(auth.get("valid").toString()) == false) {
//                response.setStatus("500");
//                response.setSuccess(false);
//                response.setMessage("Token Authentication Failed");
//                return response;
//            }

            budgetList = budgetingRepository.getBudgetList(searchParameter, budgeting_status);
            transactionCount = budgetList.size();
            if (budgetList.size() > 0) {
                maxPage = (int) Math.ceil(budgetList.size() / (limit * 1.0));
                budgetingListPaged = budgetList.subList(startingData, Math.min((startingData + limit), budgetList.size()));
            } else {
                budgetingListPaged = new ArrayList<>();
            }
            for (Budgeting budgeting : budgetList) {
                String status = budgeting.getBudgeting_status();
                if (status.compareToIgnoreCase("Pending Approval") == 0) {
                    pendingApprovalCount++;
                } else if (status.compareToIgnoreCase("Pending Release") == 0) {
                    pendingReleaseCount++;
                }
            }

            Map<String, Object> results = new HashMap<>();
            results.put("data", budgetingListPaged);
            results.put("maxPage", maxPage);
            results.put("pendingApprovalCount", pendingApprovalCount);
            results.put("pendingReleaseCount", pendingReleaseCount);
            results.put("transactionCount", transactionCount);
            response.setData(results);
            response.setStatus("200");
            response.setSuccess(true);
            response.setMessage("Search data success");


        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to get budget list :" + e.getMessage());
        }


        return response;

    }

    public BaseResponse checkBudgetingStatus(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;

        try {
            jsonInput = new JSONObject(input);
            //HIT API TO CHECK STATUS RETURNING STATUS OF BUDGETING TRANSACTION

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to check budget status :" + e.getMessage());
        }

        return response;
    }

    public BaseResponse addNewBudgetTransaction(String input) throws Exception, SQLException {
        BaseResponse response = new BaseResponse();
        JSONObject jsonInput;
        String billing_date;
        String payment_plan_date;
        String contract_number;
        String invoice_number;
        Double amount;
        String currency;
        String primary_energy_type;
        String payment_destination_entity;
        String pln_entity;
        String budgeting_status = "";
        String data_status = "active";
        String created_by = "makers";
        String updated_by;
        String from_account;
        String beneficiary_account_type;
        String beneficiary_account_to;
        String beneficiary_instruction_mode_type;
        String beneficiary_notifications_flag;
        String beneficiary_notifications_email;
        String beneficiary_file;
        String remark;
        String remitter_reference_number;
        String beneficiary_reference_number;

        String inhouse_transaction_type;
        String transaction_purpose;

        String exchange_rate;
        Double exchange_rate_value;
        String services;
        String charge_to;

        String budgeting_transfer_type;
        try {
            jsonInput = new JSONObject(input);

            billing_date = jsonInput.getString("billing_date");
            payment_plan_date = jsonInput.getString("payment_plan_date");
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdformat.parse(billing_date);
            Date d2 = sdformat.parse(payment_plan_date);
            if (d1.compareTo(d2) > 0) {
                response.setStatus("500");
                response.setSuccess(false);
                response.setMessage("Payment date cannot set before the billing date");
            }
            beneficiary_account_to = jsonInput.getString("beneficiary_account_to");

            //Get Vendor information
            List<Vendor> vendorList = vendorRepository.getVendorByAccountNumber(beneficiary_account_to);
            if (vendorList.size() == 0) {
                response.setStatus("404");
                response.setSuccess(false);
                response.setMessage("cannot found vendor for account number : " + beneficiary_account_to);
            }
            Vendor vendor = vendorList.get(0);
            primary_energy_type = vendor.getVendor_primary_energy_type();
            payment_destination_entity = vendor.getVendor_name();
            pln_entity = vendor.getVendor_pln_entity();


            from_account = jsonInput.getString("from_account");
            beneficiary_account_type = jsonInput.getString("beneficiary_account_type");
            beneficiary_instruction_mode_type = jsonInput.getString("beneficiary_instruction_mode_type");
            beneficiary_notifications_flag = jsonInput.optString("beneficiary_notifications_flag");
            beneficiary_notifications_email = jsonInput.optString("beneficiary_notifications_email");
            beneficiary_file = jsonInput.optString("beneficiary_file");
            contract_number = jsonInput.getString("contract_number");
            invoice_number = jsonInput.getString("invoice_number");
            currency = jsonInput.getString("currency");
            amount = jsonInput.getDouble("amount");

            remark = jsonInput.optString("remarks");
            remitter_reference_number = jsonInput.optString("remitter_reference_number");
            beneficiary_reference_number = jsonInput.optString("beneficiary_reference_number");
            transaction_purpose = jsonInput.getString("transaction_purpose");

            exchange_rate = jsonInput.getString("exchange_rate");
            exchange_rate_value = jsonInput.getDouble("exchange_rate_value");
            services = jsonInput.getString("services");
            charge_to = jsonInput.getString("charge_to");

            inhouse_transaction_type = jsonInput.optString("inhouse_transaction_type");
            budgeting_transfer_type = jsonInput.getString("budgeting_transfer_type");


            Budgeting budgeting = new Budgeting();
            budgeting.setBilling_date(d1);
            budgeting.setPayment_plan_date(d2);
            budgeting.setContract_number(contract_number);
            budgeting.setInvoice_number(invoice_number);
            budgeting.setCurrency(currency);
            budgeting.setInhouse_transaction_type(inhouse_transaction_type);
            budgeting.setAmount(BigDecimal.valueOf(amount));
            budgeting.setBudgeting_status(budgeting_status);
            budgeting.setData_status(data_status);
            budgeting.setPrimary_energy_type(primary_energy_type);
            budgeting.setPayment_destination_entity(payment_destination_entity);
            budgeting.setPln_entity(pln_entity);
            budgeting.setFrom_account(from_account);
            budgeting.setBeneficiary_account_type(beneficiary_account_type);
            budgeting.setBeneficiary_account_to(beneficiary_account_to);
            budgeting.setBeneficiary_instruction_mode_type(beneficiary_instruction_mode_type);
            budgeting.setBeneficiary_notifications_flag(beneficiary_notifications_flag);
            budgeting.setBeneficiary_notifications_email(beneficiary_notifications_email);
            budgeting.setBeneficiary_file(beneficiary_file);
            budgeting.setBeneficiary_reference_number(beneficiary_reference_number);
            budgeting.setRemark(remark);
            budgeting.setRemitter_reference_number(remitter_reference_number);
            budgeting.setTransaction_purpose(transaction_purpose);
            budgeting.setExchange_rate(exchange_rate);
            budgeting.setExchange_rate_value(BigDecimal.valueOf(exchange_rate_value));
            budgeting.setServices(services);
            budgeting.setCharge_to(charge_to);
            budgeting.setBudgeting_transfer_type(budgeting_transfer_type);
            budgeting.setCreated_by(created_by);
            budgeting.setUpdated_by(created_by);

            budgetingRepository.save(budgeting);

        } catch (Exception e) {
            response.setStatus("500");
            response.setSuccess(false);
            response.setMessage("Failed to add new budget transaction :" + e.getMessage());
        }

        return response;
    }


}
