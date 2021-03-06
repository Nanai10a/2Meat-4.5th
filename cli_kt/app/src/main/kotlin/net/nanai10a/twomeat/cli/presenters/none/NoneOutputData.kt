package net.nanai10a.twomeat.cli.presenters.none

import net.nanai10a.twomeat.cli.presenters.DiscordMessage
import net.nanai10a.twomeat.cli.usecases.SessionData

data class NoneOutputData(val sessionData: SessionData, val message: DiscordMessage)
