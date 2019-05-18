package mksnkv.nets.entities;

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
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Items itemId;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  public Cases(String name) {
    this.name = name;
    this.configurations = new HashSet<>();
  }

  @Setter
  @Getter
  @OneToMany(mappedBy = "caseId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Configurations> configurations;

}
