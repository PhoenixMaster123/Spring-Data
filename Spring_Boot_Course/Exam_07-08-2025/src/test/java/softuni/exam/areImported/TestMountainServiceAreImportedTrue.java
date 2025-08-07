package softuni.exam.areImported;
//TestMountainServiceAreImportedTrue

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
public class TestMountainServiceAreImportedTrue {

    @InjectMocks
    private MountainServiceImpl volcanoService;
    @Mock
    private MountainRepository mockMountainRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockMountainRepository.count()).thenReturn(1L);
        Assertions.assertTrue(volcanoService.areImported());
    }
}