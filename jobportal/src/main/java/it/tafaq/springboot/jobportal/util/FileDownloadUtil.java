package it.tafaq.springboot.jobportal.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileDownloadUtil {

    private Path foundFile;

    public Resource getFileAsResource(String downloadDir, String fileName) {
        Path path = Paths.get(downloadDir);

        try (Stream<Path> paths = Files.list(path)) {
            paths.forEach(file -> {
                if (file.getFileName().toString().startsWith(fileName)) {
                    foundFile = file;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (foundFile != null) {
            try {
                return new UrlResource(foundFile.toUri());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}