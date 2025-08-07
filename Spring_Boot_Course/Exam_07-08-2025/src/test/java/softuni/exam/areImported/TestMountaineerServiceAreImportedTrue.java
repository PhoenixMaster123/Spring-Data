package softuni.exam.areImported;
//TestMountaineerServiceAreImportedTrue

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
public class TestMountaineerServiceAreImportedTrue {

    @InjectMocks
    private MountaineerServiceImpl astronomerService;
    @Mock
    private MountaineerRepository mockMountaineerRepository;

    @Test
    void areImportedShouldReturnTrue() {
        Mockito.when(mockMountaineerRepository.count()).thenReturn(1L);
        Assertions.assertTrue(astronomerService.areImported());
    }
}