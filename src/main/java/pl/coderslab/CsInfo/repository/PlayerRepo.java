package pl.coderslab.CsInfo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.CsInfo.entity.Player;
import pl.coderslab.CsInfo.entity.Team;
import java.util.List;
import java.util.Optional;
@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

    Optional<Player> findById(@Param("id")Long id);

    Optional<Player> deletePlayerById(@Param("id")Long id);

    List<Player> findPlayerByTeam (@Param("team") Team team);


}
