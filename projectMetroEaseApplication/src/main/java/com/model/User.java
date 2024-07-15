package com.model;

import java.util.List;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity

  //  @Table(name = "user", uniqueConstraints = { 
  //	      @UniqueConstraint(columnNames = { "email", "username" }) 
  //	})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	
	@Column(unique = true)
	private String userEmail;
	private String password;
    private String mobileNo;
    
    //@OneToMany(fetch = FetchType.EAGER)
   //@JoinColumn(name="bookId")
    //nullable = false is not needed because primary key already has this property
   //private List<Booking> booking;
	//booking is not needed
    
	public User() {
		super();
	}

	public User(long userId,String userEmail, String password, String mobileNo) {
		super();
		this.userId = userId;
	   //this.userName = userEmail;
		this.userEmail = userEmail;
		this.password = password;
		this.mobileNo = mobileNo;
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	@PrePersist
    public void prePersist() 
	{
        generateCredentials();
    }

	private void generateCredentials() 
	{
       // this.userName = generateRandomString(8);
        this.password = generateRandomString(6);
    }
	
	 private String generateRandomString(int length) 
	 {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder stringBuilder = new StringBuilder();
	        Random rnd = new Random();
	        while (stringBuilder.length() < length) 
	        {
	            int index = (int) (rnd.nextFloat() * chars.length());
	            stringBuilder.append(chars.charAt(index));
	        }
	        return stringBuilder.toString();
	 
	 }
	        
}
