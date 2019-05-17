package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table
@EqualsAndHashCode(of = "id")
public class Motherboards {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;

  @ManyToOne
  private DiskInterfaces diskInterfaceId;

  @ManyToOne
  private RamVersions ramVersionId;

  @ManyToOne
  private RamFreqs maxRamFreqId;

  @ManyToOne
  private Sockets socketId;

  @ManyToOne
  private VideoInterfaces videoInterfaceId;

  @ManyToOne
  private MotherboardVendors vendorId;


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


  public DiskInterfaces getDiskInterfaceId() {
    return diskInterfaceId;
  }

  public void setDiskInterfaceId(DiskInterfaces diskInterfaceId) {
    this.diskInterfaceId = diskInterfaceId;
  }


  public RamVersions getRamVersionId() {
    return ramVersionId;
  }

  public void setRamVersionId(RamVersions ramVersionId) {
    this.ramVersionId = ramVersionId;
  }


  public RamFreqs getMaxRamFreqId() {
    return maxRamFreqId;
  }

  public void setMaxRamFreqId(RamFreqs maxRamFreqId) {
    this.maxRamFreqId = maxRamFreqId;
  }


  public Sockets getSocketId() {
    return socketId;
  }

  public void setSocketId(Sockets socketId) {
    this.socketId = socketId;
  }


  public VideoInterfaces getVideoInterfaceId() {
    return videoInterfaceId;
  }

  public void setVideoInterfaceId(VideoInterfaces videoInterfaceId) {
    this.videoInterfaceId = videoInterfaceId;
  }


  public MotherboardVendors getVendorId() {
    return vendorId;
  }

  public void setVendorId(MotherboardVendors vendorId) {
    this.vendorId = vendorId;
  }

}
