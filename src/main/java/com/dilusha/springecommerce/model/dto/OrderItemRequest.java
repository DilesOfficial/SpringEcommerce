package com.dilusha.springecommerce.model.dto;

public record OrderItemRequest (
        int productId,
        int quantity
) {}
