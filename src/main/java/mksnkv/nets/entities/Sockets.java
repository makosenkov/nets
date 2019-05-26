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
@Table(name = "sockets")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sockets {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public Sockets(String name) {
    this.name = name;
    this.cpus = new HashSet<>();
    this.motherboards = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "socketId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Cpus> cpus;

  public void addСpu(Cpus cpu) {
    cpus.add(cpu);
  }

  public void removeСpu(Cpus cpu) {
    cpus.remove(cpu);
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "socketId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Motherboards> motherboards;

  public void addMotherboard(Motherboards motherboard) {
    motherboards.add(motherboard);
  }

  public void removeMotherboard(Motherboards motherboard) {
    motherboards.remove(motherboard);
  }

}
