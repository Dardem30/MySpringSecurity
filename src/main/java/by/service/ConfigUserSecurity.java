package by.service;

import by.DAO.DAOUser;
import by.model.Role;
import by.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 21.07.2017.
 */
@Service("configUserSecurity")
public class ConfigUserSecurity implements UserDetailsService{
    private DAOUser daoUser;

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=daoUser.findByUsername(s);
        Set<GrantedAuthority> grantedAuthoritySet=new HashSet<>();
        for(Role role: user.getRoles()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthoritySet);
    }
}
