package com.Assignments;


import com.courseUtil.Util;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.Scanner;

public class Assignment01FileService_MySolution {

    // I created the functions correctly but forgot to create publishers by creating Mono classes that
    // will take the normal functions and use the fromSupplier and fromRunnable functions to build the pipeline.
    // I directly built and executed the pipeline by using Mono.just

    public String readFileAndReturnContent(String fileName) {
        String data = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return data;
    }

    protected String createFileAndWriteContent(String fileName) throws IOException {
        FileWriter myWriter = new FileWriter(fileName);
        myWriter.write("Files in Java might be tricky, but it is fun enough!");
        myWriter.close();
        return myWriter.toString();
    }

    public String deleteFile(String fileName){
        File myObj = new File(fileName);
        if (myObj.delete()) {
            return "Deleted the file: " + myObj.getName();
        } else {
            return ("Failed to delete the file.");
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "fileName.txt";
        Assignment01FileService_MySolution assignment01FileServiceMySolution = new Assignment01FileService_MySolution();
        Mono.just(assignment01FileServiceMySolution.createFileAndWriteContent(fileName))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
        Mono.just(assignment01FileServiceMySolution.readFileAndReturnContent(fileName))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
        Mono.just(assignment01FileServiceMySolution.deleteFile(fileName))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }
}
