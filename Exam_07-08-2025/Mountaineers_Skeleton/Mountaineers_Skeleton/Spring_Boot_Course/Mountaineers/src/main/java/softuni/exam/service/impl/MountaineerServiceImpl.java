package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MountaineerImportDto;
import softuni.exam.models.dto.MountaineerInputDto;
import softuni.exam.models.entity.Mountaineer;
import softuni.exam.repository.MountaineerRepository;
import softuni.exam.service.MountainService;
import softuni.exam.service.MountaineerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MountaineerServiceImpl implements MountaineerService {
    private final MountaineerRepository repository;

    private final MountainService mountainService;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;

    @Autowired
    public MountaineerServiceImpl(MountaineerRepository repository, MountainService mountainService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.repository = repository;
        this.mountainService = mountainService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readMountaineersFromFile() throws IOException {
        Path path = Path.of("src/main/resources/files/xml/mountaineers.xml");
        return Files.readString(path);
    }

    @Override
    public String importMountaineers() throws IOException, JAXBException {
        MountaineerImportDto importDtos = xmlParser.fromFile(readMountaineersFromFile(), MountaineerImportDto.class);

        StringBuilder sb = new StringBuilder();

        for(MountaineerInputDto inputDto : importDtos.getMountaineers()) {
            Mountaineer createdMountaineer = create(inputDto);

            if (createdMountaineer != null) {
                sb.append(String.format("Successfully imported mountaineer %s %s",
                        createdMountaineer.getFirstName(),
                        createdMountaineer.getLastName()))
                  .append(System.lineSeparator());
            } else {
                sb.append("Invalid mountaineer").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    public Mountaineer create(MountaineerInputDto mountaineerInputDto) {
        if (!validationUtil.isValid(mountaineerInputDto)) {
            return null;
        }

        try {
            Mountaineer mountaineer = modelMapper.map(mountaineerInputDto, Mountaineer.class);

            Long mountainId = mountaineerInputDto.getMountain_id();

            if(mountainId != null) {
                mountaineer.setMountain(mountainService.getReferenceById(mountainId));
            }

            repository.save(mountaineer);
            return mountaineer;
        } catch (Exception e) {
            return null;
        }
    }


}
