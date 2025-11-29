package com.example.serviceconfiguration.domain

import org.springframework.stereotype.Repository
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

interface DeliveryServiceRepository {
    fun findAll(): List<DeliveryService>
    fun findById(serviceId: UUID): DeliveryService?
    fun save(deliveryService: DeliveryService): DeliveryService
    fun delete(serviceId: UUID)
}

@Repository
class InMemoryDeliveryServiceRepository : DeliveryServiceRepository {

    private val services: MutableMap<UUID, DeliveryService> = ConcurrentHashMap()

    init {
        // Preset data
        listOf(
            "UberEats",
            "出前館",
            "Wolt",
            "RocketNow",
            "Amazon Flex",
            "menu",
            "ピックゴー"
        ).forEach { serviceName ->
            val serviceId = UUID.randomUUID()
            services[serviceId] = DeliveryService(
                serviceId = serviceId,
                serviceName = serviceName,
                isPreset = true,
                memo = null
            )
        }
    }

    override fun findAll(): List<DeliveryService> {
        return services.values.toList()
    }

    override fun findById(serviceId: UUID): DeliveryService? {
        return services[serviceId]
    }

    override fun save(deliveryService: DeliveryService): DeliveryService {
        services[deliveryService.serviceId] = deliveryService
        return deliveryService
    }

    override fun delete(serviceId: UUID) {
        services.remove(serviceId)
    }
}
