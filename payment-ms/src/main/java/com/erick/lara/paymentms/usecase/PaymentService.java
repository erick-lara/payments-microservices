package com.erick.lara.paymentms.usecase;

import com.erick.lara.paymentms.adapter.controller.dto.request.PaymentDTO;

public interface PaymentService {
    void doPayment(PaymentDTO paymentDTO, long payerId, long receiverId);
}
