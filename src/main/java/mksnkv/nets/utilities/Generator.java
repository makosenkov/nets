package mksnkv.nets.utilities;

import lombok.AllArgsConstructor;
import mksnkv.nets.entities.Rams;
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
    private final SocketsRepo socketsRepo;
    private final VideoInterfacesRepo videoInterfacesRepo;
    private final MotherboardsRepo motherboardsRepo;
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

    public void generate() {
        generateRamVersions();
        generateRamFreqs();
        generateRamVendors();
        generateRams();
    }

    public void generateRamVersions() {
        for (int i = 0; i < ramVersionsNumber; i++) {
            ramVersionsRepo.saveAndFlush(entityGenerator.generateRamVersion(i));
        }
    }

    public void generateRamFreqs() {
        for (int i = 0; i < ramFreqsNumber; i++) {
            ramFreqsRepo.saveAndFlush(entityGenerator.generateRamFreq());
        }
    }

    public void generateRamVendors() {
        for (int i = 0; i < ramVendorsNumber; i++) {
            ramVendorsRepo.saveAndFlush(entityGenerator.generateRamVendor());
        }
    }

    public void generateRams() {
        for (int i = 0; i < ramsNumber; i++) {
            Rams ram = ramsRepo.saveAndFlush(entityGenerator.generateRam());
            ram.setRamFreqId(ramFreqsRepo.getOne((long) random.nextInt(ramFreqsNumber)));
            ram.setVersionId(ramVersionsRepo.getOne((long) random.nextInt(ramVersionsNumber)));
            ram.setVendorId(ramVendorsRepo.getOne((long) random.nextInt(ramVendorsNumber)));
        }
    }
}