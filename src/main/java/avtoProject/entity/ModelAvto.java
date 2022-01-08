package avtoProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "modelavto", schema = "avto")
public class ModelAvto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String model;

    private Integer price;


    @Column(name = "id_firm")
    private Integer firm_id;


    public ModelAvto() {

    }

    public ModelAvto(String model, Integer price, Integer firm_id) {
        this.model = model;
        this.price = price;
        this.firm_id = firm_id;
    }

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_firm", insertable = false, updatable = false)
    private FirmAvto PrimaryFirmAvto;


    @Getter
    @Setter
    @OneToOne(mappedBy = "PrimaryModelAvto", fetch = FetchType.EAGER)
    private OrderAvto orderAvto;

}
