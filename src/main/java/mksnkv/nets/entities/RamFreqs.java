package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ram_freqs")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RamFreqs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Setter
  @Getter
  @Column(name = "name")
  private long name;

  public RamFreqs(long name) {
    this.name = name;
    this.motherboards = new HashSet<>();
    this.cpus = new HashSet<>();
    this.rams = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "maxRamFreqId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  public void addMotherboard(Motherboards motherboard) {
    motherboards.add(motherboard);
  }

  public void removeMotherboard(Motherboards motherboard) {
    motherboards.remove(motherboard);
  }

  @Setter
  @Getter
  @OneToMany(mappedBy = "maxRamFreqId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Cpus> cpus;

  public void addСpu(Cpus cpu) {
    cpus.add(cpu);
  }

  public void removeСpu(Cpus cpu) {
    cpus.remove(cpu);
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "ramFreqId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Rams> rams;

  public void addRam(Rams ram) {
    rams.add(ram);
  }

  public void removeRam(Rams ram) {
    rams.remove(ram);
  }

}
