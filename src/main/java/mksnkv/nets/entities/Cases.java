package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cases")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Cases {

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

  public Cases(String name) {
    this.name = name;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @JsonManagedReference
  @OneToMany(mappedBy = "caseId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

  public void addConfiguration(Configurations configuration) {
    configurations.add(configuration);
  }

  public void removeConfiguration(Configurations configuration) {
    configurations.remove(configuration);
  }

}
