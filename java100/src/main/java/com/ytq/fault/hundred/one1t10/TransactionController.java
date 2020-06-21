package com.ytq.fault.hundred.one1t10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuantongqin
 * desc:
 * 2020-06-21
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("")
    public String setBack(){

        transactionService.back();

        return null;
    }
}
