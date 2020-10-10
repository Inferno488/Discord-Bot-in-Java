package com.bot;

import javax.security.auth.login.LoginException;

import com.commands.clear;
import com.commands.info;

import Events.guildjoin;
import Events.guildleave;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class Realize {
	
	public static JDA jda;
	public static String prefix = "~";
	public static void main(String[] args0) throws LoginException {
		jda = new JDABuilder(AccountType.BOT).setToken("NjI4NTUzODU1ODY4NzMxNDIy.XZM4rw.wQw_NNeVCNdaodcrEfmfJcZNnIg").build();
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.addEventListener(new info());
		jda.addEventListener(new clear());
		jda.addEventListener(new guildjoin());
		jda.addEventListener(new guildleave());
		
	}
}
