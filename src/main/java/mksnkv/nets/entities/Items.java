package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of = {"id", "price", "name"})
@EqualsAndHashCode(of = "id")
public class Items {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long price;
  private String name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
