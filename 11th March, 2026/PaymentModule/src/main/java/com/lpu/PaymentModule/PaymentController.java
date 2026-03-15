package com.lpu.PaymentModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/add")
    public PaymentEntity addPayment(@RequestBody PaymentEntity payment) {
        return service.savePayment(payment);
    }

    @GetMapping("/all")
    public List<PaymentEntity> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentEntity getPayment(@PathVariable int id) {
        return service.getPaymentById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable int id) {
        service.deletePayment(id);
        return "Payment deleted successfully";
    }
}