package com.example.warehouse.modelLayer;

import java.time.LocalDateTime;

public record Bill(int orderId, String customerName, double amount, LocalDateTime timestamp) {
}
