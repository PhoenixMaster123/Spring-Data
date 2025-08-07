package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SaleInputDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SellerService sellerService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SellerService sellerService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.saleRepository = saleRepository;
        this.sellerService = sellerService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        Path path = Path.of("src/main/resources/files/json/sales.json");
        return Files.readString(path);
    }

    @Override
    public String importSales() throws IOException {
        String json = readSalesFileContent();
        SaleInputDto[] inputDtos = gson.fromJson(json, SaleInputDto[].class);

        StringBuilder sb = new StringBuilder();

        for(SaleInputDto saleInputDto : inputDtos) {
            Sale createdSale = create(saleInputDto);

            if (createdSale != null) {
                sb.append(String.format("Successfully imported sale with number %s",
                        createdSale.getNumber())).append(System.lineSeparator());
            } else {
                sb.append("Invalid sale").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public Sale getReferenceById(Long id) {
        return saleRepository.getReferenceById(id);
    }

    private Sale create(SaleInputDto saleInputDto) {
        if (!validationUtil.isValid(saleInputDto)) {
            return null;
        }
        try {
            Sale sale = modelMapper.map(saleInputDto, Sale.class);

            Long sellerId = saleInputDto.getSellerId();

            if(sellerId != null) {
                Seller seller = sellerService.getReferenceById(sellerId);
                sale.setSeller_id(seller);
            }

            saleRepository.save(sale);

            return sale;

        } catch (Exception e) {
            return null;
        }
    }
}
