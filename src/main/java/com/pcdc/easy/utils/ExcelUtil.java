package com.pcdc.easy.utils;

import com.pcdc.easy.model.App.Pcdc;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
   public static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERS = {"id","ipAddress","macAddress","nomePc","dominio","stato","commessa","sede","dataUltimoAggiornamento","oraUltimoAggiornamento","giorniSpento","versionePcdc"};
    static String SHEET= "Sheet1";

    public static boolean hasExcellFile (MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Pcdc> excelToPcdc(InputStream input) {

        try {
            Workbook workbook = new XSSFWorkbook(input);

            Sheet sheet  = workbook.getSheet(SHEET);

            Iterator<Row> rows = sheet.iterator();

           List<Pcdc> pcdcList = new ArrayList<>();

           int rowNumber = 0 ;
           while (rows.hasNext()) {
               Row currentRow = rows.next();
               if (rowNumber == 0 ) {
                   rowNumber++;
               }
               Iterator<Cell> cellIterator = currentRow.iterator();
               Pcdc newPcdc = new Pcdc();
               int cellId = 0 ;
               while (rows.hasNext()) {
                   log.info("cautare prin celule excell");
                   Cell currentCell = cellIterator.next();
                   switch (cellId) {
                       case 0 :
                           newPcdc.setId((long) currentCell.getNumericCellValue());
                       case 1 :
                           newPcdc.setIpAddress(currentCell.getStringCellValue());
                       case 2 :
                           newPcdc.setMacAddress(currentCell.getStringCellValue());
                       case 3 :
                           newPcdc.setNomePc(currentCell.getStringCellValue());
                       case 4 :
                           newPcdc.setDominio(currentCell.getStringCellValue());
                       case 5:
                           newPcdc.setStato(currentCell.getStringCellValue());
                       case 6 :
                           newPcdc.setCommessa(currentCell.getStringCellValue());
                       case 7 :
                           newPcdc.setSede(currentCell.getStringCellValue());
                       case 8 :
                           newPcdc.setDataUltimoAggiornamento(currentCell.getDateCellValue());
                       case 9 :
                           newPcdc.setOraUltimoAggiornamento(currentCell.getDateCellValue());
                       case 10 :
                           newPcdc.setGiorniSpento((int) currentCell.getNumericCellValue());
                       case 11 :
                           newPcdc.setVersionePcdc(currentCell.getStringCellValue());
                   }
                   cellId++;
               }
               pcdcList.add(newPcdc);
               log.info("sfarsitu cautari");

           }
           workbook.close();

           return pcdcList;

        }
        catch (IOException e) {
             throw  new RuntimeException("nu sa cautat in file " + e.getMessage());
        }

    }

}
