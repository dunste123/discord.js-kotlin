package commands

import botAdmins
import commands.interfaces.ICommand

class ShutdownCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {
        if (botAdmins.contains(message.author.id)) {

            message.react("✅").then {
                message.client.destroy()
            }
        }
    }

    override fun getName() = "shutdown"

    override fun getHelp() = "Shuts the bot down :)"
}