package mksnkv.nets.utilities;

import lombok.AllArgsConstructor;
import mksnkv.nets.entities.*;
import mksnkv.nets.repos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


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
    private List<Configurations> configurationsList;
    private List<Orders> ordersList;


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
                     DataConfig cfg) {
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
        this.cpusNumber = cfg.getCpusNumber();
        this.ramsNumber = cfg.getRamsNumber();
        this.gpusNumber = cfg.getGpusNumber();
        this.psusNumber = cfg.getPsusNumber();
        this.disksNumber = cfg.getDisksNumber();
        this.casesNumber = cfg.getCasesNumber();
        this.motherboardsNumber = cfg.getMotherboardsNumber();
        this.configurationsNumber = cfg.getConfigurationsNumber();
        this.cpuVendorsNumber = cfg.getCpuVendorsNumber();
        this.gpuVendorsNumber = cfg.getGpuVendorsNumber();
        this.psuVendorsNumber = cfg.getPsuVendorsNumber();
        this.ramVendorsNumber = cfg.getRamVendorsNumber();
        this.ramVersionsNumber = cfg.getRamVersionsNumber();
        this.ramFreqsNumber = cfg.getRamFreqsNumber();
        this.motherboardVendorsNumber = cfg.getMotherboardVendorsNumber();
        this.diskVendorsNumber = cfg.getDiskVendorsNumber();
        this.socketsNumber = cfg.getSocketsNumber();
        this.videoInterfacesNumber = cfg.getVideoInterfacesNumber();
        this.diskInterfacesNumber = cfg.getDiskInterfacesNumber();
        this.ordersNumber = cfg.getOrdersNumber();
        this.videoInterfacesList = new ArrayList<>();
        this.socketsList = new ArrayList<>();
        this.ramFreqsList = new ArrayList<>();
        this.ramVersionsList = new ArrayList<>();
        this.psusList = new ArrayList<>();
        this.ramVendorsList = new ArrayList<>();
        this.ramsList = new ArrayList<>();
        this.gpuVendorsList = new ArrayList<>();
        this.gpusList = new ArrayList<>();
        this.cpuVendorsList = new ArrayList<>();
        this.cpusList = new ArrayList<>();
        this.psuVendorsList = new ArrayList<>();
        this.casesList = new ArrayList<>();
        this.diskInterfacesList = new ArrayList<>();
        this.diskVendorsList = new ArrayList<>();
        this.disksList = new ArrayList<>();
        this.motherboardVendorsList = new ArrayList<>();
        this.motherboardsList = new ArrayList<>();
        this.itemsList = new ArrayList<>();
        this.configurationsList = new ArrayList<>();
        this.ordersList = new ArrayList<>();
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
        generateOrders();
        long end = System.currentTimeMillis();
        long elapsed = end - begin;
        System.out.println(String.format("%d sec",
            TimeUnit.MILLISECONDS.toSeconds(elapsed)
        ));
    }


    void generateRamVersions() {
        int i = 0;
        while (i < ramVersionsNumber) {
            i++;

            ramVersionsList.add(entityGenerator.generateRamVersion());

        }
        ramVersionsRepo.saveAll(ramVersionsList);
    }


    void generateRamFreqs() {
        int i = 0;
        while (i < ramFreqsNumber) {
            i++;

            RamFreqs ramFreq = entityGenerator.generateRamFreq();
            if (!ramFreqsList.contains(ramFreq)) {
                ramFreqsList.add(ramFreq);
            }

        }
        ramFreqsRepo.saveAll(ramFreqsList);
    }


    void generateRamVendors() {
        int i = 0;
        while (i < ramVendorsNumber) {
            i++;
            ramVendorsList.add(entityGenerator.generateRamVendor());
        }
        ramVendorsRepo.saveAll(ramVendorsList);
    }


    void generateRams() {
        int i = 0;
        while (i < ramsNumber) {
            i++;

            Rams ram = entityGenerator.generateRam();
            RamFreqs ramFreq = ramFreqsList.get(random.nextInt(ramFreqsList.size()));
            RamVersions ramVersion = ramVersionsList.get(random.nextInt(ramVersionsList.size()));
            RamVendors ramVendor = ramVendorsList.get(random.nextInt(ramVendorsList.size()));
            ram.setRamFreqId(ramFreq);
            ram.setVersionId(ramVersion);
            ram.setVendorId(ramVendor);

            Items item = entityGenerator.generateItem();
            ram.setItem(item);

            itemsList.add(item);
            ramsList.add(ram);

        }
        itemsRepo.saveAll(itemsList);
        ramsRepo.saveAll(ramsList);
    }


    void generateGpuVendors() {
        int i = 0;
        while (i < gpuVendorsNumber) {
            i++;

            gpuVendorsList.add(entityGenerator.generateGpuVendor());

        }
        gpuVendorsRepo.saveAll(gpuVendorsList);
    }


    void generateVideoInterfaces() {
        int i = 0;
        while (i < videoInterfacesNumber) {
            i++;

            videoInterfacesList.add(entityGenerator.generateVideoInterface());
        }
        videoInterfacesRepo.saveAll(videoInterfacesList);
    }


    void generateGpus() {
        gpuVendorsList = gpuVendorsRepo.findAll();
        videoInterfacesList = videoInterfacesRepo.findAll();
        List<Items> tempItems = new ArrayList<>();
        int i = 0;
        while (i < gpusNumber) {
            i++;

            Gpus gpu = entityGenerator.generateGpu();
            GpuVendors vendor = gpuVendorsList.get(random.nextInt(gpuVendorsList.size()));
            VideoInterfaces videoInterface = videoInterfacesList.get(random.nextInt(videoInterfacesList.size()));
            gpu.setVendorId(vendor);
            gpu.setVideoInterfaceId(videoInterface);

            Items item = entityGenerator.generateItem();
            gpu.setItem(item);

            gpusList.add(gpu);
            tempItems.add(item);
        }
        gpusRepo.saveAll(gpusList);
        itemsRepo.saveAll(tempItems);
    }


    void generateCpuVendors() {
        int i = 0;
        while (i < cpuVendorsNumber) {
            i++;
            cpuVendorsList.add(entityGenerator.generateCpuVendor());
        }
        cpuVendorsRepo.saveAll(cpuVendorsList);
    }


    void generateSockets() {
        int i = 0;
        while (i < socketsNumber) {
            i++;
            socketsList.add(entityGenerator.generateSocket());
        }
        socketsRepo.saveAll(socketsList);
    }


    void generateCpus() {
        cpuVendorsList = cpuVendorsRepo.findAll();
        socketsList = socketsRepo.findAll();
        int i = 0;
        List<Items> tempItems = new ArrayList<>();
        while (i < cpusNumber) {
            i++;

            Cpus cpu = entityGenerator.generateCpu();
            RamFreqs ramFreq = ramFreqsList.get(random.nextInt(ramFreqsList.size()));
            CpuVendors vendor = cpuVendorsList.get(random.nextInt(cpuVendorsList.size()));
            Sockets socket = socketsList.get(random.nextInt(socketsList.size()));
            cpu.setMaxRamFreqId(ramFreq);
            cpu.setVendorId(vendor);
            cpu.setSocketId(socket);

            Items item = entityGenerator.generateItem();
            cpu.setItem(item);

            cpusList.add(cpu);
            tempItems.add(item);

        }
        cpusRepo.saveAll(cpusList);
        itemsRepo.saveAll(tempItems);
    }


    void generatePsuVendors() {
        int i = 0;
        while (i < psuVendorsNumber) {
            i++;
            PsuVendors psuVendor = entityGenerator.generatePsuVendor();
            psuVendorsList.add(psuVendor);
        }
        psuVendorsRepo.saveAll(psuVendorsList);
    }


    void generatePsus() {
        psuVendorsList = psuVendorsRepo.findAll();
        List<Items> tempItems = new ArrayList<>();
        int i = 0;
        while (i < psusNumber) {
            i++;

            Psus psu = entityGenerator.generatePsu();
            psu.setVendorId(psuVendorsList.get(random.nextInt(psuVendorsList.size())));

            Items item = entityGenerator.generateItem();
            psu.setItem(item);

            psusList.add(psu);
            tempItems.add(item);

        }
        psusRepo.saveAll(psusList);
        itemsRepo.saveAll(tempItems);
    }


    void generateCases() {
        List<Items> tempItems = new ArrayList<>();
        int i = 0;
        while (i < casesNumber) {
            i++;

            Cases caseObj = entityGenerator.generateCase();
            casesList.add(caseObj);
            Items item = entityGenerator.generateItem();
            caseObj.setItem(item);
            tempItems.add(item);
        }
        casesRepo.saveAll(casesList);
        itemsRepo.saveAll(tempItems);
    }


    void generateDiskInterfaces() {
        int i = 0;
        while (i < diskInterfacesNumber) {
            i++;
            DiskInterfaces diskInterfaces = entityGenerator.generateDiskInterface();
            diskInterfacesList.add(diskInterfaces);
        }
        diskInterfacesRepo.saveAll(diskInterfacesList);
    }


    void generateDiskVendors() {
        int i = 0;
        while (i < diskVendorsNumber) {
            i++;
            diskVendorsList.add(entityGenerator.generateDiskVendor());
        }
        diskVendorsRepo.saveAll(diskVendorsList);
    }


    void generateDisks() {
        List<Items> tempItems = new ArrayList<>();
        int i = 0;
        while (i < disksNumber) {
            i++;

            Disks disk = entityGenerator.generateDisk();
            disk.setVendorId(diskVendorsList.get(random.nextInt(diskVendorsList.size())));
            disk.setInterfaceId(diskInterfacesList.get(random.nextInt(diskInterfacesList.size())));

            Items item = entityGenerator.generateItem();
            disk.setItem(item);

            tempItems.add(item);
            disksList.add(disk);
        }
        disksRepo.saveAll(disksList);
        itemsRepo.saveAll(tempItems);
    }


    void generateMotherboardVendors() {
        int i = 0;
        while (i < motherboardVendorsNumber) {
            i++;
            motherboardVendorsList.add(entityGenerator.generateMotherboardVendor());
        }
        motherboardVendorsRepo.saveAll(motherboardVendorsList);
    }


    void generateMotherboards() {
        List<Items> tempItems = new ArrayList<>();
        int i = 0;
        while (i < motherboardsNumber) {
            i++;
            Motherboards motherboard = entityGenerator.generateMotherboard();
            motherboard.setVendorId(motherboardVendorsList.get(random.nextInt(motherboardVendorsList.size())));
            motherboard.setDiskInterfaceId(diskInterfacesList.get(random.nextInt(diskInterfacesList.size())));
            motherboard.setMaxRamFreqId(ramFreqsList.get(random.nextInt(ramFreqsList.size())));
            motherboard.setRamVersionId(ramVersionsList.get(random.nextInt(ramVendorsList.size())));
            motherboard.setSocketId(socketsList.get(random.nextInt(socketsList.size())));
            motherboard.setVideoInterfaceId(videoInterfacesList.get(random.nextInt(videoInterfacesList.size())));

            Items item = entityGenerator.generateItem();
            motherboard.setItem(item);

            tempItems.add(item);
            motherboardsList.add(motherboard);
        }
        motherboardsRepo.saveAll(motherboardsList);
        itemsRepo.saveAll(tempItems);
    }


    void generateConfigurations() {
        List<Items> tempItems = new ArrayList<>();
        int i = 0;
        while (i < configurationsNumber) {
            i++;

            Configurations configuration = entityGenerator.generateConfiguration();
            Cpus cpu = cpusList.get(random.nextInt(cpusList.size()));
            Gpus gpu = gpusList.get(random.nextInt(gpusList.size()));
            Psus psu = psusList.get(random.nextInt(psusList.size()));
            Cases caseObj = casesList.get(random.nextInt(casesList.size()));
            Motherboards motherboard = motherboardsList.get(random.nextInt(motherboardsList.size()));
            Disks disk = disksList.get(random.nextInt(disksList.size()));
            Rams ram = ramsList.get(random.nextInt(ramsList.size()));
            configuration.setCpuId(cpu.getItem());
            configuration.setGpuId(gpu.getItem());
            configuration.setPsuId(psu.getItem());
            configuration.setCaseId(caseObj.getItem());
            configuration.setMotherboardId(motherboard.getItem());
            configuration.setDiskId(disk.getItem());
            configuration.setRamId(ram.getItem());

            Items item = entityGenerator.generateItem();
            tempItems.add(item);

            configuration.setItem(item);
            configurationsList.add(configuration);
        }
        configurationsRepo.saveAll(configurationsList);
        itemsRepo.saveAll(tempItems);
    }


    void generateOrders() {
        int i = 0;
        while (i < ordersNumber) {
            i++;
            Orders order = entityGenerator.generateOrder();
            for (int j = 0; j < random.nextInt(3); j++) {
                Items item = itemsList.get(random.nextInt(itemsList.size()));
                order.addItem(item);
                item.addOrder(order);
                order.setTotalPrice(order.getTotalPrice() + item.getPrice());
            }
            ordersList.add(order);
        }
        ordersRepo.saveAll(ordersList);
    }
}