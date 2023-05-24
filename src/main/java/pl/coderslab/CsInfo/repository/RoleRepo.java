package pl.coderslab.CsInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Optional<Role> findByName(@Param("name")String name);
}
