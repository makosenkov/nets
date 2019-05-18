package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "video_interfaces")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class VideoInterfaces {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public VideoInterfaces(String name, Set<Gpus> gpus) {
    this.name = name;
    this.gpus = gpus;
    this.motherboards = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "videoInterfaceId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Gpus> gpus;

  public void addGpu(Gpus gpu) {
    gpus.add(gpu);
  }

  public void removeGpu(Gpus gpu) {
    gpus.remove(gpu);
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "videoInterfaceId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  public void addMotherboard(Motherboards motherboard) {
    motherboards.add(motherboard);
  }

  public void removeMotherboard(Motherboards motherboard) {
    motherboards.remove(motherboard);
  }

}
