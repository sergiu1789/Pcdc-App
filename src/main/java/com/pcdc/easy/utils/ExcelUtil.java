package com.pcdc.easy.utils;

import com.pcdc.easy.model.App.Pcdc;
import lombok.extern.java.Log;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
    public static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERS = {"id", "ipAddress", "macAddress", "nomePc", "dominio", "stato", "commessa", "sede", "dataUltimoAggiornamento", "oraUltimoAggiornamento", "giorniSpento", "versionePcdc"};
    static String SHEET = "Sheet1";

    public static boolean hasExcellFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Pcdc> excelToPcdc(InputStream input) {
        try {
            //deschide fisier
            Workbook workbook = new XSSFWorkbook(input);

            //deschide sheet  fisier
            Sheet sheet = workbook.getSheet(SHEET);
            //itereaza printre randuri
            Iterator<Row> rows = sheet.iterator();

            List<Pcdc> pcdcList = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                log.info("analizarea randurilor ", rowNumber);
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Pcdc newPcdc = new Pcdc();
                for (int i = 0; i < 20; i++) {

                    Cell currentCell = currentRow.getCell(i);
                    switch (i) {
//                        case 0 :
//                            newPcdc.setId((long) currentCell.getNumericCellValue());
//                            break;

                        case 1:
                            newPcdc.setCommessa(currentCell.getStringCellValue());
                            break;
                        case 2:
                            newPcdc.setMacAddress(currentCell.getStringCellValue());
                            break;
                        case 3:
                            newPcdc.setNomePc(currentCell.getStringCellValue());
                            break;
                        case 4:
                            newPcdc.setDominio(currentCell.getStringCellValue());
                            break;
                        case 5:
                            newPcdc.setStato(currentCell.getStringCellValue());
                            break;
                        case 6:
                            newPcdc.setIpAddress(currentCell.getStringCellValue());
                            break;
                        case 7:
                            newPcdc.setSede(currentCell.getStringCellValue());
                            break;
                        case 8:
                            newPcdc.setDataUltimoAggiornamento(currentCell.getDateCellValue());
                            break;
                        case 9:
                            newPcdc.setOraUltimoAggiornamento(currentCell.getDateCellValue());
                            break;
//                        case 10:
//                            newPcdc.setGiorniSpento((int) currentCell.getNumericCellValue());
//                            break;
                        case 10:
                            newPcdc.setVersionePcdc(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
                pcdcList.add(newPcdc);
                log.info("sfarsitu cautari", rowNumber);
                rowNumber++;

            }
            workbook.close();

            return pcdcList;


        } catch (IOException e) {
            throw new RuntimeException("nu sa cautat in file " + e.getMessage());
        }
    }
}





