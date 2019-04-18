// --STATION 442 Database Bot--
// Developer: Maka#8137
// Character.java
// ---------------------------
// Methods:
// Character(): null constructor
// Character(User o, String n): constructor with only
//								an owner and a name.
// Character(a bunch of strings): constructor wth all fields
// ShortBio(): returns a shortened, console-looking formatted
//			   short biography of the character.
// LongBio(): returns all information available for the character.
// equals(Character c): checks if c's owner and name are the same
//						as this Character's.
// set and get methods are fairly self explanatory.

import org.javacord.api.entity.user.*;

public class Character {
	
	private Character next;
	// Character object is used as a Node for LinkedList
	// it is singly-linked, no no prev is needed
	
	private User owner;
	private String name, alias, gender, age, species;
	private String sector, job, clas, alignment;
	private String strengths, weaknesses, equipment;
	private String personality, shortbio, appearance, image;
	// Image is a string because I have limited space on my Raspberry Pi
	// and am using imgur instead.
	
	// Null/Empty constructor
	public Character() {
		// This is split up for ease of reading.
		owner = null;
		
		name = "";
		alias = "";
		gender = "";
		age = "";
		species = "";
		
		sector = "";
		job = "";
		clas = "";
		alignment = "";
		
		strengths = "";
		weaknesses = "";
		equipment = "";
		personality = "";
		
		shortbio = "";
		appearance = "";
		image = "";
		
	}
	
	public Character(User o, String n) {
		
		owner = o;
		name = n;
		alias = "";
		gender = "";
		age = "";
		species = "";
		sector = "";
		job = "";
		clas = "";
		alignment = "";
		strengths = "";
		weaknesses = "";
		equipment = "";
		personality = "";
		shortbio = "";
		appearance = "";
		image = "";
		
	}
	
	// Constructor with EVERY field provided.
	public Character(User o, String n, String a, String g, String ag, String sp,
			String sec, String j, String cl, String al, String st,
			String we, String eq, String per, String sho, String app, String img) {
		owner = o;
		name = n;
		alias = a;
		gender = g;
		age = ag;
		species = sp;
		sector = sec;
		job = j;
		clas = cl;
		alignment = al;
		strengths = st;
		weaknesses = we;
		equipment = eq;
		personality = per;
		shortbio = sho;
		appearance = app;
		image = img;
	}
	
	public String ShortBio() {
		String[] firstname = name.toLowerCase().split("\\s+");
		String ret = 
			("```ini\n[package " + firstname[0] + ".data]" +
			"\n\nowner = " + owner.getDiscriminatedName() +
			"\nname = " + name + "\nalias = " + alias +
			"\ngender = " + gender + "\nage = " + age +
			"\nspecies = " + species + "\nsector = " + sector + 
			"\nappearance = " + appearance + "\n```" + image);
		return ret;
	}
	
	public String LongBio() {
		String ret = 
			("**Owner:** " + owner.getDiscriminatedName() +
			"\n**Name:** " + name + "\n**Alias:** " + alias +
			"\n**Gender:** " + gender + "\n**Age:** " + age +
			"\n**Species:** " + species + "\n**Sector:** " + sector + 
			"\n**Job:** " + job + "\n**Class:** " + clas +
			"\n**Alignment:** " + alignment + "\n**Strengths:** " + strengths +
			"\n**Weaknesses:** " + weaknesses + "\n**Equipment:** " + equipment + 
			"\n**Personality:** " + personality +
			"\n**Short Bio:** " + shortbio + "\n**Appearance:** " + appearance + 
			"\n**Image(s):**\n" + image);
				
		return ret;
	}
	
	public boolean equals(Character c) {
		if (name.equals(c.getName()) && alias.equals(c.getAlias()) 
				&& owner.getMentionTag().equals(c.getOwner().getMentionTag())) {
			return true;
		}
		return false;
	}
	
	// Could these be done in a better way?
	// Probably, but it works.
	
	// ----SET METHODS----
	public void setOwner(User o) {
		owner = o;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setAlias(String a) {
		alias = a;
	}
	
	public void setGender(String g) {
		gender = g;
	}
	
	public void setAge(String a) {
		age = a;
	}
	
	public void setSpecies(String s) {
		species = s;
	}
	
	public void setSector(String s) {
		sector = s;
	}
	
	public void setJob(String j) {
		job = j;
	}
	
	public void setClas(String c) {
		clas = c;
	}
	
	public void setAlignment(String a) {
		alignment = a;
	}
	
	public void setStrengths(String s) {
		strengths = s;
	}
	
	public void setWeaknesses(String w) {
		weaknesses = w;
	}
	
	public void setPersonality(String p) {
		personality = p;
	}
	
	public void setAppearance(String a) {
		appearance = a;
	}
	
	public void setShortBio(String s) {
		shortbio = s;
	}
	
	public void setEquipment(String e) {
		equipment = e;
	}
	
	public void setImage(String i) {
		image = i;
	}
	
	public void setNext(Character c) {
		next = c;
	}
	// -------------------
	
	
	// ----GET METHODS----
	public User getOwner() {
		return owner;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public String getSector() {
		return sector;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getClas() {
		return clas;
	}
	
	public String getAlignment() {
		return alignment;
	}
	
	public String getStrengths() {
		return strengths;
	}
	
	public String getWeaknesses() {
		return weaknesses;
	}
	
	public String getEquipment() {
		return equipment;
	}
	
	public String getPersonality() {
		return personality;
	}
	
	public String getShortBio() {
		return shortbio;
	}
	
	public String getAppearance() {
		return appearance;
	}
	
	public String getImage() {
		return image;
	}
	
	public Character getNext() {
		return next;
	}
	// -------------------
	
}
