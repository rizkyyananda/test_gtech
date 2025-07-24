package com.java.test.controller;


import com.java.test.dto.response.ReportTransactionDTO;
import com.java.test.service.ReportTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportTransactionController {
    @Autowired
    private final ReportTransactionService reportTransactionService;

    public ReportTransactionController(ReportTransactionService reportTransactionService) {
        this.reportTransactionService = reportTransactionService;
    }

    @GetMapping("/sale")
    public ResponseEntity<List<ReportTransactionDTO>> getReportTransaction(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                                           @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        List<ReportTransactionDTO> reportTransactionDTOList = reportTransactionService.getReportTransaction(start, end);

        return ResponseEntity.ok(reportTransactionDTOList);
    }
}
