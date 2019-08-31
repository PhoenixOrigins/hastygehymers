package com.phoenixorigins.hastygehymers;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class HastygehymersCmd implements CommandExecutor
{
	private Hastygehymers plugin;

	public HastygehymersCmd(Hastygehymers plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String... args)
	{
		if (sender.hasPermission("hastygehymers.toggle"))
		{
			if (plugin.isEnabled)
			{
				plugin.isEnabled = false;
				plugin.amplifier = 1;
				for (Player p : plugin.getServer().getOnlinePlayers())
				{
					p.removePotionEffect(PotionEffectType.FAST_DIGGING); // remove all Haste
				}
				sender.sendMessage("Haste is no longer being distributed.");
				String broadcast = ChatColor.translateAlternateColorCodes('&', "&3The dev session has ended.&f Haste removed.");
				plugin.getServer().broadcastMessage(broadcast);
			}
			else
			{
				boolean hasteApplied = false;
				if (args.length > 0)
				{
					if (isInt(args[0]))
					{
						plugin.isEnabled = true;
						plugin.amplifier = Integer.parseInt(args[0]);
						sender.sendMessage("Haste will now be distributed with an amplifier of " + plugin.amplifier + " (Haste " + (plugin.amplifier + 1) + ")");
						hasteApplied = true;
					}
					else
					{
						sender.sendMessage("Invalid argument. Haste amplifier must be an Integer!");
					}
				}
				else
				{
					plugin.isEnabled = true;
					plugin.amplifier = 9; // 9 by default
					sender.sendMessage("Haste will now be distributed with an amplifier of 9 (Haste 10)");
					hasteApplied = true;
				}

				if (hasteApplied)
				{
					String broadcast = ChatColor.translateAlternateColorCodes('&', "&3A dev session has started! &fAll players will be granted &6Haste " + (plugin.amplifier + 1) + " &funtil it ends!");
					plugin.getServer().broadcastMessage(broadcast);
				}
			}
		}
		else
		{
			sender.sendMessage("You do not have permission to use this command!");
		}

		return true;
	}

	private boolean isInt(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}