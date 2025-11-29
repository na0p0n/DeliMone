package com.example.serviceconfiguration.domain

import java.util.UUID

data class DeliveryService(
    val serviceId: UUID,
    val serviceName: String,
    val isPreset: Boolean,
    val memo: String?
)
