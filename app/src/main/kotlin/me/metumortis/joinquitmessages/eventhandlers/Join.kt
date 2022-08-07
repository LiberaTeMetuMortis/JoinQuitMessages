package me.metumortis.joinquitmessages.eventhandlers

import me.clip.placeholderapi.PlaceholderAPI
import me.metumortis.joinquitmessages.JoinQuitMessages.Companion.translateColors
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class Join(val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent){
        val player = e.player
        for(key in plugin.config.getKeys(true).filter { it.matches(Regex("^joinMessages\\..+")) }) {
            if(player.hasPermission("joinQuitMessages.joinDisabled")) break;
            if(player.hasPermission("joinQuitMessages.$key")){
                Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(player, plugin.config.getString(key)!!).let(::translateColors))
                break;
            }
        }
    }
}