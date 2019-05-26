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
@Table(name = "disk_vendors")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DiskVendors {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public DiskVendors(String name) {
    this.name = name;
    this.disks = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "vendorId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Disks> disks;

  public void addDisk(Disks disk) {
    disks.add(disk);
  }

  public void removeDisk(Disks disk) {
    disks.remove(disk);
  }


}
