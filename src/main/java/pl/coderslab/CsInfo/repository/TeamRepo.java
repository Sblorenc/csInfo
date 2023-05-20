package pl.coderslab.CsInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeamRepo extends JpaRepository<Team,Long> {

    Optional<Team> findTeamById(@Param("id")Long id);

    Optional<Team> deleteTeamById(@Param("id")Long id);



}
