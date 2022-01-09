package avtoproject.repository;


import avtoproject.entity.OrderAvto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderAvto, Integer> {
}
