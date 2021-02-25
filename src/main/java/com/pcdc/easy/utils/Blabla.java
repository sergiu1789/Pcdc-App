//package com.pcdc.easy.utils;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class Blabla {
//    public static final Logger LOG = LoggerFactory.getLogger(ExcelHelper.class);
//    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//
//    static String[] HEADERs = {"id", "codIdentificareMedicament", "denumireComerciala", "denumireComercialaInternationala", "formaFarmaceutica", "concentratie", "firmaTaraProducatoare", "firmaTaraDetinatoare", "clasificareAnatomicaTerapeuticaChimica", "actiuneTerapeutica", "prescriptie", "dataAmbalaj", "ambalaj", "volumAmbalaj", "valabilitateAmbalaj", "bulina", "diez", "stea", "triunghi", "dreptunghi", "dataActualizare"};
//    static String SHEET = "Worksheet";
//
//    public static boolean hasExcelFormat(MultipartFile file) {
//        return TYPE.equals(file.getContentType());
//    }
//
//    public static List<Medicine> excelToMedicine(InputStream is) {
//        try {
//            // deschid workbook
//            Workbook workbook = new XSSFWorkbook(is);
//
//            // extrag sheet
//            Sheet sheet = workbook.getSheet(SHEET);
//            Iterator<Row> rows = sheet.iterator();
//
//            List<Medicine> medicines = new ArrayList<>();
//
//            int rowNumber = 0;
//            while (rows.hasNext()) {
//                LOG.info("Parsing row #{}", rowNumber);
//                Row currentRow = rows.next();
//
//                // skip header :)
//                if (rowNumber == 0) {
//                    rowNumber++;
//                    continue;
//                }
//
//                Medicine medicine = new Medicine();
//                for (int i = 0; i < 20; i++) {
//                    Cell currentCell = currentRow.getCell(i);
//                    switch (i) {
//                        case 0:
//                            medicine.setCodIdentificareMedicament(getCellValueOrDefault(currentCell));
//                            break;
//                        case 1:
//                            medicine.setDenumireComerciala(getCellValueOrDefault(currentCell));
//                            break;
//                        case 2:
//                            medicine.setDenumireComercialaInternationala(getCellValueOrDefault(currentCell));
//                            break;
//                        case 3:
//                            medicine.setFormaFarmaceutica(getCellValueOrDefault(currentCell));
//                            break;
//                        case 4:
//                            medicine.setConcentratie(getCellValueOrDefault(currentCell));
//                            break;
//                        case 5:
//                            medicine.setFirmaTaraProducatoare(getCellValueOrDefault(currentCell));
//                            break;
//                        case 6:
//                            medicine.setFirmaTaraDetinatoare(getCellValueOrDefault(currentCell));
//                            break;
//                        case 7:
//                            medicine.setClasificareAnatomicaTerapeuticaChimica(getCellValueOrDefault(currentCell));
//                            break;
//                        case 8:
//                            medicine.setActiuneTerapeutica(getCellValueOrDefault(currentCell));
//                            break;
//                        case 9:
//                            medicine.setPrescriptie(getCellValueOrDefault(currentCell));
//                            break;
//                        case 10:
//                            medicine.setDataAmbalaj(getCellValueOrDefault(currentCell));
//                            break;
//                        case 11:
//                            medicine.setAmbalaj(getCellValueOrDefault(currentCell));
//                            break;
//                        case 12:
//                            medicine.setVolumAmbalaj(getCellValueOrDefault(currentCell));
//                            break;
//                        case 13:
//                            medicine.setValabilitateAmbalaj(getCellValueOrDefault(currentCell));
//                            break;
//                        case 14:
//                            medicine.setBulina(getCellValueOrDefault(currentCell));
//                            break;
//                        case 15:
//                            medicine.setDiez(getCellValueOrDefault(currentCell));
//                            break;
//                        case 16:
//                            medicine.setStea(getCellValueOrDefault(currentCell));
//                            break;
//                        case 17:
//                            medicine.setTriunghi(getCellValueOrDefault(currentCell));
//                            break;
//                        case 18:
//                            medicine.setDreptunghi(getCellValueOrDefault(currentCell));
//                            break;
//                        case 19:
//                            medicine.setDataActualizare(getCellValueOrDefault(currentCell));
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                medicines.add(medicine);
//                LOG.info("Successfully parsed row #{}", rowNumber);
//                rowNumber++;
//            }
//
//            workbook.close();
//
//            return medicines;
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
//        }
//    }
//
//}
