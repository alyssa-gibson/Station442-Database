// --STATION 442 Database Bot--
// Developer: Maka#8137
// CommandHandler.java
// ---------------------------
// Methods:
// CommandHandler(): constructor
// newCommand(Message msg, String[] in): recieves orignal message
//										 data and split input
// parse(): checks the first arg and sends it to the correct
//			method, then returns whatever said method does.
// meow(): a cuter version of ping, pong!
// help(): returns a standard help message, depending if user
//		   sending the request is an admin or not (admins have
//		   more options, obviously)
// database(): the true meat of the code, everything that has to
// 			   do with the database is located here.
// cutter(String s): Discord's message limit is 2000 characters,
//					 this method chops a string intended for
//				 	 return into 1800 character chunks.

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;

public class CommandHandler {
	
	// all these variables....
	// it makes for cleaner code....
	List<User> mentioned;
	Optional<User> user;
	MessageAuthor msgauthor;
	String[] input;
	List<MessageAttachment> attachments;
	LinkedList chars;
	ArrayList<String> ret;
	
	public CommandHandler() {
		chars = new LinkedList();
	}
	
	public void newCommand(Message msg, String[] in) {
		attachments = msg.getAttachments();
		ret = new ArrayList<String>();
		msgauthor = msg.getAuthor();
		input = in;
		mentioned = msg.getMentionedUsers(); 
		user = msg.getUserAuthor();
		
	}
	
	public ArrayList<String> parse() {
		switch (input[0]) {
			case "meow": {
				return cutter(meow());
			}
			
			case "database": {
				return cutter(database());
			}
			
			case "help": {
				return cutter(help());
			}
			
			case "changes": {
				return cutter(changes());
			}
			
			default: 
				return cutter("error in CommandHandler.parse()");
		}
	}

	public String meow() {
		return "```objectivec\n#import <442/cat.h>\n\n@protocol Station_442\n"
				+ ">>\n         __..--''``---....___   _..._    __\r\n" + 
				"     _.-'    .-/\";  `        ``<._  ``.''_ `.\r\n" + 
				" _.-' _..--.'_    \\                    `( ) )\r\n" + 
				"(_..-'    (< _     ;_..__               ; `'\r\n" + 
				"           `-._,_)'      ``--...____..-'\r\n" + 
				"```";
	}
	
	public String changes() {
		return "```md\n#import <442/changes.h>\n@protocol Station_442\n" +
				"\n**Build: 2019.03.19**\n**Changes:**\n- Added 'equipment' as a viable argument"
				+ " for the set and update methods.\n- Added a 'attr' argument to the view method"
				+ " for viewing a specific character attribute.\n- Removed old arguments and fixed a typo from the help menu.\n```";
	}
	
	public String help() {
		
		if (msgauthor.isServerAdmin()) {
			return "```md\n#import <442/help-admin.h>\n\n@protocol Station_442"
					+ "\n\ncall:\n==============="
					+ "\n++(database < add, view [owned-by, bio, full-bio, attr], set, update >\n    help \n    cat)\n"
					+ "\nadd\n===============\n(mentioned user) (UTF-8 encoded semicolon delimited txt file)"
					+ "\n[Adds a character to the database and assigns it to the mentioned user.]"
					+ "\n\nview\n===============\n\n\t> owned-by\n===============\n(mentioned user)\n[Views all characters owned by the mentioned user.]"
					+ "\n\n\t> bio\n===============\n(mentioned user) (character name)\n[Views a short summary of the character.]\n"
					+ "\n\t> full-bio\n===============\n(mentioned user) (character name)\n[Views a full biography of the character.]\n"
					+ "\nset\n===============\n(attribute) (mentioned user) (character name) \n[Changes attribute]\n"
					+ "\nupdate\n===============\n(attribute) (mentioned user) (character name) \n[Updates attribute]"
					+ "\n\n***Any futher questions? Message Maka#8137***\n```";
		}
		else {
			return "```md\n#import <442/help.h>\n\n@protocol Station_442"
					+ "\n\ncall:\n==============="
					+ "\n++(database < view [owned-by, bio, full-bio, attr], set, update >\n    help \n    cat)\n"
					+ "\n[Adds a character to the database and assigns it to the mentioned user.]"
					+ "\n\nview\n===============\n\n\t> owned-by\n===============\n(mentioned user)\n[Views all characters owned by the mentioned user.]"
					+ "\n\n\t> bio\n===============\n(mentioned user) (character name)\n[Views a short summary of the character.]\n"
					+ "\n\t> full-bio\n===============\n(mentioned user) (character name)\n[Views a full biography of the character.]\n"
					+ "\nset\n===============\n(attribute) (mentioned user) (character name) \n[Changes attribute]\n"
					+ "\nupdate\n===============\n(attribute) (mentioned user) (character name) \n[Updates attribute]"
					+ "\n\n***Any futher questions? Message Maka#8137***\n```";
		}
	}
	
