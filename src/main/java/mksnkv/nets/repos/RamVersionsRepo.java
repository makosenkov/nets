package mksnkv.nets.repos;

import mksnkv.nets.entities.RamVersions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamVersionsRepo extends JpaRepository<RamVersions, Long> {
}
