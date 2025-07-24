package com.java.test.service;

import com.java.test.dto.ResponseObject;
import com.java.test.dto.response.PaginationResponse;
import com.java.test.dto.response.ReportTransactionDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReportTransactionService {
    List<ReportTransactionDTO> getReportTransaction(LocalDate startDate, LocalDate endDate);
}
