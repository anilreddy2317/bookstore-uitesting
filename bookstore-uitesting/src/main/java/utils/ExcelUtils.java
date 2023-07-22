package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
    private final String filePath;

    public ExcelUtils(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, String> getTestData(String sheetName) {
        Map<String, String> testData = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRowNum = sheet.getLastRowNum();

            for (int i = 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell keyCell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell valueCell = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String key = keyCell.getStringCellValue();
                    String value = valueCell.getStringCellValue();
                    testData.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }
}
