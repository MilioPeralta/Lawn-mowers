package main.java.com.blablacar.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class to read from a file
 * <p>
 * Created by Milio PERALTA on 12/02/2017.
 */
public class ReaderUtils {

    /**
     * Path from where to read the file
     */
    private String filePath;

    public ReaderUtils(String filePath) {
        if (filePath != null && !filePath.isEmpty() && Files.isRegularFile(new File(filePath).toPath())) {
            this.filePath = filePath;
            return;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Reads the file and returns a {@link List<String>} representing the file's lines
     *
     * @return lines
     */
    public List<String> read() {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            lines = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
