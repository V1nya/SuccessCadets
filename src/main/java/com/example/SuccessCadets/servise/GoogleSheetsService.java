package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.faculty.Course;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface GoogleSheetsService {
    List<Course> getSpreadsheetValues() throws IOException, GeneralSecurityException;


}
