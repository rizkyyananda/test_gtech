package com.java.test.repository;

import com.java.test.entity.DetailTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportTransactionRepository extends JpaRepository<DetailTransaction, Long> {
    @Query("SELECT dt FROM DetailTransaction dt " +
            "JOIN dt.transaction t " +
            "JOIN t.periodeMargin p " +
            "WHERE t.tanggal BETWEEN :startDate AND :endDate")
    List<DetailTransaction> findAllByTransactionDateBetween(@Param("startDate") LocalDateTime start,
                                                    @Param("endDate") LocalDateTime end);
}
