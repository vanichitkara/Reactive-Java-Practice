package com.Assignments;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Assignment03FileReaderService_MySolution {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            try {
                String fileContent = Files.readString(Path.of("src/main/resources/Assignment03/File1.txt"));
                synchronousSink.next(fileContent);
                synchronousSink.complete();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })
                .subscribe(Util.subscriber());

    }
}
