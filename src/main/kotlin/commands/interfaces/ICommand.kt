package commands.interfaces

interface ICommand {

    fun execute(invoke: String, args: List<String>, message: Discord.Message)
    fun getName(): String
    fun getHelp(): String

}