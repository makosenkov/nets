package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Gpus {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @ManyToOne
  private VideoInterfaces videoInterfaceId;
  private long power;

  @ManyToOne
  @Getter
  @Setter
  private GpuVendors vendorId;


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


  public VideoInterfaces getVideoInterfaceId() {
    return videoInterfaceId;
  }

  public void setVideoInterfaceId(VideoInterfaces videoInterfaceId) {
    this.videoInterfaceId = videoInterfaceId;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public GpuVendors getVendorId() {
    return vendorId;
  }

  public void setVendorId(GpuVendors vendorId) {
    this.vendorId = vendorId;
  }

}
