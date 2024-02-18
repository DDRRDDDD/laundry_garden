package com.example.laundry_project.repository;

import com.example.laundry_project.domain.orderView.OrderView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OrderViewRepository extends JpaRepository<OrderView, Integer> {

    public List<OrderView> findAllByClientCodeOrderByOrderOrderDateDesc(int clientCode);

    public Page<OrderView> findAllByClientCode(int clientCode,
                                               Pageable pageable);

    public List<OrderView> findAllByOrderByOrderCollectionDateDesc();

    public Page<OrderView> findAllByOrderByOrderCollectionDateDesc(Pageable pageable);

    public Page<OrderView> findByOrderCodeAndClientCodeAndOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int orderCode, int clientCode, Timestamp collectDate, int categoryCode, Pageable pageable);

    public Page<OrderView> findAllByClientCodeOrderByOrderOrderDateDesc(int clientCode , Pageable pageable);

    public Page<OrderView> findAllByOrderCodeOrderByOrderOrderDateDesc(int orderCode , Pageable pageable);

    public Page<OrderView> findAllByOrderCollectionDateOrderByOrderOrderDateDesc(Timestamp collectDate, Pageable pageable);

    public Page<OrderView> findAllByOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int categoryCode , Pageable pageable);

    public Page<OrderView> findByOrderCodeAndClientCodeAndOrderCollectionDateOrderByOrderOrderDateDesc(int orderCode, int clientCode, Timestamp collectDate, Pageable pageable);

    public Page<OrderView> findByOrderCodeAndClientCodeAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int orderCode, int clientCode, int categoryCode, Pageable pageable);

    public Page<OrderView> findByOrderCodeAndOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int orderCode, Timestamp collectDate, int categoryCode, Pageable pageable);

    public Page<OrderView> findByClientCodeAndOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int clientCode, Timestamp collectDate, int categoryCode, Pageable pageable);

    public Page<OrderView> findByOrderCodeAndClientCodeOrderByOrderOrderDateDesc(int orderCode, int clientCode, Pageable pageable);

    public Page<OrderView> findByOrderCodeAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int orderCode, int categoryCode, Pageable pageable);

    public Page<OrderView> findByOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(Timestamp collectDate, int categoryCode, Pageable pageable);

    public Page<OrderView> findByClientCodeAndOrderCollectionDateOrderByOrderOrderDateDesc(int clientCode, Timestamp collectDate, Pageable pageable);

    public Page<OrderView> findByClientCodeAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(int clientCode, int categoryCode, Pageable pageable);

    public Page<OrderView> findByOrderCodeAndOrderCollectionDateOrderByOrderOrderDateDesc(int orderCode, Timestamp collectDate, Pageable pageable);




}
