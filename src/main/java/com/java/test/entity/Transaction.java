package com.java.test.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Transaction extends Auditable{

    @Id
    @SequenceGenerator(allocationSize = 1, name = "transaction_idgen", sequenceName = "transaction_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_idgen")
    private Long id;


    private String email;
    private LocalDateTime tanggal;
    private int subtotal;
    private int margin;
    private int pajak;
    private final int shippingCost = 10000;
    private int totalPayment;
    @ManyToOne
    @JoinColumn(name = "periode_margin_id")
    private PeriodeMargin periodeMargin;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<DetailTransaction>detailTransactionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getPajak() {
        return pajak;
    }

    public void setPajak(int pajak) {
        this.pajak = pajak;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public PeriodeMargin getPeriodeMargin() {
        return periodeMargin;
    }

    public void setPeriodeMargin(PeriodeMargin periodeMargin) {
        this.periodeMargin = periodeMargin;
    }

    public List<DetailTransaction> getDetailTransactionList() {
        return detailTransactionList;
    }

    public void setDetailTransactionList(List<DetailTransaction> detailTransactionList) {
        this.detailTransactionList = detailTransactionList;
    }
}
