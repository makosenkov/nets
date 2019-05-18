package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cpu_vendors")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CpuVendors {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public CpuVendors(String name) {
    this.name = name;
    this.cpus = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Cpus> cpus;

  public void addСpu(Cpus cpu) {
    cpus.add(cpu);
  }

  public void removeСpu(Cpus cpu) {
    cpus.remove(cpu);
  }

}
