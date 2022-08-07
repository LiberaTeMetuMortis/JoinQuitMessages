package me.metumortis.joinquitmessages

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class ReloadHandler(val plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.isEmpty()){
            sender.sendMessage("Usage of this command is /jqm reload")
            return true;
        }
        if(args[0].equals("reload", true)){
            if(!sender.hasPermission("joinquitmessages.reload")){
                sender.sendMessage("You do not have permission to use this command")
                return true;
            }
            plugin.saveDefaultConfig()
            plugin.reloadConfig()
            sender.sendMessage("Reloaded config")
            return true;
        }
        return true;
    }

}