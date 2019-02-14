package commands

import commands.interfaces.ICommand
import kotlin.js.Date

class PingCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {

        val start = Date.now()

        message.channel.send("Pinging....").then {

            it.edit("""PONG!!!
                |Took: ${Date.now() - start}ms
                |WS Ping: ${it.client.ping}ms
            """.trimMargin())

        }

    }

    override fun getName() = "ping"

    override fun getHelp() = "Calculates a roundtrip to the discord api"
}