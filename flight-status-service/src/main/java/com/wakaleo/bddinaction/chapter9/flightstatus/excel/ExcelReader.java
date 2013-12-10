package com.wakaleo.bddinaction.chapter9.flightstatus.excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface ExcelReader {
    public List<HashMap<String,Object>> readDataFrom(File spreadsheet) throws IOException;
}
