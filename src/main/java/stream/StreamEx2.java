package main.java.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) throws IOException {
        Stream<Path> list = Files.list(Path.of("C:\\"));
        Stream<Path> list1 = Files.list(Path.of("C:\\java\\"));
        Stream.concat(list,list1).forEach(System.out::println);

    }
}
