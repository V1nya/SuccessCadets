package com.example.SuccessCadets.servise;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface GoogleSheetsService {
    void getSpreadsheetValues() throws IOException, GeneralSecurityException;
    String getSheetValues() throws IOException, GeneralSecurityException;

}
