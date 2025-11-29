package com.example.serviceconfiguration.domain

import java.time.DayOfWeek
import java.util.UUID

enum class CycleType {
    WEEKLY,
    BI_MONTHLY,
    MANUAL
}

enum class PaymentWeek {
    THIS_WEEK,
    NEXT_WEEK
}

data class PaymentCycle(
    val paymentCycleId: UUID,
    val deliveryServiceId: UUID,
    val cycleType: CycleType,
    // Weekly
    val cutoffDayOfWeek: DayOfWeek? = null,
    val paymentDayOfWeek: DayOfWeek? = null,
    val paymentWeek: PaymentWeek? = null,
    // Bi-Monthly First Cycle
    val firstCutoffDay: Int? = null,
    val firstPaymentDay: Int? = null,
    val firstPaymentMonthOffset: Int? = null,
    val isFirstDateBusinessDay: Boolean? = null,
    // Bi-Monthly Second Cycle
    val secondCutoffDay: Int? = null,
    val secondPaymentDay: Int? = null,
    val secondPaymentMonthOffset: Int? = null,
    val isSecondDateBusinessDay: Boolean? = null
)
