package mksnkv.nets.repos;

import mksnkv.nets.entities.Gpus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpusRepo extends JpaRepository<Gpus, Long> {
}
