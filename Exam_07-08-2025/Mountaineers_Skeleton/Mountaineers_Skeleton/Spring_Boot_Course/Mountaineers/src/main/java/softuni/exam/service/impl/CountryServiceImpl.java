package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryInputDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    private final Gson gson;

    private final ValidationUtil validationUtil;
    private final ModelMapper mapper;

    @Autowired
    public CountryServiceImpl(CountryRepository repository, Gson gson, ValidationUtil validationUtil, ModelMapper mapper) {
        this.repository = repository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        Path path = Path.of("src/main/resources/files/json/countries.json");
        return Files.readString(path);
    }

    @Override
    public String importCountries() throws IOException {
        CountryInputDto[] inputDtos = gson.fromJson(readCountriesFromFile(), CountryInputDto[].class);

        StringBuilder sb = new StringBuilder();

        for (CountryInputDto countryInputDto : inputDtos) {
            Country createdCountry = create(countryInputDto);

            if (createdCountry != null) {
                sb.append(String.format("Successfully imported country %s - %s", createdCountry.getName(), createdCountry.getCapital())).append(System.lineSeparator());
            } else {
                sb.append("Invalid country").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public Country getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    private Country create(CountryInputDto inputDto) {
        if (!validationUtil.isValid(inputDto)) {
            return null;
        }

        try {
            Country country = mapper.map(inputDto, Country.class);

            repository.save(country);
            return country;
        } catch (Exception e) {
            return null;
        }
    }
}
