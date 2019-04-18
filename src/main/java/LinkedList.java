// --STATION 442 Database Bot--
// Developer: Maka#8137
// LinkedList.java
// updated 06-May-2018 cjk for CSC 161
// MODIFIED by Maka#8137, 05.17.2018 for CSC 161
// ADAPTED by Maka#8137 for use in logging Characters (2.23.2019)
// ---------------------------
// Methods:
// LinkedList(): null constructor
// LinkedList(Character): constructor with a head
// isEmpty(): returns true if count == 0
// add(Character n): adds a Character object n to the LinkedList
// get(int n): returns a Character at index n
// find(User u, String n): finds and returns a Character with u as
//						   their owner and their name contains n.
// delete(User u, String n): finds and deletes a Character with u
//							 as their owner and their name contains
//							 n, then deletes them from the database.
// SearchByName(String n): finds and returns a character with a name
//						   containing String n.
// SearchByOwner(User o): finds and returns an ArrayList of Character
// 						  objects with the owner variable matching
//						  User o.
// set(String[] input, User user): changes attribute provided in args
//								   to given argument
// update(String[] input, User user): appends attribute provided in args
//									  to given argument
// size(): returns count

import java.util.ArrayList;

import org.javacord.api.entity.user.*;

public class LinkedList {
	private Character head; // top of the list
	private int count;  // for size
	
	// constructor that creates an empty linked list
	public LinkedList() {
		head = null;
		count = 0;
	}
	
	// constructor that initializes the linked list
	// to a Character
	public LinkedList(Character c) {
		head = c;
		count = 1;
	}
	
	public boolean isEmpty() {
	// Boolean to check if the list is empty- pretty self explanatory.
		return (count == 0);
	}
	
	public void add(Character n) {
		if (head == null)  {// the list is empty
			head = n;
			count++;
		}
		else {
			Character p = head;
			// use Character pointer p to
			// 'walk down' the list until
			// it gets to the Character whose
			// next field is null
			while(p.getNext() != null)
				p = p.getNext();
			
			// set the next field to be the
			// Character that was passed in	
			p.setNext(n);
			count++;
		}  // end else clause
	}  // end method add
	
	public Character get(int n) {
		// Set temporary variable c to head
		// then traverse until n
		Character c = head;
		for (int i = 0; i <= n; i++) {
			c = c.getNext();
		}
		// Return Character at n
		return c;
	}
	
	public Character find(User u, String n) {
		Character c = head;
		// set temporary variable c to head
		Character p = null;
		// set temporary variable p to null
		
		// remove case issues right away
		n = n.toLowerCase();
		
		// traverse the LinkedList until a match is found.
		// if one is found, set p to c at that time
		// and immediately return it.
		for (int i = 0; i < count; i++) {
			String s = c.getName().toLowerCase();
			if (c.getOwner().getMentionTag().equals(u.getMentionTag()) 
					&& s.contains(n)) {
				p = c;
				break;
			}
			else {
				c = c.getNext();
			}
		}
		return p;
	}
	
	public boolean delete(User u, String n) {
		// basically the find method, except
		// the if clause is different
		
		// Returns a boolean so that the bot 
		// can return a 'successful' or 'failed'
		// message to Discord.
		Character c = head;
		Character p = find(u, n);
		n = n.toLowerCase();
		for (int i = 0; i < count; i++) {
			if (c.getNext().equals(p)) {
				c.setNext(p.getNext());
				count--;
				return true;
			}
			else {
				c = c.getNext();
			}
		}
		return false;
	}
	
	public Character SearchByName(String n) {
		// I don't remember when I use this but
		// I'm really scared to delete it,
		// to be honest.
		Character c = head;
		for (int i = 0; i < count; i++) {
			if (c.getName().contains(n)) {
				return c;
			}
			else {
				c = c.getNext();
			}
		}
		return null;
	}

	public ArrayList<Character> SearchByOwner(User o) {
		// init new ArrayList to store (you guessed it)
		// the results.
		ArrayList<Character> results = new ArrayList<Character>();
		Character c = head;
		for (int i = 0; i < count; i++) {
			if (o.getMentionTag().equals(c.getOwner().getMentionTag())) {
				results.add(c);
				c = c.getNext();
			}
			else {
				c = c.getNext();
			}	
		}
		return results;
	}
	
	public boolean set(String[] input, User user) {
		// This method is a really, REALLY long
		// switch statement to basically find the
		// correct setter to call.
		
		// Similarly to delete, it returns a boolean
		// so that the bot can report to the user
		// if it was successful or not.
		String temp = "";
		// descriptive name, I know. used so that
		// if new attribute is more than one word,
		// it is easier to set the entire thing.
		Character c = find(user, input[4]);
		switch (input[2]) {
			case "name":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setName(temp);
				return true;
				
			case "alias":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setAlias(temp);
				return true;
				
			case "gender":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setGender(temp);
				return true;
				
			case "age":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setAge(temp);
				return true;
				
			case "species":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setSpecies(temp);
				return true;
				
			case "sector":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setSector(temp);
				return true;
				
			case "job":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setJob(temp);
				return true;
				
			case "class":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setClas(temp);
				return true;
				
			case "alignment":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setAlignment(temp);
				return true;
				
			case "strengths":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setStrengths(temp);
				return true;
				
			case "weaknesses":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setWeaknesses(temp);
				return true;
				
			case "equipment":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setEquipment(temp);
				return true;
				
			case "personality":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setPersonality(temp);
				return true;
				
			case "shortbio":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setShortBio(temp);
				return true;
				
			case "appearance":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setAppearance(temp);
				return true;

			case "image":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setImage(temp);
				return true;
		}
		return false;
		
	}