	public String database() {
		String val = "";
		try {
			switch (input[1]) {
				case "add":
					if (msgauthor.isServerAdmin()) {
						if (mentioned.isEmpty()) {
							try {
								byte[] bytes = attachments.get(0).downloadAsByteArray().get();
								String[] bio = new String(bytes, "UTF-8").split(";");
								Character c = new Character(mentioned.get(0), bio[0], bio[1],
										bio[2], bio[3], bio[4], bio[5], bio[6], bio[7], bio[8],
										bio[9], bio[10], bio[11], bio[12], bio[13], bio[14], bio[15]);
								chars.add(c);
								return "Added entry with the name " + c.getName() + " to the database.";
							}
							catch (Exception e) {
								e.printStackTrace();
								return "Error: please make sure to include a"
										+ " UTF-8 encoded .txt file with character"
										+ " attributes delimited by a semicolon (;).";
							}
						}
						else {
							try {
								byte[] bytes = attachments.get(0).downloadAsByteArray().get();
								String[] bio = new String(bytes, "UTF-8").split(";");
								Character c = new Character(mentioned.get(0), bio[0], bio[1],
										bio[2], bio[3], bio[4], bio[5], bio[6], bio[7], bio[8],
										bio[9], bio[10], bio[11], bio[12], bio[13], bio[14], bio[15]);
								chars.add(c);
								return "Added entry with the name " + c.getName() + " to the database.";
							}
							catch (Exception e) {
								e.printStackTrace();
								return "Error: please make sure to include a"
										+ " UTF-8 encoded .txt file with character"
										+ " attributes delimited by a semicolon (;).";
							}
						}
					}	
					else {
						return "Error: admin permissions required.";
					}
				case "view":
					switch (input[2]) {
						case "owned-by":
								ArrayList<Character> ret = chars.SearchByOwner(mentioned.get(0));
								if (ret.size() == 0) {
									return "No characters owned by that user.";
								}
								else {
									val = "The following characters are owned by ";
									val = val.concat(mentioned.get(0).getDiscriminatedName());
									for (int i = 0; i < ret.size(); i++) {
										val = val.concat("\n- ");
										val = val.concat(ret.get(i).getName());
									}
									return val;
								}
						case "bio":
							try {
								return chars.find(mentioned.get(0), input[4]).ShortBio();
							}
							catch (NullPointerException e) {
								return "Unable to find character with that name.";
							}
						case "full-bio":
							try {
								return chars.find(mentioned.get(0), input[4]).LongBio();
							}
							catch (NullPointerException e) {
								return "Unable to find character with that name.";
							}
						case "attr": 
							try {
								return chars.get(input, mentioned.get(0));
							}
							catch (NullPointerException e) {
								return "Unable to find character with that name.";
							}
						default:
							return "Unknown arg provided.";
					}
					
				case "delete":
					if (msgauthor.isServerAdmin() || user.get().equals(mentioned.get(0))) {
						if (chars.delete(mentioned.get(0), input[3]) == true) {
							return "Character successfully deleted.";
						}
						else {
							return "Unable to find character with that name.";
						}
					}
					else {
						return "Error: admin permissions *or* character ownership required.";
					}
					
				case "set":
					if (msgauthor.isServerAdmin() || user.get().equals(mentioned.get(0))) {
						if (chars.set(input, mentioned.get(0)) == true) {
							return "Value changed successfully.";
						}
						else {
							return "Error: please check args.";
						}
					}
					else {
						return "Error: admin permissions *or* character ownership required.";
					}
					
				case "update":
					if (msgauthor.isServerAdmin() || user.get().equals(mentioned.get(0))) {
						if (chars.update(input, mentioned.get(0)) == true) {
							return "Value updated successfully.";
						}
						else {
							return "Error: please check args.";
						}
					}
					else {
						return "Error: admin permissions *or* character ownership required.";
					}
			}
		
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return "Not enough args provided.";
		}
		catch (NullPointerException e) {
			return "NullPointerException";
		}
		return "error in CommandHandler.database()";
	}
	
	public static ArrayList<String> cutter(String s) {
		ArrayList<String> strings = new ArrayList<String>();
		int index = 0;
		while (index < s.length()) {
		    strings.add(s.substring(index, Math.min(index + 1800, s.length())));
		    index += 1800;
		}
		
		return strings;

	}
}
