package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class VideoInterfaces {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
