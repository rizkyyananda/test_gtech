package com.java.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class PeriodeMargin extends Auditable{
    @Id
    @SequenceGenerator(allocationSize = 1, name = "periode_margin_idgen", sequenceName = "periode_margin_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "periode_margin_idgen")
    private Long id;

    @Column(nullable = false)
    private String periodName;

    @Column(nullable = false)
    private double margin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }
}
