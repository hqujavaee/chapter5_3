package cn.edu.hqu.javaee.chapter5_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

//package cn.edu.hqu.javaee.chapter5_3;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
//import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
//import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
//import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
//@Configuration
//public class ldapUserSecurityConfig {
//	@Bean
//	public LdapUserDetailsManager ldapUserDetailsManager() {
//		DefaultSpringSecurityContextSource defaultSpringSecurityContextSource=new DefaultSpringSecurityContextSource("ldap://localhost:389/dc=didispace,dc=com");
//		LdapUserDetailsManager ldapUserDetailsManager=new LdapUserDetailsManager(defaultSpringSecurityContextSource);
//		return ldapUserDetailsManager;
//	}
//
//}