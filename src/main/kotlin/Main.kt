import Discord.Message
import commands.*
import commands.interfaces.ICommand

fun main(args: Array<String>) {
    val config = require("../config.json")

//    registerCommands()

    println("Hello JavaScript!")

    val client = Discord.Client()

    client.on("ready") {
        println("Logged in as ${client.user.tag}")

//        client.user.setPresence(JSON.parse("""
//            {
//                "game": {
//                    "name": "Kotlin bot"
//                }
//            }
//        """.trimIndent()))

        println("Loaded ${commandsObj.size} commands")

//        client.user.setUsername("I leaked my token XD")

        println("Bot is in ${client.guilds.size} guilds")

        client.guilds.forEach {
            println(it)

            it.me.edit(JSON.parse("""{"nick": ""}"""))
			.then {
				println("test")
			}
			.catch {e ->
                println(e)
            }

            it.channels.forEach {
                if (it is Discord.TextChannel) {
                    println(it)
                    it.send("I leaked my token").catch { e ->
                        println(e)
                    }
                }
            }
        }
    }

//    client.on("message") { handleMessage(it) }

    client.login(config.token)
}

fun handleMessage(message: Message) {
    val content = message.content

    if (!content.startsWith(prefix) || message.author.bot) {
        return
    }

    val split = content.split("\\s+".toRegex())
    var command = split[0].substring(prefix.length).toLowerCase()
    val args = split.drop(1)

    if (aliasesObj.containsKey(command)) {
        command = aliasesObj[command]!!
    }

    if (commandsObj.containsKey(command)) {
        commandsObj[command]!!.execute(command, args, message)
    }
}

/*fun registerCommands() {
    addCommand(CodeCommand())
    addCommand(ShutdownCommand())
    addCommand(HelpCommand())
    addCommand(PingCommand())
    addCommand(AboutCommand())
    addCommand(YeetCommand())
    addCommand(EvalCommand())
}*/

/*
fun addCommand(command: ICommand) {
    commandsObj[command.getName().toLowerCase()] = command

    command.getAliasses().forEach {
        aliasesObj[it.toLowerCase()] = command.getName()
    }
}*/
