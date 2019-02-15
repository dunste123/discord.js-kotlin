package commands

import commands.interfaces.ICommand

class YeetCommand : ICommand {

    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {

        val embed = Discord.RichEmbed()

        embed.setDescription("Hello from kotlin")

        message.channel.send(
                content = "YEET!! <@${message.author.id}>",
                embed = embed
        )

    }

    override fun getName() = "yeet"

    override fun getHelp() = "YEET!!"
}