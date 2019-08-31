package com.phoenixorigins.hastygehymers;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HastyLoop implements Runnable
{
	private Hastygehymers plugin;

	public HastyLoop(Hastygehymers plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void run()
	{
		if (plugin.isEnabled)
		{
			for (Player p : plugin.getServer().getOnlinePlayers())
			{
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, plugin.amplifier));
			}
		}
	}
}