package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "psu_vendors")
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

  public void addPsu(Psus psu) {
    psus.add(psu);
  }

  public void removePsu(Psus psu) {
    psus.remove(psu);
  }

}
