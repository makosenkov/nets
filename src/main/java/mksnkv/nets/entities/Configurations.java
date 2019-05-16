package mksnkv.nets.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of = {"id", "motherboardId", "cpuId", "gpuId", "ramId", "diskId", "psuId", "caseId"})
@EqualsAndHashCode(of = "id")
public class Configurations {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long motherboardId;
  private long cpuId;
  private long gpuId;
  private long ramId;
  private long diskId;
  private long psuId;
  private long caseId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMotherboardId() {
    return motherboardId;
  }

  public void setMotherboardId(long motherboardId) {
    this.motherboardId = motherboardId;
  }


  public long getCpuId() {
    return cpuId;
  }

  public void setCpuId(long cpuId) {
    this.cpuId = cpuId;
  }


  public long getGpuId() {
    return gpuId;
  }

  public void setGpuId(long gpuId) {
    this.gpuId = gpuId;
  }


  public long getRamId() {
    return ramId;
  }

  public void setRamId(long ramId) {
    this.ramId = ramId;
  }


  public long getDiskId() {
    return diskId;
  }

  public void setDiskId(long diskId) {
    this.diskId = diskId;
  }


  public long getPsuId() {
    return psuId;
  }

  public void setPsuId(long psuId) {
    this.psuId = psuId;
  }


  public long getCaseId() {
    return caseId;
  }

  public void setCaseId(long caseId) {
    this.caseId = caseId;
  }

}
