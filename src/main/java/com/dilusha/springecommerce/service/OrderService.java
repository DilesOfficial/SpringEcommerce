package com.dilusha.springecommerce.service;

import com.dilusha.springecommerce.model.OderItem;
import com.dilusha.springecommerce.model.Order;
import com.dilusha.springecommerce.model.Product;
import com.dilusha.springecommerce.model.dto.OderItemResponse;
import com.dilusha.springecommerce.model.dto.OrderItemRequest;
import com.dilusha.springecommerce.model.dto.OrderRequest;
import com.dilusha.springecommerce.model.dto.OrderResponse;
import com.dilusha.springecommerce.repository.OrderRepo;
import com.dilusha.springecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest request) {

        Order order = new Order();
        String orderId = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(request.customerName());
        order.setEmail(request.email());
        order.setStatus("Placed");
        order.setOderDate(LocalDate.now());

        List<OderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemReq : request.items()){

            Product product = productRepo.findById(itemReq.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            product.setStockQuantity(product.getStockQuantity() - itemReq.quantity());
            productRepo.save(product);

            OderItem orderItem = OderItem.builder()
                    .product(product)
                    .quantity(itemReq.quantity())
                    .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemReq.quantity())))
                    .order(order)
                    .build();

            orderItems.add(orderItem);
        }

        order.setOderItems(orderItems);
        Order savedOrder = orderRepo.save(order);

        List<OderItemResponse> itemResponses = new  ArrayList<>();
        for (OderItem item : order.getOderItems()) {
            OderItemResponse oderItemResponse = new OderItemResponse(
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice()
            );
            itemResponses.add(oderItemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
                savedOrder.getOrderId(),
                savedOrder.getCustomerName(),
                savedOrder.getEmail(),
                savedOrder.getStatus(),
                savedOrder.getOderDate(),
                itemResponses
                );

        return orderResponse;
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
