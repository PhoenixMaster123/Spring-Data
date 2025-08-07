package softuni.exam.areImported;
//TestMountainServiceAreImportedFalse

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.MountainRepository;
import softuni.exam.service.impl.MountainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestMountainServiceAreImportedFalse {

    @InjectMocks
    private MountainServiceImpl volcanoService;
    @Mock
    private MountainRepository mockMountainRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockMountainRepository.count()).thenReturn(0L);
        Assertions.assertFalse(volcanoService.areImported());
    }
}