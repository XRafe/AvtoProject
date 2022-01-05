package AvtoProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role", schema = "avto")
public class Role implements GrantedAuthority {

    public Role () {

    }

    public Role(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    @Id
    private Integer id;

    private String code;


    @ManyToMany(mappedBy = "roles")
    private Set<UserAvto> users;

    @Override
    public String getAuthority() {
        return getCode();
    }
}