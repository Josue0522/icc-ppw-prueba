package ec.edu.ups.icc.labevaluation.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ec.edu.ups.icc.labevaluation.users.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    public UserDetailsServiceImpl(UserRepository repository) { this.repository = repository; }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmailAndDeletedFalse(username)
            .map(UserDetailsImpl::new)
            .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}
