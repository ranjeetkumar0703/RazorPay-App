package com.razor_payment.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentCheckOut {

    // http://localhost:8080/pay
    @GetMapping("/payment")
    public String showPaymentPage() {
        return "Payment-request"; // Thymeleaf template name without the extension
    }
}
