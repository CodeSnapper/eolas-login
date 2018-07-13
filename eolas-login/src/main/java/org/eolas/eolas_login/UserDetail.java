package org.eolas.eolas_login;

import java.util.Collection;
import java.util.List;

import org.eolas.DAO.UserRep;
import org.eolas.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetail implements UserDetailsService{
	@Autowired
	UserRep userRep;
	
	User user;
	 private static final Logger LOGGER = LoggerFactory.getLogger(Security.class);

	@Override
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if(!userRep.isUserNPassCorrect(userName)){
			LOGGER.error("UserName is not in database");
			throw new UsernameNotFoundException("UserName not Found");
		}
			else{
			user = userRep.getUserDetails(userName);
			LOGGER.debug("User Details: "+user.toString());
			return new UserDetails() {
				
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isEnabled() {
					if(user.getEnable().equalsIgnoreCase("Y"))
						return true;
					return false;
				}
				
				@Override
				public boolean isCredentialsNonExpired() {
					if(user.getCredentialNotExpired().equalsIgnoreCase("Y"))
						return true;
					return false;
				}
				
				@Override
				public boolean isAccountNonLocked() {
					if(user.getCredentialNotExpired().equalsIgnoreCase("Y"))
						return true;
					return false;
					
				}
				
				@Override
				public boolean isAccountNonExpired() {
					if(user.getAccountExpired().equalsIgnoreCase("N"))
						return true;
					return false;
				}
				
				@Override
				public String getUsername() {
					return userName;
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return user.getPassword();
				}
				
				@Override
				public Collection<? extends GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
					auths.add(new SimpleGrantedAuthority("Admin"));
					return auths;
				}
			};
		}
		
	}
	

}
