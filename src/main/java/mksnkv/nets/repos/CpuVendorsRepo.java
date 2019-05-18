package mksnkv.nets.repos;

import mksnkv.nets.entities.Cpus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuVendorsRepo extends JpaRepository<Cpus, Long> {
}
