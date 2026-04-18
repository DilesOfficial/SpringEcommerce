package com.dilusha.springecommerce.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
        String orderId,
        String customerName,
        String email,
        String status,
        LocalDate oderDate,
       List<OderItemResponse> items
) {
}
