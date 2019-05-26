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
@Table(name = "motherboard_vendors")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MotherboardVendors {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public MotherboardVendors(String name) {
    this.name = name;
    this.motherboards = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  public void addMotherboard(Motherboards motherboard) {
    motherboards.add(motherboard);
  }

  public void removeMotherboard(Motherboards motherboard) {
    motherboards.remove(motherboard);
  }

}
