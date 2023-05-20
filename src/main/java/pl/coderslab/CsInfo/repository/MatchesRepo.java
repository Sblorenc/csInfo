package pl.coderslab.CsInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.CsInfo.entity.Matches;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchesRepo extends JpaRepository<Matches, Long> {
    List<Matches>findMatchesByTeamList(Team team);

    Optional<Matches> deleteMatchesById(@Param("id")Long id);
}
