package softuni.exam.areImported;
//TestMountaineerServiceAreImportedFalse

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.repository.MountaineerRepository;
import softuni.exam.service.impl.MountaineerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestMountaineerServiceAreImportedFalse {


    @InjectMocks
    private MountaineerServiceImpl astronomerService;
    @Mock
    private MountaineerRepository mockMountaineerRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockMountaineerRepository.count()).thenReturn(0L);
        Assertions.assertFalse(astronomerService.areImported());
    }
}