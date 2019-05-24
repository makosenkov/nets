package mksnkv.nets.utilities;

import mksnkv.nets.entities.*;
import mksnkv.nets.repos.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    private static final int batchSize = 500;
    private List<VideoInterfaces> videoInterfacesList;
    private List<Sockets> socketsList;
    private List<RamFreqs> ramFreqsList;

    private List<RamVersions> ramVersionsList;
    private List<Psus> psusList;
    private List<RamVendors> ramVendorsList;
    private List<Rams> ramsList;
    private List<GpuVendors> gpuVendorsList;
    private List<Gpus> gpusList;
    private List<CpuVendors> cpuVendorsList;
    private List<Cpus> cpusList;
    private List<PsuVendors> psuVendorsList;
    private List<Cases> casesList;
    private List<DiskInterfaces> diskInterfacesList;
    private List<DiskVendors> diskVendorsList;
    private List<Disks> disksList;
    private List<MotherboardVendors> motherboardVendorsList;
    private List<Motherboards> motherboardsList;
    private List<Items> itemsList;

    public Generator(ItemsRepo itemsRepo,
                     CpuVendorsRepo cpuVendorsRepo,
                     GpuVendorsRepo gpuVendorsRepo,
                     RamVendorsRepo ramVendorsRepo,
                     RamVersionsRepo ramVersionsRepo,
                     RamFreqsRepo ramFreqsRepo,
                     PsuVendorsRepo psuVendorsRepo,
                     DiskVendorsRepo diskVendorsRepo,
                     DiskInterfacesRepo diskInterfacesRepo,
                     SocketsRepo socketsRepo,
                     VideoInterfacesRepo videoInterfacesRepo,
                     MotherboardsRepo motherboardsRepo,
                     MotherboardVendorsRepo motherboardVendorsRepo,
                     CpusRepo cpusRepo,
                     GpusRepo gpusRepo,
                     PsusRepo psusRepo,
                     RamsRepo ramsRepo,
                     CasesRepo casesRepo,
                     DisksRepo disksRepo,
                     ConfigurationsRepo configurationsRepo,
                     OrdersRepo ordersRepo,
                     int cpusNumber,
                     int ramsNumber,
                     int gpusNumber,
                     int psusNumber,
                     int disksNumber,
                     int casesNumber,
                     int motherboardsNumber,
                     int configurationsNumber,
                     int cpuVendorsNumber,
                     int gpuVendorsNumber,
                     int psuVendorsNumber,
                     int ramVendorsNumber,
                     int ramVersionsNumber,
                     int ramFreqsNumber,
                     int motherboardVendorsNumber,
                     int diskVendorsNumber,
                     int socketsNumber,
                     int videoInterfacesNumber,
                     int diskInterfacesNumber,
                     int ordersNumber) {
        this.itemsRepo = itemsRepo;
        this.cpuVendorsRepo = cpuVendorsRepo;
        this.gpuVendorsRepo = gpuVendorsRepo;
        this.ramVendorsRepo = ramVendorsRepo;
        this.ramVersionsRepo = ramVersionsRepo;
        this.ramFreqsRepo = ramFreqsRepo;
        this.psuVendorsRepo = psuVendorsRepo;
        this.diskVendorsRepo = diskVendorsRepo;
        this.diskInterfacesRepo = diskInterfacesRepo;
        this.socketsRepo = socketsRepo;
        this.videoInterfacesRepo = videoInterfacesRepo;
        this.motherboardsRepo = motherboardsRepo;
        this.motherboardVendorsRepo = motherboardVendorsRepo;
        this.cpusRepo = cpusRepo;
        this.gpusRepo = gpusRepo;
        this.psusRepo = psusRepo;
        this.ramsRepo = ramsRepo;
        this.casesRepo = casesRepo;
        this.disksRepo = disksRepo;
        this.configurationsRepo = configurationsRepo;
        this.ordersRepo = ordersRepo;
        this.cpusNumber = cpusNumber;
        this.ramsNumber = ramsNumber;
        this.gpusNumber = gpusNumber;
        this.psusNumber = psusNumber;
        this.disksNumber = disksNumber;
        this.casesNumber = casesNumber;
        this.motherboardsNumber = motherboardsNumber;
        this.configurationsNumber = configurationsNumber;
        this.cpuVendorsNumber = cpuVendorsNumber;
        this.gpuVendorsNumber = gpuVendorsNumber;
        this.psuVendorsNumber = psuVendorsNumber;
        this.ramVendorsNumber = ramVendorsNumber;
        this.ramVersionsNumber = ramVersionsNumber;
        this.ramFreqsNumber = ramFreqsNumber;
        this.motherboardVendorsNumber = motherboardVendorsNumber;
        this.diskVendorsNumber = diskVendorsNumber;
        this.socketsNumber = socketsNumber;
        this.videoInterfacesNumber = videoInterfacesNumber;
        this.diskInterfacesNumber = diskInterfacesNumber;
        this.ordersNumber = ordersNumber;
    }

    public void generate() {
        long begin = System.currentTimeMillis();
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
        generateConfigurations();
        generateMothCpuCompat();
        generateOrders();
        long end = System.currentTimeMillis();
        long elapsed = end - begin;
        System.out.println(String.format("%d sec",
            TimeUnit.MILLISECONDS.toSeconds(elapsed)
        ));
    }

    private void generateRamVersions() {
        int i = 0;
        while (i < ramVersionsNumber) {
            i++;
            try {
                ramVersionsRepo.save(entityGenerator.generateRamVersion());
                if (i % batchSize == 0) {
                    ramVersionsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        ramVersionsRepo.flush();
        ramVersionsList = ramVersionsRepo.findAll();
    }

    private void generateRamFreqs() {
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
        ramFreqsList = ramFreqsRepo.findAll();
    }


    private void generateRamVendors() {
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
        }
        ramVendorsRepo.flush();
        ramVendorsList = ramVendorsRepo.findAll();
    }

    private void generateRams() {
        int i = 0;
        while (i < ramsNumber) {
            i++;
            try {
                Rams ram = entityGenerator.generateRam();
                RamFreqs ramFreq = ramFreqsList.get(random.nextInt(ramFreqsNumber - 1));
                RamVersions ramVersion = ramVersionsList.get(random.nextInt(ramVersionsNumber - 1));
                RamVendors ramVendor = ramVendorsList.get(random.nextInt(ramVendorsNumber - 1));
                ram.setRamFreqId(ramFreq);
                ram.setVersionId(ramVersion);
                ram.setVendorId(ramVendor);

                Items item = entityGenerator.generateItem();
                ram.setItem(item);

                itemsRepo.save(item);
                ramsRepo.save(ram);
                if (i % batchSize == 0) {
                    ramsRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        ramsRepo.flush();
        itemsRepo.flush();
        ramsList = ramsRepo.findAll();
    }

    private void generateGpuVendors() {
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
        gpuVendorsList = gpuVendorsRepo.findAll();
    }

    private void generateVideoInterfaces() {
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
        videoInterfacesList = videoInterfacesRepo.findAll();
    }

    private void generateGpus() {
        int i = 0;
        while (i < gpusNumber) {
            i++;
            try {
                Gpus gpu = entityGenerator.generateGpu();
                GpuVendors vendor = gpuVendorsList.get(random.nextInt(gpuVendorsNumber));
                VideoInterfaces videoInterface = videoInterfacesList.get(random.nextInt(videoInterfacesNumber));
                gpu.setVendorId(vendor);
                gpu.setVideoInterfaceId(videoInterface);
                ;
                Items item = entityGenerator.generateItem();
                gpu.setItem(item);

                gpusRepo.save(gpu);
                itemsRepo.save(item);
                if (i % batchSize == 0) {
                    gpusRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        gpusRepo.flush();
        itemsRepo.flush();
        gpusList = gpusRepo.findAll();
    }

    private void generateCpuVendors() {
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
        cpuVendorsList = cpuVendorsRepo.findAll();
    }

    private void generateSockets() {
        int i = 0;
        while (i < socketsNumber) {
            i++;
            try {
                socketsRepo.save(entityGenerator.generateSocket());
                if (i % batchSize == 0) {
                    socketsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        socketsRepo.flush();
        socketsList = socketsRepo.findAll();
    }

    private void generateCpus() {
        int i = 0;
        while (i < cpusNumber) {
            i++;
            try {
                Cpus cpu = entityGenerator.generateCpu();
                RamFreqs ramFreq = ramFreqsList.get(random.nextInt(ramFreqsNumber));
                CpuVendors vendor = cpuVendorsList.get(random.nextInt(cpuVendorsNumber));
                Sockets socket = socketsList.get(random.nextInt(socketsNumber));
                cpu.setMaxRamFreqId(ramFreq);
                cpu.setVendorId(vendor);
                cpu.setSocketId(socket);


                Items item = entityGenerator.generateItem();
                cpu.setItem(item);

                cpusRepo.save(cpu);
                itemsRepo.save(item);
                if (i % batchSize == 0) {
                    cpusRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        cpusRepo.flush();
        itemsRepo.flush();
        cpusList = cpusRepo.findAll();
    }

    private void generatePsuVendors() {
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
        psuVendorsList = psuVendorsRepo.findAll();
    }

    private void generatePsus() {
        int i = 0;
        while (i < psusNumber) {
            i++;
            try {
                Psus psu = entityGenerator.generatePsu();
                psu.setVendorId(psuVendorsList.get(random.nextInt(psuVendorsNumber)));

                Items item = entityGenerator.generateItem();
                psu.setItem(item);

                psusRepo.save(psu);
                itemsRepo.save(item);
                if (i % batchSize == 0) {
                    psusRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        psusRepo.flush();
        itemsRepo.flush();
        psusList = psusRepo.findAll();
    }

    private void generateCases() {
        int i = 0;
        while (i < casesNumber) {
            i++;
            try {
                Cases caseObj = entityGenerator.generateCase();

                Items item = entityGenerator.generateItem();
                caseObj.setItem(item);

                casesRepo.save(caseObj);
                itemsRepo.save(item);
                if (i % batchSize == 0) {
                    casesRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        casesRepo.flush();
        itemsRepo.flush();
        casesList = casesRepo.findAll();
    }

    private void generateDiskInterfaces() {
        int i = 0;
        while (i < diskInterfacesNumber) {
            i++;
            try {
                diskInterfacesRepo.save(entityGenerator.generateDiskInterface());
                if (i % batchSize == 0) {
                    diskInterfacesRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        diskInterfacesRepo.flush();
        diskInterfacesList = diskInterfacesRepo.findAll();
    }

    private void generateDiskVendors() {
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
        diskVendorsList = diskVendorsRepo.findAll();
    }

    private void generateDisks() {
        int i = 0;
        while (i < disksNumber) {
            i++;
            try {
                Disks disk = entityGenerator.generateDisk();
                disk.setVendorId(diskVendorsList.get(random.nextInt(diskVendorsNumber)));
                disk.setInterfaceId(diskInterfacesList.get(random.nextInt(diskInterfacesNumber)));

                Items item = entityGenerator.generateItem();
                disk.setItem(item);

                itemsRepo.save(item);
                disksRepo.save(disk);

                if (i % batchSize == 0) {
                    disksRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        disksRepo.flush();
        itemsRepo.flush();
        disksList = disksRepo.findAll();
    }

    private void generateMotherboardVendors() {
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
        motherboardVendorsList = motherboardVendorsRepo.findAll();
    }

    private void generateMotherboards() {
        int i = 0;
        while (i < motherboardsNumber) {
            i++;
            try {
                Motherboards motherboard = entityGenerator.generateMotherboard();
                motherboard.setVendorId(motherboardVendorsList.get(random.nextInt(motherboardVendorsNumber)));
                motherboard.setDiskInterfaceId(diskInterfacesList.get(random.nextInt(diskInterfacesNumber)));
                motherboard.setMaxRamFreqId(ramFreqsList.get(random.nextInt(ramFreqsNumber)));
                motherboard.setRamVersionId(ramVersionsList.get(random.nextInt(ramVersionsNumber)));
                motherboard.setSocketId(socketsList.get(random.nextInt(socketsNumber)));
                motherboard.setVideoInterfaceId(videoInterfacesList.get(random.nextInt(videoInterfacesNumber)));

                Items item = entityGenerator.generateItem();
                motherboard.setItem(item);

                itemsRepo.save(item);
                motherboardsRepo.save(motherboard);
                if (i % batchSize == 0) {
                    motherboardsRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        motherboardsRepo.flush();
        itemsRepo.flush();
        motherboardsList = motherboardsRepo.findAll();
    }

    private void generateConfigurations() {
        int i = 0;
        while (i < configurationsNumber) {
            i++;
            try {
                Configurations configuration = entityGenerator.generateConfiguration();
                Cpus cpu = cpusRepo.findAll().get(random.nextInt(cpusNumber));
                Gpus gpu = gpusList.get(random.nextInt(gpusNumber));
                Psus psu = psusList.get(random.nextInt(gpusNumber));
                Cases caseObj = casesList.get(random.nextInt(casesNumber));
                Motherboards motherboard = motherboardsList.get(random.nextInt(motherboardsNumber));
                Disks disk = disksList.get(random.nextInt(disksNumber));
                Rams ram = ramsList.get(random.nextInt(ramsNumber));
                configuration.setCpuId(cpu);
                configuration.setGpuId(gpu);
                configuration.setPsuId(psu);
                configuration.setCaseId(caseObj);
                configuration.setMotherboardId(motherboard);
                configuration.setDiskId(disk);
                configuration.setRamId(ram);

                Items item = entityGenerator.generateItem();
                itemsRepo.save(item);

                configuration.setItem(item);
                configurationsRepo.save(configuration);
                if (i % batchSize == 0) {
                    configurationsRepo.flush();
                    itemsRepo.flush();
                }
            } catch (Exception e) {
                continue;
            }
        }
        configurationsRepo.flush();
        itemsRepo.flush();
    }

    private void generateOrders() {
        int i = 0;
        itemsList = itemsRepo.findAll();
        while (i < ordersNumber) {
            i++;
            Orders order = entityGenerator.generateOrder();
            for (int j = 0; j < random.nextInt(3); j++) {
                Items item = itemsList.get(random.nextInt(itemsList.size()));
                order.addItem(item);
                item.addOrder(order);
                order.setTotalPrice(order.getTotalPrice() + item.getPrice());
            }
            ordersRepo.save(order);
            if (i % batchSize == 0) {
                ordersRepo.flush();
            }
        }
        ordersRepo.flush();
    }

    private void generateMothCpuCompat() {
        motherboardsList = motherboardsRepo.findAll();
        cpusList = cpusRepo.findAll();
        for (Motherboards motherboard : motherboardsList) {
            for (Cpus cpu : cpusList) {
                try{
                    if (motherboard.getSocketId()
                        .equals(cpu.getSocketId())
                        && motherboard.getMaxRamFreqId()
                        .equals(cpu.getMaxRamFreqId())) {
                        motherboard.addCpu(cpu);
                        cpu.addMotherboard(motherboard);
                    }
                } catch (NullPointerException e) {
                    System.out.println(cpu.getName());
                    System.out.println(motherboard.getName());
                }

            }
        }
    }
}