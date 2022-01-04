package AvtoProject.repository;

import AvtoProject.entity.FirmAvto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmAvtoRepository extends JpaRepository<FirmAvto, Integer> {

}
