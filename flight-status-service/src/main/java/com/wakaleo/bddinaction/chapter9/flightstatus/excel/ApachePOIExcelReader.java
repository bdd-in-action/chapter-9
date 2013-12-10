package com.wakaleo.bddinaction.chapter9.flightstatus.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ApachePOIExcelReader implements ExcelReader {

    public List<HashMap<String, Object>> readDataFrom(File spreadsheet) throws IOException {

        List<HashMap<String, Object>> results = Lists.newArrayList();

        FileInputStream file = new FileInputStream(spreadsheet);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        List<String> headers = Lists.newArrayList();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (headers.isEmpty()) {
                headers = getHeadersFrom(row);
            } else {
                HashMap<String, Object> rowDetails = readRowDetailsFrom(row, headers);
                results.add(rowDetails);
            }
        }
        file.close();
        return results;
    }

    private HashMap<String, Object> readRowDetailsFrom(Row row, List<String> headers) {
        HashMap<String, Object> rowCells = Maps.newHashMap();
        Iterator<Cell> cellIterator = row.cellIterator();
        int headerIndex = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING :
            }
        }
        return rowCells;
    }

    private List<String> getHeadersFrom(Row row) {
        List<String> headers = Lists.newArrayList();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                headers.add(cell.getStringCellValue());
            }
        }
        return headers;
    }
}
