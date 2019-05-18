package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cpus")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Cpus {

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
  @JoinColumn(name = "socket_id")
  private Sockets socketId;

  @Getter
  @Setter
  @JsonBackReference
  @Column(name = "power")
  private long power;

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
  @JoinColumn(name = "vendor_id")
  private CpuVendors vendorId;

  public Cpus(String name, Sockets socketId, long power, RamFreqs maxRamFreqId, CpuVendors vendorId) {
    this.name = name;
    this.socketId = socketId;
    this.power = power;
    this.maxRamFreqId = maxRamFreqId;
    this.vendorId = vendorId;
    this.configurations = new HashSet<>();
    this.motherboards = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "cpuId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  @Setter
  @Getter
  @ManyToMany
  @JsonBackReference
  @JoinTable(name = "moth_cpu_compat",
      joinColumns = @JoinColumn(name = "cpu_id"),
      inverseJoinColumns = @JoinColumn(name = "motherboard_id"))
  private Set<Motherboards> motherboards;
}
