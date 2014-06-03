package com.tl.myspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import sun.security.util.Password;

@Entity
public class Player extends BaseEntity{
    //email
    private String playerId;

    private String password;

	@Column(name = "first_name")
    @NotEmpty
    protected String firstName;

    @Column(name = "last_name")
    @NotEmpty
    protected String lastName;
    
    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 20)
    private String telephone;
    
    private int playRound;
    
    private int winRound;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getPlayRound() {
		return playRound;
	}

	public void setPlayRound(int playRound) {
		this.playRound = playRound;
	}

	public int getWinRound() {
		return winRound;
	}

	public void setWinRound(int winRound) {
		this.winRound = winRound;
	}
    
    
}
