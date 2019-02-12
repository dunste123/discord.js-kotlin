external fun require(module: String): dynamic

fun main(args: Array<String>) {
    val config = require("../config.json")

    println("Hello JavaScript!")

    val client: dynamic = Discord.Client()

    client.on("ready") {
        println("Logged in as ${client.user.tag}")

        val embed: dynamic = Discord.RichEmbed()

        embed.setDescription("Hello from kotlin")

       /* client.channels.get("513113435727331329").send(
                content = "YEET",
                embed = embed
        )*/

        println("Embed send")
    }

    client.on("message") { message -> handleMessage(message) }

    client.login(config.token)
}

fun handleMessage(message: dynamic) {
    println("${message.author.tag}: ${message.content}")
}