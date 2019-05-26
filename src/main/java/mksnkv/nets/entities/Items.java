package mksnkv.nets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@NoArgsConstructor
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

  @Getter
  @Setter
  @Column(name = "available")
  private Boolean available;

  @ManyToMany
  @Getter
  @Setter
  @JsonBackReference
  @JoinTable(name = "order_item_compat",
      joinColumns = @JoinColumn(name = "item_id"),
      inverseJoinColumns = @JoinColumn(name = "order_id"))
  private Set<Orders> orders;

  public void addOrder(Orders order) {
    orders.add(order);
  }

  public void removeOrder(Orders order) {
    orders.remove(order);
  }

  public Items(long price, String name, boolean available) {
    this.price = price;
    this.name = name;
    this.available = available;
    orders = new HashSet<>();
  }
}
