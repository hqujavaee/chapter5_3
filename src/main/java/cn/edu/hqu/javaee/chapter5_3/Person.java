package cn.edu.hqu.javaee.chapter5_3;

import java.util.Collection;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entry(base = "ou=people,dc=didispace,dc=com", objectClasses = "inetOrgPerson")
public class Person implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2861178454301787459L;
	@Id
	private Name id;
	
	@DnAttribute(value = "uid", index = 3)
	private String uid;
	
	@Attribute(name = "cn")
	private String commonName;
	
	@Attribute(name = "sn")
	private String suerName;
	
	private String userPassword;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userPassword;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return suerName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}