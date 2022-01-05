package AvtoProject.repository;

import AvtoProject.entity.UserAvto;
import AvtoProject.entity.projection.UserIdProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserAvto, Integer>, JpaSpecificationExecutor<UserAvto> {

    Optional<UserAvto> findByLogin(String login);

    UserIdProjection findOneByLogin(String login);


    @EntityGraph("UserAvto.roles")
    Optional<UserAvto> findOneWithRolesByLogin(String login);

    @EntityGraph("UserAvto.roles")
    @Query("select u from UserAvto u")
    List<UserAvto> findAllWithRoles();

}
