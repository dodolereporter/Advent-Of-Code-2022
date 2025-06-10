package fr.dodo.Functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileLineByLineUsingFiles {
    public static List<String> getCalorieLine(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
