package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Rams {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @ManyToOne
  private RamVersions versionId;
  private long power;
  @ManyToOne
  private RamFreqs ramFreqId;
  @ManyToOne
  private RamVendors vendorId;


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


  public RamVersions getVersionId() {
    return versionId;
  }

  public void setVersionId(RamVersions versionId) {
    this.versionId = versionId;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public RamFreqs getRamFreqId() {
    return ramFreqId;
  }

  public void setRamFreqId(RamFreqs ramFreqId) {
    this.ramFreqId = ramFreqId;
  }


  public RamVendors getVendorId() {
    return vendorId;
  }

  public void setVendorId(RamVendors vendorId) {
    this.vendorId = vendorId;
  }

}
