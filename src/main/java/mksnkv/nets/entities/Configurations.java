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

  private Motherboards motherboardId;
  private Cpus cpuId;
  private Gpus gpuId;
  private Rams ramId;
  private Disks diskId;
  private Psus psuId;
  private Cases caseId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Motherboards getMotherboardId() {
    return motherboardId;
  }

  public void setMotherboardId(Motherboards motherboardId) {
    this.motherboardId = motherboardId;
  }


  public Cpus getCpuId() {
    return cpuId;
  }

  public void setCpuId(Cpus cpuId) {
    this.cpuId = cpuId;
  }


  public Gpus getGpuId() {
    return gpuId;
  }

  public void setGpuId(Gpus gpuId) {
    this.gpuId = gpuId;
  }


  public Rams getRamId() {
    return ramId;
  }

  public void setRamId(Rams ramId) {
    this.ramId = ramId;
  }


  public Disks getDiskId() {
    return diskId;
  }

  public void setDiskId(Disks diskId) {
    this.diskId = diskId;
  }


  public Psus getPsuId() {
    return psuId;
  }

  public void setPsuId(Psus psuId) {
    this.psuId = psuId;
  }


  public Cases getCaseId() {
    return caseId;
  }

  public void setCaseId(Cases caseId) {
    this.caseId = caseId;
  }

}
