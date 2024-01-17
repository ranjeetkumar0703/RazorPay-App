package com.razor_payment.controller;

import com.razor_payment.payload_Dto.OrderRequest;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

//http://localhost:8080/api/create-order
    @PostMapping("/create-order")
    public String  createOrder(@RequestBody OrderRequest order) throws Exception {


        RazorpayClient razorpay = new RazorpayClient("rzp_test_HFg0Io6r1ISq8D", "gq6LeU6kKPWVx0X2hm8xsuPA");

        JSONObject orderRequest;
        orderRequest = new JSONObject();
        orderRequest.put("amount", order.getAmount() * 100);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "receipt#2");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        orderRequest.put("notes", notes);

        Order orderResponse = razorpay.orders.create(orderRequest);
      return orderResponse.get("id").toString();


    }
}