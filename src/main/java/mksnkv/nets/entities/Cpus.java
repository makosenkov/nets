package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Cpus {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;

  @ManyToOne
  private Sockets socketId;
  private long power;
  @ManyToOne
  private RamFreqs maxRamFreqId;
  @ManyToOne
  private CpuVendors vendorId;


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


  public Sockets getSocketId() {
    return socketId;
  }

  public void setSocketId(Sockets socketId) {
    this.socketId = socketId;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public RamFreqs getMaxRamFreqId() {
    return maxRamFreqId;
  }

  public void setMaxRamFreqId(RamFreqs maxRamFreqId) {
    this.maxRamFreqId = maxRamFreqId;
  }


  public CpuVendors getVendorId() {
    return vendorId;
  }

  public void setVendorId(CpuVendors vendorId) {
    this.vendorId = vendorId;
  }

}
