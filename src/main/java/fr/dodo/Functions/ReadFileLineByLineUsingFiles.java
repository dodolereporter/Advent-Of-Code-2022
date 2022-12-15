package fr.dodo.Functions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileLineByLineUsingFiles {
    public static List<String> getCalorieLine(String path) throws IOException {

            List<String> allLines = Files.readAllLines(Paths.get(path));
            return allLines;
    }
}