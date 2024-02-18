package com.example.laundry_project.service;

import com.example.laundry_project.domain.order.Order;
import com.example.laundry_project.domain.orderView.OrderView;
import com.example.laundry_project.repository.OrderViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderViewService {

    private final OrderViewRepository orderViewRepository;

    // pageable 처리 전
    public List<OrderView> getOrderByClientCode(int clientCode){
        return orderViewRepository.findAllByClientCodeOrderByOrderOrderDateDesc(clientCode);
    }

    // pageable 처리 후
    public Page<OrderView> getOrderByClientCode(int clientCode, Pageable pageable){
        return orderViewRepository.findAllByClientCode(clientCode,pageable);
    }

    public List<OrderView> getOrderView() {
        return orderViewRepository.findAllByOrderByOrderCollectionDateDesc();
    }

    public Page<OrderView> getOrderViewByPage(Pageable pageable) {
        return orderViewRepository.findAllByOrderByOrderCollectionDateDesc(pageable);
    }
    public Page<OrderView> getOrderByClientCodeByPage(int clientCode , Pageable pageable){
        return orderViewRepository.findAllByClientCodeOrderByOrderOrderDateDesc(clientCode, pageable);
    }
    public Page<OrderView> getOrderByOrderCodeByPage(int orderCode , Pageable pageable){
        return orderViewRepository.findAllByOrderCodeOrderByOrderOrderDateDesc(orderCode, pageable);
    }
    public Page<OrderView> getOrderByCollectDateByPage(Timestamp collectDate , Pageable pageable){
        return orderViewRepository.findAllByOrderCollectionDateOrderByOrderOrderDateDesc(collectDate, pageable);
    }
    public Page<OrderView> getOrderByCategoryCodeByPage(int categoryCode , Pageable pageable){
        return orderViewRepository.findAllByOrderstatusCategoryCodeOrderByOrderOrderDateDesc(categoryCode, pageable);
    }

    public Page<OrderView> getOrdersByAll(int orderCode, int clientCode, Timestamp collectDate, int categoryCode, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndClientCodeAndOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(orderCode,clientCode,collectDate,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByOrderCodeAndClientCodeAndOrderCollectionDate(int orderCode, int clientCode, Timestamp collectDate, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndClientCodeAndOrderCollectionDateOrderByOrderOrderDateDesc(orderCode,clientCode,collectDate,pageable);
    }
    public Page<OrderView> getOrdersByOrderCodeAndClientCodeAndOrderstatusCategoryCode(int orderCode, int clientCode, int categoryCode, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndClientCodeAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(orderCode,clientCode,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByOrderCodeAndOrderCollectionDateAndOrderstatusCategoryCode(int orderCode, Timestamp collectDate, int categoryCode, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(orderCode,collectDate,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByClientCodeAndOrderCollectionDateAndOrderstatusCategoryCode(int clientCode, Timestamp collectDate, int categoryCode, Pageable pageable){
        return orderViewRepository.findByClientCodeAndOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(clientCode,collectDate,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByOrderCodeAndClientCode(int orderCode, int clientCode, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndClientCodeOrderByOrderOrderDateDesc(orderCode,clientCode,pageable);
    }
    public Page<OrderView> getOrdersByOrderCodeAndOrderstatusCategoryCode(int orderCode, int categoryCode, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(orderCode,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByOrderCollectionDateAndOrderstatusCategoryCode(Timestamp collectDate, int categoryCode, Pageable pageable){
        return orderViewRepository.findByOrderCollectionDateAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(collectDate,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByClientCodeAndOrderCollectionDate(int clientCode, Timestamp collectDate, Pageable pageable){
        return orderViewRepository.findByClientCodeAndOrderCollectionDateOrderByOrderOrderDateDesc(clientCode,collectDate,pageable);
    }
    public Page<OrderView> getOrdersByClientCodeAndOrderstatusCategoryCode(int clientCode, int categoryCode, Pageable pageable){
        return orderViewRepository.findByClientCodeAndOrderstatusCategoryCodeOrderByOrderOrderDateDesc(clientCode,categoryCode,pageable);
    }
    public Page<OrderView> getOrdersByOrderCodeAndOrderCollectionDate(int orderCode, Timestamp collectDate, Pageable pageable){
        return orderViewRepository.findByOrderCodeAndOrderCollectionDateOrderByOrderOrderDateDesc(orderCode,collectDate,pageable);
    }

}
