package com.ps.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.entity.Admin;
import com.ps.entity.User;
import com.ps.repository.AdminRepository;
import com.ps.repository.UserRepository;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Admin userAdmin = adminRepository.getAdminByEmail(username);
		// System.out.println("Admin logat " + userAdmin.getEmail());

		User userUser = userRepository.findByEmail(username);
		
		System.out.println("A");
		
		if (userAdmin != null || userUser != null ) {

			if (userAdmin != null) {
				String password = userAdmin.getPassword();
				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;

				Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

				authorities.add(new GrantedAuthorityImpl(userAdmin.getRole()
						.getRoleName()));

				org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(
						username, password, enabled, accountNonExpired,
						credentialsNonExpired, accountNonLocked, authorities);
				return securityUser;

			} else {
				System.out.println("Admin not found !");
			}

			if (userUser!= null) {
				String password = userUser.getPassword();
				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;
				
				Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

				authorities.add(new GrantedAuthorityImpl(userUser
						.getRole().getRoleName()));

				org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(
						username, password, enabled, accountNonExpired,
						credentialsNonExpired, accountNonLocked, authorities);
				return securityUser;
			} else {
				
			}
			

		} else {
			System.out.println("Nu a fost gasit emailul");
			throw new UsernameNotFoundException("User Not Found!!!");
		}
		return null;
	}

}
