package com.example.serviceconfiguration.domain

import org.springframework.stereotype.Repository
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

interface PaymentCycleRepository {
    fun findByDeliveryServiceId(deliveryServiceId: UUID): PaymentCycle?
    fun save(paymentCycle: PaymentCycle): PaymentCycle
}

@Repository
class InMemoryPaymentCycleRepository : PaymentCycleRepository {

    private val cycles: MutableMap<UUID, PaymentCycle> = ConcurrentHashMap()

    override fun findByDeliveryServiceId(deliveryServiceId: UUID): PaymentCycle? {
        return cycles.values.find { it.deliveryServiceId == deliveryServiceId }
    }

    override fun save(paymentCycle: PaymentCycle): PaymentCycle {
        cycles[paymentCycle.paymentCycleId] = paymentCycle
        return paymentCycle
    }
}
