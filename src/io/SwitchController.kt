package com.movify.hackathon.squirrels.io

import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.PinState
import com.pi4j.io.gpio.RaspiPin

enum class Relay { ONE, TWO }

class SwitchController {

    private val gpio = GpioFactory.getInstance()
    private val pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Relay 1", PinState.HIGH)
    private val pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Relay 2", PinState.HIGH)

    fun high(relay: Relay) {
        relayToPin(relay).high()
    }

    fun low(relay: Relay) {
        relayToPin(relay).low()
    }

    private fun relayToPin(relay: Relay) = if (relay == Relay.ONE) pin1 else pin2
}