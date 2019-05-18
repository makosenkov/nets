package mksnkv.nets.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ram_versions")
@ToString
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
  @OneToMany(mappedBy = "versionId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Rams> rams;

  public void addRam(Rams ram) {
    rams.add(ram);
  }

  public void removeRam(Rams ram) {
    rams.remove(ram);
  }

}
