package cn.edu.hqu.javaee.chapter5_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static org.springframework.ldap.query.LdapQueryBuilder.query;
@Component
public class MyLdapUserDetailsService implements UserDetailsService{
	// @Autowired
	 //private PersonRepository personRepository;
	 @Autowired
	 LdapTemplate ldapTemplate;
	 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Here is OK");
		Person person=ldapTemplate.findOne(query().where("sn").is(username), Person.class);
		System.out.println(person.getUsername());
		return person;
		}

}
