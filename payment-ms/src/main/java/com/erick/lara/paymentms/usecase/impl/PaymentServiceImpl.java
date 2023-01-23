package com.erick.lara.paymentms.usecase.impl;

import com.erick.lara.paymentms.adapter.controller.dto.request.PaymentDTO;
import com.erick.lara.paymentms.usecase.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void doPayment(PaymentDTO paymentDTO, long payerId, long receiverId) {
        //TODO
    }
}
