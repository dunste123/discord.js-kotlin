package commands

import commands.interfaces.ICommand
import commandsObj
import prefix

class HelpCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {

        val embed = Discord.RichEmbed()

        commandsObj.forEach {
            embed.addField("$prefix${it.key}", it.value.getHelp(), true)
        }

        message.channel.send(embed)
    }

    override fun getName() = "help"

    override fun getHelp() = "Shows a list of the commands"
}