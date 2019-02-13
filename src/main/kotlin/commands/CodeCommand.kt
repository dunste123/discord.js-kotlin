package commands

import commands.interfaces.ICommand

class CodeCommand : ICommand {
    override fun execute(invoke: String, args: List<String>, message: Discord.Message) {

        message.channel.send("You can view my code here ;) <https://github.com/dunste123/discord.js-kotlin>")

    }

    override fun getName() = "code"
}