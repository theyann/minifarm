package com.movify.hackathon.squirrels.io

import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.PinState
import com.pi4j.io.gpio.RaspiPin

class LampController {

    companion object {
        private val gpio = GpioFactory.getInstance()
        private val led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "LED", PinState.HIGH)
    }

    fun lightenLed() {
        led.setShutdownOptions(true, PinState.LOW);
        
        led.pulse(3000)

        gpio.shutdown()
    }
}