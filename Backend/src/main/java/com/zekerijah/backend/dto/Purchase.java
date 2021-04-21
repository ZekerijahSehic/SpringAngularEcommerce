package com.zekerijah.backend.dto;

import com.zekerijah.backend.entity.Address;
import com.zekerijah.backend.entity.Customer;
import com.zekerijah.backend.entity.Order;
import com.zekerijah.backend.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;
    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;

}
