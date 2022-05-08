package me.metumortis.deneme.eventhandlers

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class damage : Listener{

    //@EventHandler
    //fun hasarEventi(event: EntityDamageByEntityEvent){
    //    event.damage = 20.0
                //    println("Selam")
                //}

    @EventHandler
    fun deathEvent(event: EntityDamageByEntityEvent){

        var damager = event.damager
        if(damager is Player){
            damager.addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000, 5))
        }
        println(event.finalDamage)
        println(event.entity.lastDamageCause)
        var player = event.entity
        if(player is Player){
            println(player.health)
        }
    }
}