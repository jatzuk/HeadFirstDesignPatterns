package chapter6

import java.lang.StringBuilder

/* 
 * Created with passion and love
 *    for project HeadFirstDesignPatterns
 *        by Jatzuk on 18.06.2019
 *                                            *_____*
 *                                           *_*****_*
 *                                          *_(O)_(O)_*
 *                                         **____V____**
 *                                         **_________**
 *                                         **_________**
 *                                          *_________*
 *                                           ***___***
 */

interface Command {
    fun execute()

    companion object {
        inline operator fun invoke(crossinline func: () -> Unit) = object : Command {
            override fun execute() = func()
        }
    }
}

class Light {
    fun on() {
        println("Light is On")
    }

    fun off() {
        println("Light is Off")
    }
}

class GarageDoor {
    fun up() {
        println("Garage Door is Open")
    }

    fun down() {
        println("Garage Door is Closed")
    }

    fun stop() {
        println("Garage Door is Stopped")
    }

    fun lightOn() {
        println("Garage light is On")
    }

    fun lightOff() {
        println("Garage light is Off")
    }
}

class CeilingFan {
    var speed = SPEED.OFF
        private set(value) {
            previousSpeed = field
            field = value
        }

    var previousSpeed = SPEED.OFF
        private set

    fun on() {
        speed = SPEED.LOW
        println("CeilingFan is On\tspeed: $speed\tprev speed:$previousSpeed")
    }

    fun high() {
        speed = SPEED.HIGH
    }

    fun medium() {
        speed = SPEED.MEDIUM
    }

    fun off() {
        speed = SPEED.OFF
        println("CeilingFan is Off\tspeed: $speed\tprev speed:$previousSpeed")
    }

    enum class SPEED { HIGH, MEDIUM, LOW, OFF }
}

class SimpleRemoteControl {
    lateinit var command: Command

    fun buttonWasPressed() {
        command.execute()
    }
}

class RemoteControl {
    val onCommands = arrayOfNulls<Command>(7)
    val offCommands = arrayOfNulls<Command>(7)

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot]?.execute()
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot]?.execute()
    }

    override fun toString(): String {
        val sb = StringBuilder("\n---------- Remote Control ----------\n")
        repeat(onCommands.size) {
            sb.append(
                "[slot $it] ${onCommands[it]?.javaClass?.simpleName} " +
                        "${offCommands[it]?.javaClass?.simpleName}\n"
            )
        }
        return sb.toString()
    }
}
