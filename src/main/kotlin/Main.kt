import Discord.TextChannel
import Discord.RichEmbed
import Discord.Message

external fun require(module: String): dynamic

fun main(args: Array<String>) {
    val config = require("../config.json")

    println("Hello JavaScript!")

    val client = Discord.Client()

    client.on("ready") {
        println("Logged in as ${client.user.tag}")

        val embed = RichEmbed()

        embed.setDescription("Hello from kotlin")

        val channel = client.guilds.get("416512197590777857").channels.get("513113435727331329") as TextChannel

        channel.send(
                content = "YEET",
                embed = embed
        ).then {
            println("Embed send")
        }
    }

    client.on("message") { handleMessage(it) }

    client.login(config.token)
}

fun handleMessage(message: Message) {
    println("${message.author.tag}: ${message.content}")
}