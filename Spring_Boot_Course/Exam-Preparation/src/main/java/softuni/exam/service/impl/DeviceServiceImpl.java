package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceInputDto;
import softuni.exam.models.dto.DevicesImportDto;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final SaleService saleService;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, SaleService saleService) {
        this.deviceRepository = deviceRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.saleService = saleService;
    }

    @Override
    public boolean areImported() {
        return deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        Path path = Path.of("src/main/resources/files/xml/devices.xml");
        return Files.readString(path);
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        DevicesImportDto importDtos = xmlParser.fromFile(readDevicesFromFile(), DevicesImportDto.class);

        StringBuilder sb = new StringBuilder();

        for (DeviceInputDto deviceInputDto : importDtos.getInput()) {
            Device createdDevice = create(deviceInputDto);

            if(createdDevice == null) {
                sb.append("Invalid device").append(System.lineSeparator());
            } else {
                sb.append(String.format("Successfully imported device of type %s with brand %s",
                                createdDevice.getDeviceType(),
                                createdDevice.getBrand()))
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private Device create(DeviceInputDto deviceInputDto) {
        if (!validationUtil.isValid(deviceInputDto)) {
            return null;
        }

        try {
            Device device = modelMapper.map(deviceInputDto, Device.class);

            Long saleId = deviceInputDto.getSale();

            if (saleId != null) {
                Sale sale = saleService.getReferenceById(saleId);
                device.setSale_id(sale);
            }

            deviceRepository.save(device);
            return device;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportDevices() {
        List<Device> devices = deviceRepository.findExportable(DeviceType.SMART_PHONE, 1000.0, 128);

        StringBuilder sb = new StringBuilder();

        for(Device device : devices) {
            sb.append(String.format("Device brand: %s", device.getBrand())).append(System.lineSeparator());
            sb.append(String.format("   *Model: %s", device.getModel())).append(System.lineSeparator());
            sb.append(String.format("   **Storage: %d", device.getStorage())).append(System.lineSeparator());
            sb.append(String.format(Locale.US,"   ***Price: %.2f", device.getPrice())).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
