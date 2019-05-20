package mksnkv.nets.utilities;

import lombok.AllArgsConstructor;
import mksnkv.nets.entities.*;
import mksnkv.nets.repos.*;

import java.util.Random;

@AllArgsConstructor
public class Generator {

    private final ItemsRepo itemsRepo;
    private final CpuVendorsRepo cpuVendorsRepo;
    private final GpuVendorsRepo gpuVendorsRepo;
    private final RamVendorsRepo ramVendorsRepo;
    private final RamVersionsRepo ramVersionsRepo;
    private final RamFreqsRepo ramFreqsRepo;
    private final PsuVendorsRepo psuVendorsRepo;
    private final DiskVendorsRepo diskVendorsRepo;
    private final DiskInterfacesRepo diskInterfacesRepo;
    private final SocketsRepo socketsRepo;
    private final VideoInterfacesRepo videoInterfacesRepo;
    private final MotherboardsRepo motherboardsRepo;
    private final MotherboardVendorsRepo motherboardVendorsRepo;
    private final CpusRepo cpusRepo;
    private final GpusRepo gpusRepo;
    private final PsusRepo psusRepo;
    private final RamsRepo ramsRepo;
    private final CasesRepo casesRepo;
    private final DisksRepo disksRepo;
    private final ConfigurationsRepo configurationsRepo;
    private final OrdersRepo ordersRepo;

    private final int itemsNumber;
    private final int cpusNumber;
    private final int ramsNumber;
    private final int gpusNumber;
    private final int psusNumber;
    private final int disksNumber;
    private final int casesNumber;
    private final int motherboardsNumber;
    private final int configurationsNumber;
    private final int cpuVendorsNumber;
    private final int gpuVendorsNumber;
    private final int psuVendorsNumber;
    private final int ramVendorsNumber;
    private final int ramVersionsNumber;
    private final int ramFreqsNumber;
    private final int motherboardVendorsNumber;
    private final int diskVendorsNumber;
    private final int socketsNumber;
    private final int videoInterfacesNumber;
    private final int diskInterfacesNumber;
    private final int ordersNumber;

    private final EntitiesGenerator entityGenerator = new EntitiesGenerator();
    private final Random random = new Random();
    private static final int batchSize = 50;

    public void generate() {
        generateRamVersions();
        generateRamFreqs();
        generateRamVendors();
        generateRams();
        generateGpuVendors();
        generateVideoInterfaces();
        generateGpus();
        generateCpuVendors();
        generateSockets();
        generateCpus();
        generatePsuVendors();
        generatePsus();
        generateCases();
        generateDiskInterfaces();
        generateDiskVendors();
        generateDisks();
        generateMotherboardVendors();
        generateMotherboards();
    }

    public void generateRamVersions() {
        int i = 0;
        while (i < ramVersionsNumber) {
            i++;
            ramVersionsRepo.save(entityGenerator.generateRamVersion(i));
            if (i % batchSize == 0) {
                ramVersionsRepo.flush();
            }
        }
        ramVersionsRepo.flush();
    }

