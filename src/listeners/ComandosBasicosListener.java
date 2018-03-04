package listeners;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import util.ControlVersion;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;
import objetos.Chiste;



public class ComandosBasicosListener extends ListenerAdapter{
	
	public ControlVersion version = new ControlVersion();
	
	ArrayList<Chiste> listaChistes = new ArrayList<Chiste>();
	
	 public void onMessageReceived(MessageReceivedEvent event)
	    {
	        JDA jda = event.getJDA();                       
	        long responseNumber = event.getResponseNumber();


	        Message message = event.getMessage();          
	        MessageChannel channel = event.getChannel();    
	                                                        

	        String msg = message.getContent();              
	        if (event.getChannel().getId().equals("328616003456204800")) {
	        	
	        	 if (msg.equals("!ayuda"))
	 	        {
	 	        	channel.sendMessage("Puedes consultar la lista de comandos usando: !comandos").queue();
	 	        }
	 	        else if (msg.equals("!help"))
	 	        {

	 	            channel.sendMessage("Try in spanish! (!ayuda) :D").queue();
	 	        }
	 	        else if (msg.equals("!comandos"))
	 	        {
	 	        	
	 	            channel.sendMessage("```Markdown\n"
	 	            		+ "#Lista de comandos:\n"
	 	            		+ "!hola: Sirve para saludarme! \n"
	 	            		+ "!historia: Enlace a las historias en el foro. \n"
	 	            		+ "!faccion: Enlace a las facciones en el foro.\n"
	 	            		+ "!normas: Enlace a las normas en el foro.\n"
	 	            		+ "!foro: Enlace al foro.\n"
	 	            		+ "!update: Enlace al log de cambios en el foro.\n"
	 	            		+ "!staff: Enlace a la lista de administradores del servidor.\n"
	 	            		+ "!chiste: Cuenta un chiste.\n"
	 	            		+ "!añadirchiste [Chiste]: Añade un chiste a la lista.\n"
	 	            		+ "!basta @Mencionar: Manda callar a un usuario."
	 	            		+ "```").queue();

	 	        }
	 	        else if (msg.equals("!hola")) {
	 	        	channel.sendMessage("Hola! Soy un BOT de Discord, creado con :hearts: por Zero!").queue();
	 	        }
	 	        else if (msg.equals("!historia")) {
	 	        	channel.sendMessage("Lee, comenta o crea tu historia. http://forum.gta.world/es/index.php?/forum/25-historias-de-personaje/").queue();;
	 	        }
	 	        else if (msg.equals("!faccion")) {
	 	        	channel.sendMessage("Busca o crea la tuya. http://forum.gta.world/es/index.php?/forum/26-facciones/").queue();
	 	        }
	 	        else if (msg.equals("!normas")) {
	 	        	channel.sendMessage("Keep the rules. http://forum.gta.world/es/index.php?/topic/3-normativa-del-servidor/").queue();
	 	        }
	 	        else if (msg.equals("!foro")) {
	 	        	channel.sendMessage("Toma palomitas. http://forum.gta.world/es/").queue();
	 	        }
	 	        else if (msg.equals("!update")) {
	 	        	channel.sendMessage("¿Qué hemos metido hasta ahora? No lo se, solo soy un bot. http://forum.gta.world/es/index.php?/topic/4-log-de-cambios/").queue();
	 	        }
	 	        else if (msg.equals("!staff")) {
	 	        	channel.sendMessage("Te dejo por aquí los dueños del servidor. http://forum.gta.world/es/index.php?/topic/2-staff-de-gtaworld/").queue();
	 	        }
	 	        
	 	        else if (msg.startsWith("!basta")) {
	 	            if (message.isFromType(ChannelType.TEXT))
	 	            {
	 	                if (message.getMentionedUsers().isEmpty())
	 	                {
	 	                    channel.sendMessage("No has mencionado a nadie!").queue();
	 	                }
	 	                else
	 	                {
	 	                    Guild guild = event.getGuild();
	 	                    Member selfMember = guild.getSelfMember();  

	 	                    List<User> mentionedUsers = message.getMentionedUsers();
	 	                    for (User user : mentionedUsers)
	 	                    {
	 	                        Member member = guild.getMember(user);  
	 	                        
	 	                        channel.sendMessage("Callese ya " + member.getEffectiveName() + " que es muy cansino!").queue();

	 	                    }
	 	                }
	 	            }
	 	        }
	 	        else if (msg.equals("!chiste")) {
	 	        	if (listaChistes.isEmpty()) {
	 	        		channel.sendMessage("Lo siento, no se ningún chiste. Quizás podrías enseñarme alguno! Usa !añadirchiste").queue();
	 	        	}
	 	        	else {
	 		        	int numero = (int) (Math.random()*listaChistes.size());
	 		        	channel.sendMessage(listaChistes.get(numero).toString()).queue();
	 	        	}
	 	        }
	 	        else if (msg.startsWith("!añadirchiste")) {
	 	        	if (msg.equals("!añadirchiste")) {
	 	        		channel.sendMessage("Usa !añadirchiste [Chiste]").queue();
	 	        	}
	 	        	else {
	 		        	listaChistes.add(new Chiste(msg.substring(13)));
	 		        	channel.sendMessage("He guardado el chiste: " + msg.substring(13) + ".").queue();
	 	        	}
	 	        	
	 	        }
	 	        else if (msg.equals("!pene"))
	 	        {

	 	            channel.sendMessage(event.getAuthor().getName() + "... -suspira- Que simple eres...").queue();
	 	        }
	        }
	    }
}
