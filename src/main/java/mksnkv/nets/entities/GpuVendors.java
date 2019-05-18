package mksnkv.nets.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gpu_vendors")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class GpuVendors {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public GpuVendors(String name) {
    this.name = name;
    this.gpus = new HashSet<>();
  }

  @Setter
  @Getter
  @OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Gpus> gpus;

  public void addGpu(Gpus gpu) {
    gpus.add(gpu);
  }

  public void removeGpu(Gpus gpu) {
    gpus.remove(gpu);
  }


}
