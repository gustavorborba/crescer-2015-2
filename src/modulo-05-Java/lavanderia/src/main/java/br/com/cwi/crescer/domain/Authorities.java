package br.com.cwi.crescer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities{
	
	@Id
	@Column(name = "authority")
	private String authority;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "username")
	private Users user;

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users username) {
		this.user = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
