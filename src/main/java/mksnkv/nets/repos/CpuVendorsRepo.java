package mksnkv.nets.repos;

import mksnkv.nets.entities.CpuVendors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuVendorsRepo extends JpaRepository<CpuVendors, Long> {
}
