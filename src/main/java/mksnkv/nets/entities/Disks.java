package mksnkv.nets.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disks")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Disks {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Items itemId;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  @Getter
  @Setter
  @Column(name = "architecture")
  private String architecture;

  @Getter
  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "interface_id")
  private DiskInterfaces interfaceId;

  @Getter
  @Setter
  @Column(name = "power")
  private long power;

  @Getter
  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id")
  private DiskVendors vendorId;

  public Disks(String name, String architecture, DiskInterfaces interfaceId, long power, DiskVendors vendorId) {
    this.name = name;
    this.architecture = architecture;
    this.interfaceId = interfaceId;
    this.power = power;
    this.vendorId = vendorId;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @OneToMany(mappedBy = "diskId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;
}
