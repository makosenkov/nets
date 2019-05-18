package mksnkv.nets.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gpus")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Gpus {

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
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "video_interface_id")
  private VideoInterfaces videoInterfaceId;

  @Getter
  @Setter
  @Column(name = "power")
  private long power;

  @Getter
  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id")
  private GpuVendors vendorId;

  public Gpus(String name, VideoInterfaces videoInterfaceId, long power, GpuVendors vendorId) {
    this.name = name;
    this.videoInterfaceId = videoInterfaceId;
    this.power = power;
    this.vendorId = vendorId;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @OneToMany(mappedBy = "gpuId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

}
