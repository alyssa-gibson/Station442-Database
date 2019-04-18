// --STATION 442 Database Bot--
// Developer: Maka#8137
// Main.java
// ---------------------------
// Methods:
// main(String[] args): main method.

import java.util.ArrayList;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.Message;

public class Main {

	public static void main(String[] args) {
		// Production Token:
		String pro_token = "PROTOKEN";
		// Test Token:
		String test_token = "TESTTOKEN";

		DiscordApi api = new DiscordApiBuilder().setToken
				(pro_token).
				login().join();
		// Connect to Discord with my bot's secret key.
		
		// The following is done on init:
		CommandHandler ch = new CommandHandler();
		// CommandHandler is a class of... switch statements to parse args.
		// Not pretty, but easier than doing it in main.
		
        System.out.println("Logged in!");
        // It's always good to know when a login goes right.
        // Slower hardware can take 15-30 seconds to log in.
        // end init
        
        // Listener event:
        // If I recall correctly, having 1 listener event is
        // more efficient for slower hardware (Raspberry Pi Zero W)
        api.addMessageCreateListener(event -> {
            Message message = event.getMessage();
            // Retrieve message from Discord
            if (message.getContent().startsWith("++")) {
            	// If the message does NOT start with ++, then
            	// the user did not intend do call the bot-- ignore it.
            	ArrayList<String> ret = new ArrayList<String>();
            	// Discord's messages are limited to 2000 characters,
            	// and sometimes we want to return more than that.
            	// I used ArrayList because it's easier than determining
            	// how long each message can be.
            	// Also, all CommandHandler commands return an ArrayList.
            	
            	String arguments = message.getContent().substring(2);
            	// Split the message for everything after the ++,
            	// by this point the bot no longer needs that.
            	
            	String[] split_args = arguments.split("\\s+");
            	// THEN, substring by spaces and put into an array
            	// to parse individual commands.
            	// Because Discord is like a command line, you
            	// have to put in all args at once upon calling.
            	
            	ch.newCommand(message, split_args);
            	// send the message and split_args to the CommandHandler class.
            	ret = ch.parse();
            	// figure out which of the first args the user puts in, return
            	// an error if none found.
            	
            	for (int i = 0; i < ret.size(); i++) {
            		// Send each 1800 character (I limited to 1800 for formatting reasons)
            		// string in succession. MOST messages are only 1, but this works
            		// for that too, being a for loop.
            		event.getChannel().sendMessage(ret.get(i));
            	}
            }
        });
	}
	
}