    public void generateRamFreqs() {
        int i = 0;
        while (i < ramFreqsNumber) {
            i++;
            try {
                ramFreqsRepo.save(entityGenerator.generateRamFreq());
                if (i % batchSize == 0) {
                    ramFreqsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        ramFreqsRepo.flush();
    }


    public void generateRamVendors() {
        int i = 0;
        while (i < ramVendorsNumber) {
            i++;
            try {
                ramVendorsRepo.save(entityGenerator.generateRamVendor());
                if (i % batchSize == 0) {
                    ramVendorsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
            ramVendorsRepo.flush();
        }
    }

    public void generateRams() {
        int i = 0;
        while (i < ramsNumber) {
            i++;
            try {
                Rams ram = entityGenerator.generateRam();
                ram.setRamFreqId(ramFreqsRepo.findAll().get(random.nextInt(ramFreqsNumber - 1)));
                ram.setVersionId(ramVersionsRepo.findAll().get(random.nextInt(ramVersionsNumber - 1)));
                ram.setVendorId(ramVendorsRepo.findAll().get(random.nextInt(ramVendorsNumber - 1)));
                ramsRepo.save(ram);
                if (i % batchSize == 0) {
                    ramsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        ramsRepo.flush();
    }

    public void generateGpuVendors() {
        int i = 0;
        while (i < gpuVendorsNumber) {
            i++;
            try {
                gpuVendorsRepo.save(entityGenerator.generateGpuVendor());
                if (i % batchSize == 0) {
                    gpuVendorsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        gpuVendorsRepo.flush();
    }

    public void generateVideoInterfaces() {
        int i = 0;
        while (i < videoInterfacesNumber) {
            i++;
            try {
                videoInterfacesRepo.save(entityGenerator.generateVideoInterface());
                if (i % batchSize == 0) {
                    videoInterfacesRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        videoInterfacesRepo.flush();
    }

    public void generateGpus() {
        int i = 0;
        while (i < gpusNumber) {
            i++;
            try {
                Gpus gpu = entityGenerator.generateGpu();
                gpu.setVendorId(gpuVendorsRepo.findAll().get(random.nextInt(gpuVendorsNumber)));
                gpu.setVideoInterfaceId(videoInterfacesRepo.findAll().get(random.nextInt(videoInterfacesNumber)));
                gpusRepo.save(gpu);
                if (i % batchSize == 0) {
                    gpusRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        gpusRepo.flush();
    }

    public void generateCpuVendors() {
        int i = 0;
        while (i < cpuVendorsNumber) {
            i++;
            try {
                cpuVendorsRepo.save(entityGenerator.generateCpuVendor());
                if (i % batchSize == 0) {
                    cpuVendorsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        cpuVendorsRepo.flush();
    }

    public void generateSockets() {
        int i = 0;
        while (i < socketsNumber) {
            i++;
            try {
                socketsRepo.save(entityGenerator.generateSocket(i));
                if (i % batchSize == 0) {
                    socketsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        socketsRepo.flush();
    }

    public void generateCpus() {
        int i = 0;
        while (i < cpusNumber) {
            i++;
            try {
                Cpus cpu = entityGenerator.generateCpu();
                cpu.setMaxRamFreqId(ramFreqsRepo.findAll().get(random.nextInt(ramFreqsNumber)));
                cpu.setVendorId(cpuVendorsRepo.findAll().get(random.nextInt(cpuVendorsNumber)));
                cpu.setSocketId(socketsRepo.findAll().get(random.nextInt(socketsNumber)));
                cpusRepo.save(cpu);
                if (i % batchSize == 0) {
                    cpusRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        cpusRepo.flush();
    }

    public void generatePsuVendors() {
        int i = 0;
        while (i < psuVendorsNumber) {
            i++;
            try {
                psuVendorsRepo.save(entityGenerator.generatePsuVendor());
                if (i % batchSize == 0) {
                    psuVendorsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        psuVendorsRepo.flush();
    }

    public void generatePsus() {
        int i = 0;
        while (i < psusNumber) {
            i++;
            try {
                Psus psu = entityGenerator.generatePsu();
                psu.setVendorId(psuVendorsRepo.findAll().get(random.nextInt(psuVendorsNumber)));
                psusRepo.save(psu);
                if (i % batchSize == 0) {
                    psusRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        psusRepo.flush();
    }

    public void generateCases() {
        int i = 0;
        while (i < casesNumber) {
            i++;
            try {
                casesRepo.save(entityGenerator.generateCase());
                if (i % batchSize == 0) {
                    casesRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        casesRepo.flush();
    }

    public void generateDiskInterfaces() {
        int i = 0;
        while (i < diskInterfacesNumber) {
            i++;
            try {
                diskInterfacesRepo.save(entityGenerator.generateDiskInterface(i));
                if (i % batchSize == 0) {
                    diskInterfacesRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        diskInterfacesRepo.flush();
    }

    public void generateDiskVendors() {
        int i = 0;
        while (i < diskVendorsNumber) {
            i++;
            try {
                diskVendorsRepo.save(entityGenerator.generateDiskVendor());
                if (i % batchSize == 0) {
                    diskVendorsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        diskVendorsRepo.flush();
    }

    public void generateDisks() {
        int i = 0;
        while (i < disksNumber) {
            i++;
            try {
                Disks disk = entityGenerator.generateDisk();
                disk.setVendorId(diskVendorsRepo.findAll().get(random.nextInt(diskVendorsNumber)));
                disksRepo.save(disk);
                if (i % batchSize == 0) {
                    disksRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        disksRepo.flush();
    }

    public void generateMotherboardVendors() {
        int i = 0;
        while (i < motherboardVendorsNumber) {
            i++;
            try {
                motherboardVendorsRepo.save(entityGenerator.generateMotherboardVendor());
                if (i % batchSize == 0) {
                    motherboardVendorsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        motherboardVendorsRepo.flush();
    }

    public void generateMotherboards() {
        int i = 0;
        while (i < motherboardsNumber) {
            i++;
            try {
                Motherboards motherboard = entityGenerator.generateMotherboard();
                motherboard.setVendorId(motherboardVendorsRepo.findAll().get(random.nextInt(motherboardVendorsNumber)));
                motherboardsRepo.save(motherboard);
                if (i % batchSize == 0) {
                    motherboardsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        motherboardsRepo.flush();
    }
}