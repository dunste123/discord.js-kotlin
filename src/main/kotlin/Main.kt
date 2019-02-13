import Discord.Message
import commands.CodeCommand
import commands.ShutdownCommand
import commands.interfaces.ICommand

fun main(args: Array<String>) {
    val config = require("../config.json")

    registerCommands()

    println("Hello JavaScript!")

    val client = Discord.Client()

    client.on("ready") {
        println("Logged in as ${client.user.tag}")

        client.user.setPresence(JSON.parse("""
            {
                "game": {
                    "name": "Kotlin bot"
                }
            }
        """.trimIndent()))

        /*val embed = RichEmbed()

        embed.setDescription("Hello from kotlin")

        val channel = client.guilds.get("416512197590777857").channels.get("513113435727331329") as TextChannel

        channel.send(
                content = "YEET",
                embed = embed
        ).then {
            println("Embed send")
        }*/

        println("Loaded ${commandsObj.size} commands")
    }

    client.on("message") { handleMessage(it) }

    client.login(config.token)
}

fun handleMessage(message: Message) {
    val content = message.content.toLowerCase()

    if (!content.startsWith("j!")) {
        return
    }

    val split = content.split("\\s+".toRegex())
    val command = split[0].replaceFirst("j!", "")
    val args = split.drop(1)

    if (commandsObj.containsKey(command)) {
        commandsObj[command]!!.execute(command, args, message)
    }
}

fun registerCommands() {
    addCommand(CodeCommand())
    addCommand(ShutdownCommand())
}

fun addCommand(command: ICommand) {
    commandsObj[command.getName()] = command
}