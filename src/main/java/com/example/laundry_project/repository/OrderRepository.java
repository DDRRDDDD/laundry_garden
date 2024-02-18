package com.example.laundry_project.repository;

import com.example.laundry_project.domain.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    // pageable 처리 전
    public List<Order> getAllByClientCode(int clientCode);

    // pageable 처리 후
    public Page<Order> getAllByClientCode(int clientCode,
                                          Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM `orders`")
    public List<Order> getOrderAll();

    public List<Order> getOrderByOrderstatusCategoryCode(int code);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE `orders` SET orderstatus_category_code =?1 WHERE order_code = ?2")
    public void updateStatusByOrderCode(int statusCode, int orderCode);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE  `orders` SET order_payment_date = CONVERT_TZ(current_timestamp(), 'UTC', 'Asia/Seoul') WHERE order_code = ?1")
    public void updatePaymentDateByOrderCode(int orderCode);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE  `orders` SET order_review_is_written = '1' WHERE order_code = ?1")
    public void updateIsWrittenByOrderCode(int orderCode);


}
