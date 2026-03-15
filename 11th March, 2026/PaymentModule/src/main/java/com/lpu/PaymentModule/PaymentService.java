package com.lpu.PaymentModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public PaymentEntity savePayment(PaymentEntity payment) {
        return repository.save(payment);
    }

    public List<PaymentEntity> getAllPayments() {
        return repository.findAll();
    }

    public PaymentEntity getPaymentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deletePayment(int id) {
        repository.deleteById(id);
    }
}