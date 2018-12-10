package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	private String userId;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private String salt;
	private String firstName;
	private String lastName;
	private Role role;
	private String status;
	private String geslacht;
	private String email;
	private int leeftijd;
	@JsonIgnore
	private List<Person> vrienden;
	//@JsonIgnore
	//private List<History> histories = new ArrayList<History>();


	public Person(String userId, String password, String firstName,
			String lastName,Role role, String email, int leeftijd, String geslacht) {
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setEmail(email);
		setLeeftijd(leeftijd);
		vrienden = new ArrayList<Person>();
		setGeslacht(geslacht);
		//this.setHistory(histories);
	}

	public Person(String userId, String password, String salt,
			String firstName, String lastName,Role role, String email, int leeftijd, String geslacht) {
		setUserId(userId);
		setPassword(password);
		setSalt(salt);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setEmail(email);
		setLeeftijd(leeftijd);
		vrienden = new ArrayList<>();
		setGeslacht(geslacht);
		//this.setHistory(histories);
	}

	public Person() {
	}

	public String getStatus() {
		return status;
	}

	public void setGeslacht(String geslacht){
		this.geslacht = geslacht;
	}
	public String getGeslacht(){return geslacht;}

	public String getEmail() {
		return email;
	}

	public int getLeeftijd() {
		return leeftijd;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}
	

	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonIgnore
	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	@JsonIgnore
	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	@JsonIgnore
	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	@JsonIgnore
	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	@JsonIgnore
	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	@JsonIgnore
	public void setSalt(String salt) {
		this.salt = salt;
	}

	@JsonIgnore
	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public void addVriend(Person p){
		vrienden.add(p);
	}

	public void deleteVriend(Person p){
		for (Person x : vrienden) {
			if (p.getUserId().equals(x.getUserId())) {
				vrienden.remove(x);
			}
		}
	}


	@JsonIgnore
	public List<Person> getVrienden(){
		return this.vrienden;
	}

	/*
	@JsonIgnore
	public List<History> getHistory() {
		return histories;
	}

	@JsonIgnore
	public void setHistory(List<History> history) {
		this.histories = history;
	}
	*/



}
