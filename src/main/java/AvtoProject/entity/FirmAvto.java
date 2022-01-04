package AvtoProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "firmavto", schema = "avto")
public class FirmAvto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firm;

    public FirmAvto() {

    }

    public FirmAvto(String firm) {
        this.firm = firm;
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "PrimaryFirmAvto", fetch = FetchType.EAGER)
    private Collection<ModelAvto> Models;

}
