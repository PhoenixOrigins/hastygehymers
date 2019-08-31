package com.phoenixorigins.hastygehymers;

import org.bukkit.plugin.java.JavaPlugin;

public class Hastygehymers extends JavaPlugin
{
	private HastyLoop task;
	public boolean isEnabled;
	public int amplifier;

	public Hastygehymers()
	{
		isEnabled = false;
		amplifier = 1;
		task = new HastyLoop(this);
	}

	@Override
	public void onEnable()
	{
		getCommand("hastygehymers").setExecutor(new HastygehymersCmd(this));
		getServer().getPluginManager().registerEvents(new HastyQuitListener(this), this);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 110L);
	}
}