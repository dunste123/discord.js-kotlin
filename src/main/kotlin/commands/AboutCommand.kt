package commands

import commands.interfaces.ICommand

class AboutCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {

        val embed = Discord.RichEmbed()
                .addField("Creator", "duncte123#1245", false)
                .addField("Language and library info", """
                    |**Kotlin version:** ${KotlinVersion.CURRENT}
                    |**Discord.js version:** ${Discord.version}
                    |
                    |**Source:** [GitHub](https://github.com/dunste123/discord.js-kotlin)
                """.trimMargin(), false)

        message.channel.send(embed)
    }

    override fun getName() = "info"

    override fun getHelp() = "Shows some info about the bot"
}