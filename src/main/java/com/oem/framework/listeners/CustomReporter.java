package com.oem.framework.listeners;


import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.testng.*;
import org.testng.xml.XmlSuite;


public class CustomReporter implements IReporter {
    /**
     * Document
     */
    private Document document = null;

    /**
     * PdfPTables
     */
    PdfPTable successTable = null;

    public CustomReporter() {
        this.document = new Document();
        try {
            PdfWriter.getInstance(this.document, new FileOutputStream("regression.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static enum TestCaseStatus {
        PASS("PASS"),
        FAILED("FAILED"),
        SKIPPED("SKIPPED");

        private String statusCode;

        private TestCaseStatus(String s) {
            this.statusCode = s;
        }

        public String getStatusCode() {
            return this.statusCode;
        }
    }
    class ClassData{
        String className;
        int passCount,failedCount,skippedCount;
        ClassData(String className){
            this.className=className;
            passCount=0;
            failedCount=0;
            skippedCount=0;
        }

        public String getClassName() {
            return className;
        }

        public int getPassCount() {
            return passCount;
        }

        public int getFailedCount() {
            return failedCount;
        }

        public int getSkippedCount() {
            return skippedCount;
        }
        public void incPassCount(){
            ++passCount;
        }
        public void incFailCount(){
            ++failedCount;
        }
        public void incSkippedCount(){
            ++skippedCount;
        }
        public int getTotalCount(){
            return passCount+failedCount+skippedCount;
        }

        @Override
        public String toString() {
            return
                    "class -'" + className + '\'' +"\t"+
                    ", TotalCount=" + getTotalCount() +"\t"+
                    ", passCount=" + passCount +"\t"+
                    ", failedCount=" + failedCount +"\t"+
                    ", skippedCount=" + skippedCount +"\t"
                    ;
        }
    }

    public static Map<String, ClassData> classDataMap = new HashMap<String, ClassData>();

    public void incrementClassLevelResult(String className, TestCaseStatus status){
        ClassData classData;
        if(classDataMap.containsKey(className))
            classData=classDataMap.get(className);
        else
            classData=new ClassData(className);

        switch (status){
            case PASS:
                classData.incPassCount();
                break;
            case FAILED:
                classData.incFailCount();
                break;
            case SKIPPED:
                classData.incSkippedCount();
                break;
        }
        classDataMap.put(className,classData);
    }

    /**
     * This will be called from IReporter
     *
     * @param list
     * @param suites
     * @param outputFolder
     */
    public void generateReport(List<XmlSuite> list, List<ISuite> suites, String outputFolder) {
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();

                List<String> failedClasses=tc.getFailedTests().getAllResults().stream().map(res -> res.getTestClass().getName())
                        .collect(Collectors.toList());
                List<String> passedClasses=tc.getPassedTests().getAllResults().stream().map(res -> res.getTestClass().getName())
                        .collect(Collectors.toList());

                List<String> skippedClasses=tc.getSkippedTests().getAllResults().stream().map(res -> res.getTestClass().getName())
                        .collect(Collectors.toList());

                for(String className:failedClasses)
                    incrementClassLevelResult(className, TestCaseStatus.FAILED);
                for(String className:passedClasses)
                    incrementClassLevelResult(className, TestCaseStatus.PASS);

                for(String className:skippedClasses)
                    incrementClassLevelResult(className, TestCaseStatus.SKIPPED);


            }
        }


        this.document.open();
        Paragraph p = new Paragraph( " TESTNG RESULTS",
                FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new BaseColor(0, 0, 255)));
        try {
            this.document.add(p);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        createPDFTable();

        System.out.println("******************************* Generating Custom Report **********************");
        //
        for (Map.Entry<String, ClassData> entry : classDataMap.entrySet()) {
            System.out.println(entry.getKey()+" -  "+entry.getValue());
            addClassLevelData(entry.getValue());
        }



        this.successTable.setSpacingBefore(15f);
        try {
            this.document.add(this.successTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        this.successTable.setSpacingBefore(15f);
        this.document.close();
    }


    private void createPDFTable(){

        if (successTable == null) {
            this.successTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});
            Paragraph p = new Paragraph("TEST Results", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell(p);
            cell.setColspan(4);
            cell.setBackgroundColor(BaseColor.GREEN);
            this.successTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("Class"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Total Count"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Pass Count"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Failed Count"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
        }

    }

    private void addClassLevelData(ClassData classData){
        PdfPCell cell = new PdfPCell(new Paragraph(classData.getClassName()));
        this.successTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getTotalCount())));
        this.successTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getPassCount())));
        this.successTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getFailedCount())));
        this.successTable.addCell(cell);
    }
}
