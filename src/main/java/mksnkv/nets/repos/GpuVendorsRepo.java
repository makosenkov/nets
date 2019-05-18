package mksnkv.nets.repos;

import mksnkv.nets.entities.GpuVendors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuVendorsRepo extends JpaRepository<GpuVendors, Long> {
}
