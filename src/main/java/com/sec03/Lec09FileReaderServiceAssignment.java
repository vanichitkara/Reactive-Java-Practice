package com.sec03;

import com.Assignments.Assignment03FileReaderService_CourseSolution;
import com.courseUtil.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        Assignment03FileReaderService_CourseSolution readerService = new Assignment03FileReaderService_CourseSolution();
        Path path = Paths.get("src/main/resources/Assignment03/File1.txt");
        readerService
                .read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0,10);
                    if(integer>8){
                        throw new RuntimeException("oops");
                    }
                    return s;
                })
                .take(5)
                .subscribe(Util.subscriber());
    }
}
