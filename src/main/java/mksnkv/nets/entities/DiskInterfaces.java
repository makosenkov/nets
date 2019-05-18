package mksnkv.nets.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disk_interfaces")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DiskInterfaces {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public DiskInterfaces(String name) {
    this.name = name;
    this.disks = new HashSet<>();
  }

  @Setter
  @Getter
  @OneToMany(mappedBy = "interfaceId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Disks> disks;

  @Setter
  @Getter
  @OneToMany(mappedBy = "diskInterfaceId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  public void addDisk(Disks disk) {
    disks.add(disk);
  }

  public void removeDisk(Disks disk) {
    disks.remove(disk);
  }

  public void addMotherboard(Motherboards motherboard) {
    motherboards.add(motherboard);
  }

  public void removeMotherboard(Motherboards motherboard) {
    motherboards.remove(motherboard);
  }

}
