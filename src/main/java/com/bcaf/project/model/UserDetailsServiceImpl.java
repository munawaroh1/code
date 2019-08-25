//package com.bcaf.project.model;
//
//import org.springframework.security.core.userdetails.User;
//
//import org.apache.commons.collections4.iterators.EmptyListIterator;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.bcaf.project.repository.UserRepo;
//
//import static java.util.Collections.emptyList;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService  {
//
//	private UserRepo applicationUserRepository;
//	
//	public UserDetailsServiceImpl(UserRepo applicationUserRepository) {
//		this.applicationUserRepository = applicationUserRepository;
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDetails User = applicationUserRepository.findByUsername(username);
//        if (User == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new User(User.getUsername(), User.getPassword(), emptyList());
//        
//	}
//}
