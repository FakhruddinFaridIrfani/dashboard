package com.project.dashboard.service;

import com.project.dashboard.model.Budgeting;
import com.project.dashboard.repository.BudgetingRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class DashBoardScheduler {

    @Autowired
    BudgetingRepository budgetingRepository;

    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(DashBoardScheduler.class);

    //    @Scheduled(cron = "0 0/45 * * * *", zone = "Asia/Jakarta")
    public void scheduledUploadKtpFile() throws Exception {
        logger.info("Checking transaction status");
        try {
            String completeUrl = "https://dashboard-pln.digi46.id/PrismaGateway/events/BNIDirect/InquiryTransactionStatus";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            List<Budgeting> budgetingList = budgetingRepository.findAll();
            for (Budgeting budgetTransaction : budgetingList) {
                JSONObject req = new JSONObject();
                HttpEntity<String> entity = new HttpEntity<>(req.toString(), headers);
                ResponseEntity<String> response = restTemplate.exchange(completeUrl, HttpMethod.POST, entity, String.class);
                if (response.getStatusCode() == HttpStatus.OK) {
                    JSONObject results = new JSONObject(response.getBody());
                    JSONObject transactionStatusHistory = results.getJSONObject("transactionStatusHistory");
                    String status = transactionStatusHistory.getString("trxStatus");

//                    budgetingRepository.updateBudgetingStatus();
                } else {
                    throw new RuntimeException(response.getStatusCode().getReasonPhrase());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }


    }


}
