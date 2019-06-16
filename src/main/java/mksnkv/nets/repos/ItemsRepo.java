package mksnkv.nets.repos;

import mksnkv.nets.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepo extends JpaRepository<Items, Long> {

    List<Items> findItemsByIdIsIn(List<Long> ids);
}
