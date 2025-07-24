package com.java.test.service.impl;

import com.java.test.dto.response.ReportTransactionDTO;
import com.java.test.entity.DetailTransaction;
import com.java.test.entity.Product;
import com.java.test.repository.ReportTransactionRepository;
import com.java.test.service.ReportTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ReportTransactionServiceImpl implements ReportTransactionService {


    @Autowired
    private final ReportTransactionRepository reportTransactionRepository;

    public ReportTransactionServiceImpl(ReportTransactionRepository reportTransactionRepository) {
        this.reportTransactionRepository = reportTransactionRepository;
    }


    @Override
    public List<ReportTransactionDTO> getReportTransaction(LocalDate startDate, LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);

        List<DetailTransaction> detailTransactionList = reportTransactionRepository.findAllByTransactionDateBetween(start, end);

        List<ReportTransactionDTO> reportTransactionDTOList = new ArrayList<>();
        AtomicInteger no = new AtomicInteger(1);

        detailTransactionList.forEach(detailTransaction -> {
            Product product = detailTransaction.getProduct();
            int price = detailTransaction.getProductPrice();
            double marginPercentage = detailTransaction.getTransaction().getPeriodeMargin().getMargin();
            int margin = (int) (price * marginPercentage);
            ReportTransactionDTO reportTransactionDTO = new ReportTransactionDTO();
            reportTransactionDTO.setId(detailTransaction.getId());
            reportTransactionDTO.setNo(no.getAndIncrement());
            reportTransactionDTO.setProductId(product.getId());
            reportTransactionDTO.setProductName(product.getName());
            reportTransactionDTO.setProductType(product.getProductType());
            reportTransactionDTO.setPrice(price);
            reportTransactionDTO.setMargin(margin);
            reportTransactionDTOList.add(reportTransactionDTO);
        });

        return reportTransactionDTOList;
    }
}
