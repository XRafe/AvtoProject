package avtoProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "orderavto", schema = "avto")
public class OrderAvto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer count;

    private Integer sum;


    @Column(name = "id_user")
    private Integer user_id;

    @Column(name = "id_model")
    private Integer model_id;


    public OrderAvto() {

    }


    public OrderAvto(Integer count, Integer sum, Integer user_id, Integer model_id) {
        this.count = count;
        this.sum = sum;
        this.user_id = user_id;
        this.model_id = model_id;
    }

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private UserAvto PrimaryUser;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "id_model", insertable = false, updatable = false)
    private ModelAvto PrimaryModelAvto;


}
