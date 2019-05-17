package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class RamFreqs {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getName() {
    return name;
  }

  public void setName(long name) {
    this.name = name;
  }

}
