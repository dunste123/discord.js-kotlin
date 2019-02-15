import kotlin.js.Date
import kotlin.js.Promise

@JsModule("discord.js")
external class Discord {

    companion object {
        val version: String
    }

    class Attachment {
        constructor(file: Any, name: String)
        constructor(file: Any)

        fun getFile(): Any
        fun getName(): String

        fun setAttachment(file: Any, name: String?): Attachment
        fun setFile(file: Any): Attachment
        fun setName(name: String): Attachment
    }

    open class Channel {
        val client: Client
        val createdAt: Date
        val createdTimestamp: Number
        val deleted: Boolean
        val id: String
        val type: String

        fun delete(): Promise<Channel>
    }

    class CategoryChannel : GuildChannel

    class Client {
        val channels: Collection<String, Channel>
        val guilds: Collection<String, Guild>
        val user: ClientUser
        val ping: Number

        fun destroy(): Promise<*>
        fun login(token: String): Promise<String>
        fun on(event: String, cb: (item: dynamic) -> Unit)
    }

    class ClientUser : User {
        fun setPresence(data: dynamic): Promise<ClientUser>
    }

    class Collection<K, V> {
        fun get(key: K): V
        fun filter(func: (item: V) -> Unit): Array<V>
        fun find(func: (item: V) -> Unit): V
    }

    class DMChannel : Channel

    class Guild : UserResolvable {
        val channels: Collection<String, GuildChannel>
    }

    open class GuildChannel : Channel {
        val calculatedPosition: Number
        val deletable: Boolean
        val guild: Guild
        val manageable: Boolean
        val name: String
        val parent: CategoryChannel?
        val parentID: String?
        val permissionOverwrites: Collection<String, PermissionOverwrites>
        val position: Number

        fun fetchInvites(): Promise<Collection<String, Invite>>
    }

    class Invite {
        val channel: Channel
        val code: String
        val guild: Guild
    }

    class Message : UserResolvable {
        val attachments: Collection<String, dynamic>
        val author: User
        val channel: TextChannel
        val cleanContent: String
        val client: Client
        val content: String
        val createdAt: Date
        val createdTimestamp: Number
        val deletable: Boolean
        val deleted: Boolean

        fun edit(content: String): Promise<Message>

        fun edit(embed: RichEmbed): Promise<Message>
        fun edit(content: String, embed: RichEmbed): Promise<Message>

        fun edit(attachment: Attachment): Promise<Message>
        fun edit(content: String, attachment: Attachment): Promise<Message>

        fun edit(options: MessageOptions): Promise<Message>
        fun edit(content: String, options: MessageOptions): Promise<Message>

        fun react(emoji: String): Promise<MessageReaction>
    }

    class MessageOptions {
        var tts: Boolean
        var nonce: String
        var embed: RichEmbed
        var disableEveryone: Boolean
        var reply: UserResolvable
    }

    class MessageReaction {
        val count: Number
        val emoji: dynamic
        val me: Boolean
        val message: Message
        val users: Collection<String, User>
    }

    class PermissionOverwrites {
        var allowed: Permissions
        val channel: GuildChannel
        var denied: Permissions
        var id: String
        var type: String

        fun delete(): Promise<PermissionOverwrites>
        fun delete(reason: String): Promise<PermissionOverwrites>
    }

    class Permissions {
        var bitfield: Number

        fun add(vararg permissions: dynamic): Permissions
        fun freeze(): Permissions
        fun has(permission: dynamic): Boolean
        fun has(permission: dynamic, checkAdmin: Boolean): Boolean
        fun missing(permission: dynamic): dynamic
        fun missing(permission: dynamic, checkAdmin: Boolean): dynamic
        fun remove(vararg permissions: dynamic): Permissions

        // static fields
        companion object {
            val ALL: Number
            val DEFAULT: Number
            val FLAGS: dynamic
        }
    }

    class Presence

    class RichEmbed {
        fun addBlankField(inline: Boolean): RichEmbed
        fun addField(name: String, value: String, inline: Boolean): RichEmbed
        fun setAuthor(name: String, icon: String, url: String): RichEmbed
        fun setColor(color: Int): RichEmbed
        fun setDescription(description: String): RichEmbed
        fun setFooter(text: String, icon: String): RichEmbed
        fun setImage(url: String): RichEmbed
        fun setThumbnail(url: String): RichEmbed
        fun setTimestamp(timestamp: Date): RichEmbed
        fun setTitle(title: String): RichEmbed
        fun setURL(url: String): RichEmbed
    }

    class TextChannel : GuildChannel {
        fun send(content: String): Promise<Message>

        fun send(embed: RichEmbed): Promise<Message>
        fun send(content: String, embed: RichEmbed): Promise<Message>

        fun send(attachment: Attachment): Promise<Message>
        fun send(content: String, attachment: Attachment): Promise<Message>

        fun send(options: MessageOptions): Promise<Message>
        fun send(content: String, options: MessageOptions): Promise<Message>
    }

    open class User : UserResolvable {
        val avatar: String
        val avatarURL: String?
        val bot: Boolean
        val client: Client
        val createdAt: Date
        val createdTimestamp: Number
        val defaultAvatarURL: String
        val discriminator: String
        val displayAvatarURL: String
        val dmChannel: DMChannel
        val id: String
        val lastMessage: Message
        val lastMessageID: String
        val presence: Presence
        val tag: String
        val username: String
    }

    // Things that can be resolved
    interface UserResolvable
}