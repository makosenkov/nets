package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@NoArgsConstructor
@ToString(of = {"price", "name"})
@EqualsAndHashCode(of = "id")
public class Items {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "price")
  private long price;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Cpus> cpus;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Gpus> gpus;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Psus> psus;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Rams> rams;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Cases> cases;

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Disks> disks;

  @Setter
  @Getter
  @ManyToMany
  @JsonManagedReference
  @JoinTable(name = "order_item_compat",
      joinColumns = @JoinColumn(name = "item_id"),
      inverseJoinColumns = @JoinColumn(name = "order_id"))
  private Set<Orders> orders;

  public Items(long price, String name) {
    this.price = price;
    this.name = name;
    this.configurations = new HashSet<>();
    this.cpus = new HashSet<>();
    this.gpus = new HashSet<>();
    this.psus = new HashSet<>();
    this.rams = new HashSet<>();
    this.motherboards = new HashSet<>();
    this.cases = new HashSet<>();
    this.disks = new HashSet<>();
    this.orders = new HashSet<>();
  }
}
