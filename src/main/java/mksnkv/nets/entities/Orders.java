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
@Table(name = "orders")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Getter
  @Setter
  @Column(name = "total_price")
  private long totalPrice;

  @Getter
  @Setter
  @Column(name = "address")
  private String address;

  @Setter
  @Getter
  @ManyToMany
  @JsonManagedReference
  @JoinTable(name = "order_item_compat",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id"))
  private Set<Items> items;

  public void addItem(Items item) {
    items.add(item);
  }

  public void removeItem(Items item) {
    items.remove(item);
  }

  public Orders(long totalPrice, String address) {
    this.totalPrice = totalPrice;
    this.address = address;
    this.items = new HashSet<>();
  }
}
