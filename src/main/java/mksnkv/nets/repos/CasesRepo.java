package mksnkv.nets.repos;

import mksnkv.nets.entities.Cases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasesRepo extends JpaRepository<Cases, Long> {
}
