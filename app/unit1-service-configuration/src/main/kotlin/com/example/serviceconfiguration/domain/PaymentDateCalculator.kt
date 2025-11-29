package com.example.serviceconfiguration.domain

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

@Service
class PaymentDateCalculator(private val holidayService: HolidayService) {

    fun calculateNextPaymentDate(cutoffDate: LocalDate, paymentCycle: PaymentCycle): LocalDate {
        val basePaymentDate = when (paymentCycle.cycleType) {
            CycleType.WEEKLY -> calculateForWeekly(cutoffDate, paymentCycle)
            CycleType.BI_MONTHLY -> calculateForBiMonthly(cutoffDate, paymentCycle)
            CycleType.MANUAL -> throw IllegalArgumentException("Manual cycle type is not supported for calculation.")
        }

        return adjustForHoliday(basePaymentDate)
    }

    private fun calculateForWeekly(cutoffDate: LocalDate, paymentCycle: PaymentCycle): LocalDate {
        val paymentDay = paymentCycle.paymentDayOfWeek
            ?: throw IllegalArgumentException("paymentDayOfWeek is required for WEEKLY cycle.")
        val paymentWeek = paymentCycle.paymentWeek
            ?: throw IllegalArgumentException("paymentWeek is required for WEEKLY cycle.")

        var paymentDate = cutoffDate.with(paymentDay)
        if (paymentWeek == PaymentWeek.NEXT_WEEK) {
            paymentDate = paymentDate.plusWeeks(1)
        }
        return paymentDate
    }

    private fun calculateForBiMonthly(cutoffDate: LocalDate, paymentCycle: PaymentCycle): LocalDate {
        val dayOfMonth = cutoffDate.dayOfMonth

        val (cutoffDay, paymentDay, monthOffset) = if (dayOfMonth <= paymentCycle.firstCutoffDay!!) {
            Triple(paymentCycle.firstCutoffDay, paymentCycle.firstPaymentDay!!, paymentCycle.firstPaymentMonthOffset!!)
        } else {
            Triple(paymentCycle.secondCutoffDay!!, paymentCycle.secondPaymentDay!!, paymentCycle.secondPaymentMonthOffset!!)
        }

        val paymentMonth = cutoffDate.plusMonths(monthOffset.toLong())

        val dayToSet = if (paymentDay == 99) {
            paymentMonth.with(TemporalAdjusters.lastDayOfMonth()).dayOfMonth
        } else {
            paymentDay
        }
        
        return paymentMonth.withDayOfMonth(dayToSet)
    }

    private fun adjustForHoliday(date: LocalDate): LocalDate {
        var adjustedDate = date
        while (holidayService.isHoliday(adjustedDate)) {
            adjustedDate = adjustedDate.plusDays(1)
        }
        return adjustedDate
    }
}
