package com.zekerijah.backend.service;

import com.zekerijah.backend.dao.CustomerRepository;
import com.zekerijah.backend.dto.Purchase;
import com.zekerijah.backend.dto.PurchaseResponse;
import com.zekerijah.backend.entity.Customer;
import com.zekerijah.backend.entity.Order;
import com.zekerijah.backend.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTruckingNum = generateOrderTrackingNum();
        order.setOrderTrackingNumber(orderTruckingNum);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTruckingNum);
    }

    private String generateOrderTrackingNum() {

        return UUID.randomUUID().toString();
    }
}
