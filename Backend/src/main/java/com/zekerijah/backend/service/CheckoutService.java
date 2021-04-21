package com.zekerijah.backend.service;

import com.zekerijah.backend.dto.Purchase;
import com.zekerijah.backend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
