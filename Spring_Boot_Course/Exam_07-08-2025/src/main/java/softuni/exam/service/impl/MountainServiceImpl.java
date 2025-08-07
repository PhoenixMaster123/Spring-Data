package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MountainInputDto;
import softuni.exam.models.entity.Mountain;
import softuni.exam.repository.MountainRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.MountainService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MountainServiceImpl implements MountainService {

    private final CountryService countryService;
    private final MountainRepository repository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public MountainServiceImpl(CountryService countryService, MountainRepository repository, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.countryService = countryService;
        this.repository = repository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readMountainsFileContent() throws IOException {
        Path path = Path.of("src/main/resources/files/json/mountains.json");
        return Files.readString(path);
    }

    @Override
    public String importMountains() throws IOException {
        String json = readMountainsFileContent();
        MountainInputDto[] inputDtos = gson.fromJson(json, MountainInputDto[].class);

        StringBuilder sb = new StringBuilder();

        for (MountainInputDto mountainInputDto : inputDtos) {
            Mountain createdMountain = create(mountainInputDto);

            if (createdMountain != null) {
                sb.append(String.format("Successfully imported mountain %s", createdMountain.getName()))
                  .append(System.lineSeparator());
            } else {
                sb.append("Invalid mountain").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    public Mountain create(MountainInputDto inputDto) {
        if (!validationUtil.isValid(inputDto)) {
            return null;
        }
        try {
            Mountain mountain = mapper.map(inputDto, Mountain.class);

            Long countryId = inputDto.getCountry_id();

            if(countryId != null) {
                mountain.setCountry(countryService.getReferenceById(countryId));
            }

            repository.save(mountain);
            return mountain;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportMountains() {
        List<Mountain> mountainList = repository.exportMountains();

        StringBuilder sb = new StringBuilder();

        for(Mountain mountain : mountainList) {
            sb.append(String.format("Mountain: %s", mountain.getName())).append(System.lineSeparator());
            sb.append(String.format("   *Located in: %s", mountain.getCountry())).append(System.lineSeparator());
            sb.append(String.format("   **Elevation: %d", mountain.getElevation())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Mountain getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }
}
