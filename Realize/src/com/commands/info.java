package com.commands;

import com.bot.Realize;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class info extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Realize.prefix + "info")) {
			
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Realize bot Info");
			info.addField("Creator","Inferno",false);
			info.setDescription("Hello i'm a reality bot");
			info.setColor(0xffffff);
			info.setFooter("Created by us all",event.getMember().getUser().getAvatarUrl());
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
		
	}
	
}
