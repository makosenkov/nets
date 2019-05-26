package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "motherboards")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Motherboards {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  @OneToOne
  @MapsId
  @Getter
  @Setter
  @JsonBackReference
  private Items item;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "disk_interface_id")
  private DiskInterfaces diskInterfaceId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ram_version_id")
  private RamVersions ramVersionId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "max_ram_freq_id")
  private RamFreqs maxRamFreqId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "socket_id")
  private Sockets socketId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "video_interface_id")
  private VideoInterfaces videoInterfaceId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id")
  private MotherboardVendors vendorId;

  public Motherboards(String name, DiskInterfaces diskInterfaceId, RamVersions ramVersionId, RamFreqs maxRamFreqId,
                      Sockets socketId, VideoInterfaces videoInterfaceId, MotherboardVendors vendorId) {
    this.name = name;
    this.diskInterfaceId = diskInterfaceId;
    this.ramVersionId = ramVersionId;
    this.maxRamFreqId = maxRamFreqId;
    this.socketId = socketId;
    this.videoInterfaceId = videoInterfaceId;
    this.vendorId = vendorId;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "motherboardId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  public void addConfiguration(Configurations configuration) {
    configurations.add(configuration);
  }

  public void removeConfiguration(Configurations configuration) {
    configurations.remove(configuration);
  }

}
