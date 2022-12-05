package com.project.dashboard.controller;

import com.project.dashboard.model.BaseResponse;
import com.project.dashboard.service.BudgetingService;
import com.project.dashboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("budgeting")
public class BudgetingController {

    @Autowired
    BudgetingService budgetingService;

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(BudgetingController.class);

    @PostMapping("/getBudgetList")
    public BaseResponse getBudgetList(@RequestBody String input) throws Exception {
        logger.info("Get budget list :  " + input);
        return budgetingService.getBudgetingTransactionList(input);
    }

    @PostMapping("/checkBudgetingTransactionStatus")
    public BaseResponse checkBudgetingTransactionStatus(@RequestBody String input) throws Exception {
        logger.info("Check budget status :  " + input);
        return budgetingService.checkBudgetingStatus(input);
    }

        @PostMapping("/addNewBudgetTransaction")
    public BaseResponse addNewBudgetTransaction(@RequestBody String input) throws Exception {
        logger.info("Add new budget transaction :  " + input);
        return budgetingService.addNewBudgetTransaction(input);
    }
}
