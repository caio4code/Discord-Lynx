package commands.moderation;

import commands.Command;
import handlers.MessageHandler;
import handlers.ServerHandler;
import init.InitData;
import init.Launcher;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.HierarchyException;
import net.dv8tion.jda.core.managers.GuildController;

public class Kick extends Command {

	@Override
	public boolean action(MessageChannel chn, String msg, Object misc) {
		
		Guild gld = ((MessageReceivedEvent) misc).getGuild();
		User mod = ((MessageReceivedEvent) misc).getAuthor(), punished = (msg.length() == getName().length()) ? null : gld.getMemberById(msg.substring(msg.indexOf("@") + 1, msg.indexOf(">"))).getUser();
		
		if(punished == null) {
			MessageHandler.sendMessage(chn, getDesc());
			return true;
		}
		
		boolean result = verifyExecution(mod, punished, gld, chn);
		
		if(result) {
			
		}
		
		return false;
		
	}

}
