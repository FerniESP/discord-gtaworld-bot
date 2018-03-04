package listeners;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildEventListeners extends ListenerAdapter {
	
	
	
	
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		event.getGuild().getTextChannelById("328616003456204800")
		.sendMessage("Hola " + event.getMember().getEffectiveName()
				+ ". Bienvenido a la comunidad de GTA World.\n"
				+ "Te dejo por aqui la pagina web http://gta.world/index.php?lang=es \n"
				+ "Te dejo por aquí el foro http://forum.gta.world/es/ \n"
				+ "Toma asiento y disfruta."  ).queue();;
		
		
		

	}
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
    	event.getGuild().getTextChannelById("328616003456204800").sendMessage("Se nos ha ido " + event.getMember().getEffectiveName() 
    			+ " que pena… me voy al rincon de llorar :cry: .").queue();;
    }
}
