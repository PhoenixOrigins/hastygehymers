package com.phoenixorigins.hastygehymers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

public class HastyQuitListener implements Listener
{
	private Hastygehymers plugin;

	public HastyQuitListener(Hastygehymers plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		if (p.hasPotionEffect(PotionEffectType.FAST_DIGGING))
		{
			p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		}
	}
}
