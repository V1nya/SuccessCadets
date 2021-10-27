package com.example.SuccessCadets.servise;

import com.example.SuccessCadets.faculty.Course;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface GoogleSheetsService {
    Course getSpreadsheetValues() throws IOException, GeneralSecurityException;


}
