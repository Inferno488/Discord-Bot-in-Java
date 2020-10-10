package com.commands;

import java.util.List;

import com.bot.Realize;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class clear extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if(args[0].equalsIgnoreCase(Realize.prefix + "clear")) {
			if(args.length < 2) {
				//error
				EmbedBuilder usage = new EmbedBuilder();
				usage.setTitle("Specify amount to clear");
				usage.setDescription("Usage "+Realize.prefix+"clear [# of messages]");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			
			else {
				try {
				List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
				event.getChannel().deleteMessages(messages).queue();
				EmbedBuilder usage = new EmbedBuilder();
				usage.setTitle("Successfully deleted");
				usage.setDescription(""+args[1]+" deleted");
				event.getChannel().sendMessage(usage.build()).queue();
				}
				catch(IllegalArgumentException e) {
					if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xffffff);
						error.setTitle("Error: Too many messages selected");
						error.setDescription("Only 1-100 messages can be cleared.");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xffffff);
						error.setTitle("Error: Too old of a message");
						error.setDescription("Only 2 weeks old allowed");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
				
			}
		}
	}

}
