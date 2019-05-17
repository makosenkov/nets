package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Table
@EqualsAndHashCode(of = "id")
public class OrderItemCompat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long orderNumber;
  @ManyToMany
  private Items itemId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(long orderNumber) {
    this.orderNumber = orderNumber;
  }


  public Items getItemId() {
    return itemId;
  }

  public void setItemId(Items itemId) {
    this.itemId = itemId;
  }

}
