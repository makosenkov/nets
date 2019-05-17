package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Psus {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private long powerRate;

  @ManyToOne
  private PsuVendors vendorId;


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


  public long getPowerRate() {
    return powerRate;
  }

  public void setPowerRate(long powerRate) {
    this.powerRate = powerRate;
  }


  public PsuVendors getVendorId() {
    return vendorId;
  }

  public void setVendorId(PsuVendors vendorId) {
    this.vendorId = vendorId;
  }

}
