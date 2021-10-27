package com.example.SuccessCadets.logics;

import com.example.SuccessCadets.faculty.Course;
import com.example.SuccessCadets.servise.GoogleSheetsServiceImpl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Start {
    List<Course> course =  new ArrayList<>();



    public void initCourse() throws GeneralSecurityException, IOException {
        GoogleSheetsServiceImpl googleSheetsService = new GoogleSheetsServiceImpl();


    }
}
