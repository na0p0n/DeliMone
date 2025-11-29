package com.example.serviceconfiguration.domain

import org.springframework.stereotype.Service
import java.time.DayOfWeek
import java.time.LocalDate

interface HolidayService {
    fun isHoliday(date: LocalDate): Boolean
}

@Service
class SimpleHolidayService : HolidayService {

    override fun isHoliday(date: LocalDate): Boolean {
        val dayOfWeek = date.dayOfWeek
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY
    }
}
