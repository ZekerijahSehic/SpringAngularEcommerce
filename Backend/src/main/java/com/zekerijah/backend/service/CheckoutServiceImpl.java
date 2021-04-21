package com.zekerijah.backend.service;

import com.zekerijah.backend.dao.CustomerRepository;
import com.zekerijah.backend.dto.Purchase;
import com.zekerijah.backend.dto.PurchaseResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        return null;
    }
}
