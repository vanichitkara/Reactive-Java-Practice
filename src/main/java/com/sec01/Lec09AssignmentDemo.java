package com.sec01;

import com.Assignments.Assignment01FileService_CourseSolution;
import com.courseUtil.Util;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        Assignment01FileService_CourseSolution.read("File1.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
        Assignment01FileService_CourseSolution.write("File3.txt", "This is my file 3")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
        Assignment01FileService_CourseSolution.delete("File3.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }
}
