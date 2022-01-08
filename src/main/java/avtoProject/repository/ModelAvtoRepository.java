package avtoProject.repository;


import avtoProject.entity.ModelAvto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelAvtoRepository extends JpaRepository<ModelAvto, Integer> {

}
