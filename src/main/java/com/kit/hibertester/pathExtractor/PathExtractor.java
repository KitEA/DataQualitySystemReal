package com.kit.hibertester.pathExtractor;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Eldest on 26.03.2016.
 */
public class PathExtractor {
    private Path getResource(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL url = classLoader.getResource(fileName);
            return Paths.get(url.toURI());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Path myResource(String fileName) {
        return getResource(fileName);
    }

    public Path getPathToFile(String fileName) {
        return myResource(fileName);
    }
}
