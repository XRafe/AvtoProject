package AvtoProject.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NamedEntityGraphs({
        @NamedEntityGraph(name = "UserAvto.roles", attributeNodes = {
                @NamedAttributeNode(value = "roles")
        })
})
@Table(name = "useravto", schema = "avto")
public class UserAvto implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String password;



    @ManyToMany
    @JoinTable(name = "user_role", schema = "avto",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;


    @Setter
    @Getter
    @OneToMany(mappedBy = "PrimaryUser", fetch = FetchType.EAGER)
    private Collection<OrderAvto> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
