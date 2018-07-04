package cn.edu.hqu.javaee.chapter5_3;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.accept.ContentNegotiationStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	  private static final String KEY = "localhost";
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Autowired
//	UserDetailsManager userDetailsManager;
	@Autowired
	UserDetailsService userDetailsService;
	@Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);//设置账户信息服务层
		authenticationProvider.setPasswordEncoder(passwordEncoder);//设置密码编码器
		return authenticationProvider;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/css**","/js/**","/fonts/**","/users").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/console/**").hasAnyRole("ADMIN","USER")
		.and()
		.formLogin()
		.and()
		.rememberMe().key(KEY)
		.and().exceptionHandling().accessDeniedPage("/403");
		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().sameOrigin();
	       super.configure(http);
	}
	
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
    	auth.authenticationProvider(authenticationProvider());
	}
}

