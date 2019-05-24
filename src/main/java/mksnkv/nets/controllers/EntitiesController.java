package mksnkv.nets.controllers;

import lombok.AllArgsConstructor;
import mksnkv.nets.entities.Cpus;
import mksnkv.nets.entities.GpuVendors;
import mksnkv.nets.entities.Rams;
import mksnkv.nets.repos.*;
import mksnkv.nets.utilities.Generator;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@AllArgsConstructor
@Configuration
public class EntitiesController {

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


    @GetMapping("/rams")
    public List<Rams> listRams() {
        return ramsRepo.findAll();
    }

    @GetMapping("/cpus")
    public List<Cpus> listCpus() {
        return cpusRepo.findAll();
    }

    @GetMapping("/gpuvendors")
    public List<GpuVendors> listGpuVendors() {
        return gpuVendorsRepo.findAll();
    }

    @GetMapping("/generator")
    public String generateData() {
        generate();
        return "method generate() was called, wait several minutes to see the data";
    }

    public void generate() {
        Generator generator = new Generator(itemsRepo,
            cpuVendorsRepo,
            gpuVendorsRepo,
            ramVendorsRepo,
            ramVersionsRepo,
            ramFreqsRepo,
            psuVendorsRepo,
            diskVendorsRepo,
            diskInterfacesRepo,
            socketsRepo,
            videoInterfacesRepo,
            motherboardsRepo,
            motherboardVendorsRepo,
            cpusRepo,
            gpusRepo,
            psusRepo,
            ramsRepo,
            casesRepo,
            disksRepo,
            configurationsRepo,
            ordersRepo,
            110,
            150,
            200,
            120,
            120,
            120,
            100,
            100,
            10,
            10,
            10,
            50,
            50,
            5,
            50,
            50,
            5,
            10,
            20,
            20
        );
        generator.generate();
    }

}
