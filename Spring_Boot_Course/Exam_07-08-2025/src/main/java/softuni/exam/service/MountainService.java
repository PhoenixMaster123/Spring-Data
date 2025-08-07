package softuni.exam.service;

import softuni.exam.models.entity.Mountain;

import java.io.IOException;

public interface MountainService {

    boolean areImported();

    String readMountainsFileContent() throws IOException;

    String importMountains() throws IOException;

    String exportMountains();

    Mountain getReferenceById(Long id);
}
