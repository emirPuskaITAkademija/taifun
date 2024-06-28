package ba.smoki.taifun.security;

import ba.smoki.taifun.user.repository.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Spona između Springovog UserDetails i našeg User objekta.
 * <p>
 * Mi ćemo preko ovog UserAdpater reći Springu da ne koristi više svoj ugrađeni
 * UserDetails objekat nego da koristi naš UserAdapter.
 * </p>
 */
public class UserAdapter implements UserDetails {

    private final User user;

    public UserAdapter(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
