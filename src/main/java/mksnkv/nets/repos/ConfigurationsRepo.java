package mksnkv.nets.repos;

import mksnkv.nets.entities.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationsRepo extends JpaRepository<Configurations, Long> {
}
