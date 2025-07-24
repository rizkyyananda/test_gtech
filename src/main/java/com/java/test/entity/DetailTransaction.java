package com.java.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class DetailTransaction extends Auditable{
    @Id
    @SequenceGenerator(allocationSize = 1, name = "detail_transaction_idgen", sequenceName = "detail_transaction_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_transaction_idgen")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private int productPrice;

    @Column(nullable = false)
    private int totalProduct;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
