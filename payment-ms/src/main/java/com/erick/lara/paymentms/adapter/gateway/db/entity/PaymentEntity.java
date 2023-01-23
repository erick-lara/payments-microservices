package com.erick.lara.paymentms.adapter.gateway.db.entity;

import br.com.erick.lara.payments.domain.payment.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long idPayment;
    private BigDecimal paymentValue;
    private LocalDateTime paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;
    private long idPayer;

}
