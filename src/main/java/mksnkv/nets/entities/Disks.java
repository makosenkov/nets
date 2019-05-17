package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Disks {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String architecture;
  @ManyToOne
  private DiskInterfaces interfaceId;
  private long power;
  @ManyToOne
  private DiskVendors vendorId;


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


  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }


  public DiskInterfaces getInterfaceId() {
    return interfaceId;
  }

  public void setInterfaceId(DiskInterfaces interfaceId) {
    this.interfaceId = interfaceId;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public DiskVendors getVendorId() {
    return vendorId;
  }

  public void setVendorId(DiskVendors vendorId) {
    this.vendorId = vendorId;
  }

}
