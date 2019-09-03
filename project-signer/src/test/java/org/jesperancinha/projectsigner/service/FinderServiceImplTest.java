package org.jesperancinha.projectsigner.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.jesperancinha.projectsigner.inteface.FinderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Slf4j
@ExtendWith(MockitoExtension.class)
class FinderServiceImplTest {

    @InjectMocks
    private FinderService finderService = new FinderServiceImpl();

    @TempDir
    public static Path tempDirectory;

    @BeforeEach
    public void setUp() throws IOException {
        final URL resource = getClass().getResource("/.");
        copyFolder(Path.of(resource.getPath()), tempDirectory);
    }

    private void copyFolder(Path src, Path dest) throws IOException {
        Files.walk(src)
                .forEach(source -> copy(source, dest.resolve(src.relativize(source))));
    }

    private void copy(Path src, Path dest) {
        try {
            FileUtils.deleteDirectory(dest.toFile());
            Files.copy(src, dest, REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("Error found copying {} to {}", src, dest, e);
        }
    }

    @Test
    void testIterateThroughFilesAndFolders() throws IOException {
        finderService.iterateThroughFilesAndFolders(tempDirectory);
    }
}