/**
 * Created by Kapmat on 2016-09-11.
 */
package kapmat.service;


import kapmat.bean.UserInfo;
import kapmat.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userDAO.getUserInfo(username);
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userInfo.getRole());
		UserDetails userDetails = new User(userInfo.getUsername(), userInfo.getPassword(),
				Arrays.asList(grantedAuthority));
		return userDetails;
	}
}
