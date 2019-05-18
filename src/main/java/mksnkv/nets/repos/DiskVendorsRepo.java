package mksnkv.nets.repos;

import mksnkv.nets.entities.DiskVendors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiskVendorsRepo extends JpaRepository<DiskVendors, Long> {
}
