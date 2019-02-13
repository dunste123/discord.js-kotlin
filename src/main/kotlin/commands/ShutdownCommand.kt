package commands

import commands.interfaces.ICommand
import process

class ShutdownCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {
        if (Constatnts.botAdmins.contains(message.author.id)) {
            process.exit(0)
        }
    }

    override fun getName() = "shutdown"
}