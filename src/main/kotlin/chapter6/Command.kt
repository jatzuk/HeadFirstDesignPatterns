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
}

class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.on()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.off()
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

class GarageDoorUpCommand(private val garageDoor: GarageDoor) : Command {
    override fun execute() {
        garageDoor.up()
    }
}

class SimpleRemoteControl {
    lateinit var command: Command

    fun buttonWasPressed() {
        command.execute()
    }
}

class NoCommand : Command {
    override fun execute() {

    }
}

class RemoteControl {
    val onCommands = Array<Command>(7) { NoCommand() }
    val offCommands = Array<Command>(7) { NoCommand() }

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot].execute()
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot].execute()
    }

    override fun toString(): String {
        val sb = StringBuilder("\n---------- Remote Control ----------\n")
        repeat(onCommands.size) {
            sb.append("[slot $it] ${onCommands[it].javaClass.simpleName} " +
                    "${offCommands[it].javaClass.simpleName}\n")
        }
        return sb.toString()
    }
}
