package com.wakaleo.bddinaction.chapter9.flightstatus.resources

import com.wakaleo.bddinaction.chapter9.flightstatus.excel.ApachePOIExcelReader

class ReadingFromAnExcelSpreadsheetSpec {

    def "should be able to read data from an excel spreadsheet"() {
        given: "I have a spreadsheet"
            def spreadsheetFile = new File("src/test/resources/spreadsheet.xlsx")
        when: "I read the data from this spreadsheet"
            def excelReader = new ApachePOIExcelReader()
            def data = excelReader.readDataFrom(spreadsheetFile)
        then:
            data == [["Joe",20,false],
                     ["Jill",30,true],
                     ["Jack", 50, false]]
    }
}
