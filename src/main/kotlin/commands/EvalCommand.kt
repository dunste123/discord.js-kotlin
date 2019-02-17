package commands

import botAdmins
import commands.interfaces.ICommand

class EvalCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {

        if (!botAdmins.contains(message.author.id)) {
            return
        }

        val channel = message.channel

        if (args.isEmpty()) {
            channel.send("Missing arguments YEET")

            return
        }

        try {
            val code = args.joinToString(" ")
            val evaluated = eval(code)

            channel.send("```$evaluated```")

        }
        catch (e: Error) {
            channel.send("Whoopsie something broke: $e")
        }

    }

    override fun getName() = "eval"

    override fun getHelp() = "Evaluates code that you yeet at it"
}