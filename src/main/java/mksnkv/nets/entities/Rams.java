package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rams")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Rams {

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
  @JoinColumn(name = "version_id")
  private RamVersions versionId;

  @Getter
  @Setter
  @Column(name = "power")
  private long power;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ram_freq_id")
  private RamFreqs ramFreqId;

  @Getter
  @Setter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id")
  private RamVendors vendorId;

  public Rams(String name, RamVersions versionId, long power, RamFreqs ramFreqId, RamVendors vendorId) {
    this.name = name;
    this.versionId = versionId;
    this.power = power;
    this.ramFreqId = ramFreqId;
    this.vendorId = vendorId;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "ramId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  public void addConfiguration(Configurations configuration) {
    configurations.add(configuration);
  }

  public void removeConfiguration(Configurations configuration) {
    configurations.remove(configuration);
  }

}
