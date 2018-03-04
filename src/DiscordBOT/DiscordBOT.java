package DiscordBOT;

import javax.security.auth.login.LoginException;

import listeners.ComandosBasicosListener;
import listeners.GuildEventListeners;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Reloj;

public class DiscordBOT {
	final static String botToken = "MzI5Njk4MTgyNDI4NjIyODQ4.DDWO3w.fKZHAisfWfFGtc31jRj07CTPc3c"; //Token del BOT.

	public void iniciarBOT () {
		System.out.println(new Reloj().getHora() + " [INFO]: Iniciando BOT.");
	    try {
			JDA jda = new JDABuilder(AccountType.BOT)
			        .setToken(botToken).setGame(Game.of("Escribe !ayuda"))          	
			        .addEventListener(new ComandosBasicosListener(), new GuildEventListeners())  	
			        .buildBlocking();
			
			System.out.println(new Reloj().getHora() + " [INFO]: BOT Iniciado.");
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			System.out.println(new Reloj().getHora() + " [INFO]: Error en la ejecución del BOT");
			e.printStackTrace();
		}
	}
}