	public boolean update(String[] input, User user) {
		// This method is a really, REALLY long
		// switch statement to basically find the
		// correct setter to call.
				
		// Similarly to delete, it returns a boolean
		// so that the bot can report to the user
		// if it was successful or not.
		String temp = "";
		// descriptive name, I know. used so that
		// if new attribute is more than one word,
		// it is easier to set the entire thing.
		Character c = find(user, input[4]);
		switch (input[2]) {
			case "alias":
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setAlias(temp);
				return true;
		
			case "strengths":
				temp = c.getStrengths();
				temp = temp.concat("\nUPDATE: ");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setStrengths(temp);
				return true;
			
			case "weaknesses":
				temp = c.getWeaknesses();
				temp = temp.concat("\nUPDATE: ");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setWeaknesses(temp);
				return true;
			
			case "equipment":	
				temp = c.getEquipment();
				temp = temp.concat("\nUPDATE: ");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setEquipment(temp);
				return true;
				
			case "personality":
				temp = c.getPersonality();
				temp = temp.concat("\nUPDATE:");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setPersonality(temp);
				return true;
			
			case "shortbio":
				temp = c.getShortBio();
				temp = temp.concat("\nUPDATE: ");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setShortBio(temp);
				return true;
			
			case "appearance":
				temp = c.getAppearance();
				temp = temp.concat("\nUPDATE: ");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setAppearance(temp);
				return true;

			case "image":
				temp = c.getImage();
				temp = temp.concat("\n");
				for (int i = 5; i < input.length; i++) {
					temp = temp.concat(input[i]);
					temp = temp.concat(" ");
				}
				c.setImage(temp);
				return true;
		}
		return false;
	}
	
	public String get(String[] input, User user) {
		// Retrieval of Character attributes.
		// This method is a really, REALLY long
		// switch statement to basically find the
		// correct getter to call.
		try {
			Character c = find(user, input[5]);
			String[] firstname = c.getName().toLowerCase().split("\\s+");
			switch (input[3]) {
				case "name":
					return "```ini\n[package " + firstname[0] + ".data]\nname = " + c.getName() + "\n```";
					
				case "alias":
					return "```ini\n[package " + firstname[0] + ".data]\nalias = " + c.getAlias() + "\n```";
					
				case "gender":
					return "```ini\n[package " + firstname[0] + ".data]\ngender = " + c.getGender() + "\n```";
							
				case "age":
					return "```ini\n[package " + firstname[0] + ".data]\nage = " + c.getAge() + "\n```";
							
				case "species":
					return "```ini\n[package " + firstname[0] + ".data]\nspecies = " + c.getSpecies() + "\n```";
							
				case "sector":
					return "```ini\n[package " + firstname[0] + ".data]\nsector = " + c.getSector() + "\n```";
							
				case "job":
					return "```ini\n[package " + firstname[0] + ".data]\njob = " + c.getJob() + "\n```";
							
				case "class":
					return "```ini\n[package " + firstname[0] + ".data]\nclass = " + c.getClas() + "\n```";
							
				case "alignment":
					return "```ini\n[package " + firstname[0] + ".data]\nalignment = " + c.getAlignment() + "\n```";
							
				case "strengths":
					return "```ini\n[package " + firstname[0] + ".data]\nstrengths = " + c.getStrengths() + "\n```";
							
				case "weaknesses":
					return "```ini\n[package " + firstname[0] + ".data]\nweaknesses = " + c.getWeaknesses() + "\n```";
							
				case "equipment":
					return "```ini\n[package " + firstname[0] + ".data]\nequipment = " + c.getEquipment() + "\n```";
							
				case "personality":
					return "```ini\n[package " + firstname[0] + ".data]\npersonality = " + c.getPersonality() + "\n```";
							
				case "shortbio":
					return "```ini\n[package " + firstname[0] + ".data]\nshort_bio = " + c.getShortBio() + "\n```";
							
				case "appearance":
					return "```ini\n[package " + firstname[0] + ".data]\nappearance = " + c.getAppearance() + "\n```";

				case "image":
					return c.getImage();
				
				default:
					return "Unknown arg provided.";
			}
		}
		catch (NullPointerException e) {
			return "No character found.";
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return "Not enough args provided.";
		}
	}
	
	int size() {
		// Method to return the number of Characters in the list
		return count;
	}
	
	
}  // end class LinkedList

