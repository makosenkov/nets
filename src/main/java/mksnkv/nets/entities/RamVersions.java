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
@Table(name = "ram_versions")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RamVersions {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public RamVersions(String name) {
    this.name = name;
    this.motherboards = new HashSet<>();
    this.rams = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "ramVersionId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  public void addMotherboard(Motherboards motherboard) {
    motherboards.add(motherboard);
  }

  public void removeMotherboard(Motherboards motherboard) {
    motherboards.remove(motherboard);
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "versionId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Rams> rams;

  public void addRam(Rams ram) {
    rams.add(ram);
  }

  public void removeRam(Rams ram) {
    rams.remove(ram);
  }

}
