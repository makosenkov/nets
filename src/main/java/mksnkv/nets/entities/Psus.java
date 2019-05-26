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
@Table(name = "psus")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Psus {

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
  @Column(name = "power_rate")
  private long powerRate;

  @Setter
  @Getter
  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id")
  private PsuVendors vendorId;

  public Psus(String name, long powerRate, PsuVendors vendorId) {
    this.name = name;
    this.powerRate = powerRate;
    this.vendorId = vendorId;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "psuId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  public void addConfiguration(Configurations configuration) {
    configurations.add(configuration);
  }

  public void removeConfiguration(Configurations configuration) {
    configurations.remove(configuration);
  }

}
