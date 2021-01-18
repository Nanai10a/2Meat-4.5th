package net.nanai10a.twomeat.cli

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.nanai10a.twomeat.cli.controllers.UserController
import net.nanai10a.twomeat.cli.inits.productionDI
import net.nanai10a.twomeat.cli.presenters.DiscordUserGetEventTransmissioner
import net.nanai10a.twomeat.cli.presenters.DiscordUserSaveEventTransmissioner
import net.nanai10a.twomeat.cli.utils.Env
import net.nanai10a.twomeat.cli.utils.ServiceProvider

fun main() {
    val env = Env()

    val userGetTransmissioner = DiscordUserGetEventTransmissioner()
    val userSaveTransmissioner = DiscordUserSaveEventTransmissioner()

    val jda = JDABuilder.createLight(env.discordToken).build()
    jda.awaitReady()

    val service = ServiceProvider(env).productionDI(jda, userSaveTransmissioner, userGetTransmissioner)

    val controller = service.create(UserController::class.java)

    val controller = service.create(UserController::class.java) as UserController


}
