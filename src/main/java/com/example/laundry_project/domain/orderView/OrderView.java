package com.example.laundry_project.domain.orderView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_view")
@Entity
public class OrderView {
    @Id
    private int orderCode;

    private int clientCode;
    private String orderstatusCategoryKind;
    private int orderstatusCategoryCode;
    private Timestamp orderOrderDate;
    private Timestamp orderPaymentDate;
    private Timestamp orderCollectionDate;
    private Timestamp orderDeliveryDate;
    private boolean orderReviewIsWritten;

}
