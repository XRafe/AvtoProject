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
    private Integer userId;

    @Column(name = "id_model")
    private Integer modelId;


    public OrderAvto() {

    }


    public OrderAvto(Integer count, Integer sum, Integer userId, Integer modelId) {
        this.count = count;
        this.sum = sum;
        this.userId = userId;
        this.modelId = modelId;
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
