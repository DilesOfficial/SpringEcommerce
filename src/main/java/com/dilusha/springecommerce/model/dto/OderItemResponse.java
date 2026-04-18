package com.dilusha.springecommerce.model.dto;

import java.math.BigDecimal;

public record OderItemResponse(
        String productName,
        int quantity,
        BigDecimal totalPrice
) {
}
