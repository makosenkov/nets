package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "psu_vendors")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PsuVendors {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Setter
  @Getter
  @Column(name = "name")
  private String name;

  public PsuVendors(String name) {
    this.name = name;
    this.psus = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Psus> psus;

  public void addСpu(Psus psu) {
    psus.add(psu);
  }

  public void removeСpu(Psus psu) {
    psus.remove(psu);
  }

}
