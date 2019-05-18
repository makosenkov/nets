package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ram_vendors")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class RamVendors {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Rams> rams;

  public void addRam(Rams ram) {
    rams.add(ram);
  }

  public void removeRam(Rams ram) {
    rams.remove(ram);
  }

}
