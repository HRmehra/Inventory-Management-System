package com.backend.inventree.SecServices;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.inventree.models.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String email;	
	private long phoneno;	
	private String gender;
	private String address;
	private Date dob;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserImpl(String id, String username, String email ,String gender,
			long phoneno,Date dob,String address,String password,
			Collection<? extends GrantedAuthority> authorities ) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.gender= gender;
		this.phoneno= phoneno;
		this.dob=dob;
		this.address=address;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserImpl build(Users user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getGender(),
				user.getPhoneno(),
				user.getDob(),
				user.getAddress(),
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	//@Override
	public long getPhoneno() {
		return phoneno;
	}

	//@Override
	public String getGender() {
		return gender;
	}

	//@Override
	public String getAddress() {
		return address;
	}

	//@Override
	public Date getDob() {
		return dob;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserImpl user = (UserImpl) o;
		return Objects.equals(id, user.id);
	}

}
