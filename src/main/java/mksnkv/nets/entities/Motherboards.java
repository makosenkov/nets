package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "motherboards")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Motherboards {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Items itemId;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

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
    this.cpus = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "motherboardId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  @Setter
  @Getter
  @ManyToMany
  @JsonManagedReference
  @JoinTable(name = "moth_cpu_compat",
      joinColumns = @JoinColumn(name = "motherboard_id"),
      inverseJoinColumns = @JoinColumn(name = "cpu_id"))
  private Set<Cpus> cpus;

}
