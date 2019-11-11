package com.oem.framework.listeners;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.oem.framework.core.utils.ConfigUtils;
import com.oem.framework.core.utils.TestUtil;
import com.uttesh.pdfngreport.PDFReportListener;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.testng.*;
import org.testng.xml.XmlSuite;


public class CustomReporter extends PDFReportListener implements IReporter {
    /**
     * Document
     */
    private Document document = null;
    private String pdfTempFile="regression_tmp.pdf";
    private String pdfFile="regression.pdf";
    private String finalReportFile="OEM_Regression"+TestUtil.getCurrentTime()+".pdf";
    HashMap<String,String> configs;
    static ClassData overallData;
    /**
     * PdfPTables
     */
    PdfPTable classLevelReportTable = null;

    public CustomReporter() throws IOException {
        this.document = new Document();
        configs=ConfigUtils.loadConfigs("pdfngreport.properties");
        try {
            PdfWriter.getInstance(this.document, new FileOutputStream(pdfTempFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
        overallData=new ClassData("Consolidated Data");

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
        String className,simpleName;
        int passCount,failedCount,skippedCount;
        ClassData(String className){
            this.className=className;
            this.simpleName=className.replace("com.oem.","");
            passCount=0;
            failedCount=0;
            skippedCount=0;
        }

        public String getClassName() {
            return className;
        }

        public String getSimpleName() {
            return simpleName;
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

        public void setPassCount(int passCount) {
            this.passCount = passCount;
        }

        public void setFailedCount(int failedCount) {
            this.failedCount = failedCount;
        }

        public void setSkippedCount(int skippedCount) {
            this.skippedCount = skippedCount;
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
        super.generateReport(list,suites,outputFolder);
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

                for(String className:passedClasses)
                    incrementClassLevelResult(className, TestCaseStatus.PASS);

                for(String className:failedClasses)
                    incrementClassLevelResult(className, TestCaseStatus.FAILED);

                for(String className:skippedClasses)
                    incrementClassLevelResult(className, TestCaseStatus.SKIPPED);

                overallData.setPassCount(overallData.getPassCount()+tc.getPassedTests().size());
                overallData.setFailedCount(overallData.getFailedCount()+tc.getFailedTests().size());
                overallData.setSkippedCount(overallData.getSkippedCount()+tc.getSkippedTests().size());


            }
        }


        this.document.open();
        Paragraph p = new Paragraph( " OEM Regression Results",
                FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new BaseColor(0, 0, 255)));
        try {
            this.document.add(p);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        createPDFTableWithHeader();

        System.out.println("******************************* Generating Custom Report **********************");
        //
        for (Map.Entry<String, ClassData> entry : classDataMap.entrySet()) {
            System.out.println(entry.getKey()+" -  "+entry.getValue());
            addClassLevelDataInPdfTable(entry.getValue());
        }

        addSeparation("Consolidated Results",BaseColor.LIGHT_GRAY);
        addConsolidatedData();

        this.classLevelReportTable.setSpacingBefore(15f);
        try {
            this.document.add(this.classLevelReportTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        this.classLevelReportTable.setSpacingBefore(15f);


        this.document.close();

        try {
            mergePDFDocs(pdfFile,pdfTempFile,configs.get("pdfreport.outputdir")+ File.separator+configs.get("pdfreport.file.name")+".pdf");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Merging of files failed");
        }
        File src=new File(pdfFile);
        File dest=new File(finalReportFile);
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("******************************* Failed to copy pdf file  **********************");
        }
    }


    private void createPDFTableWithHeader(){

        if (classLevelReportTable == null) {
            this.classLevelReportTable = new PdfPTable(new float[]{.6f, .1f, .1f, .1f,.1f});
            /*Paragraph p = new Paragraph("TEST Results", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell(p);
            cell.setColspan(this.classLevelReportTable.getNumberOfColumns());
            cell.setBackgroundColor(BaseColor.GREEN);
            this.classLevelReportTable.addCell(cell);*/
            addSeparation("Class Level Results",BaseColor.GRAY);
            PdfPCell cell;
            cell = new PdfPCell(new Paragraph("Class Name"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.classLevelReportTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Total"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.classLevelReportTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Pass"));
            cell.setBackgroundColor(BaseColor.GREEN);
            this.classLevelReportTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Fail"));
            cell.setBackgroundColor(BaseColor.RED);
            this.classLevelReportTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("Skip"));
            cell.setBackgroundColor(BaseColor.YELLOW);
            this.classLevelReportTable.addCell(cell);
        }

    }

    private void addClassLevelDataInPdfTable(ClassData classData){
        PdfPCell cell = new PdfPCell(new Paragraph(classData.getSimpleName()));
        this.classLevelReportTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getTotalCount())));
        this.classLevelReportTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getPassCount())));
        this.classLevelReportTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getFailedCount())));
        this.classLevelReportTable.addCell(cell);

        cell = new PdfPCell(new Paragraph(String.valueOf(classData.getSkippedCount())));
        this.classLevelReportTable.addCell(cell);
    }

    private void mergePDFDocs(String destinationFile,String sourceFile1,String sourceFile2) throws IOException{
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        pdfMerger.setDestinationFileName(destinationFile);
       // PDDocument f1=PDDocument.load(new File(sourceFile1));
        pdfMerger.addSource(new File(sourceFile1));

       // PDDocument f2=PDDocument.load(new File(sourceFile2));
        pdfMerger.addSource(new File(sourceFile2));

        pdfMerger.mergeDocuments();
    }

    public void addSeparation(String title, BaseColor color){
        Paragraph p = new Paragraph(title, new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
        p.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell = new PdfPCell(p);
        cell.setColspan(this.classLevelReportTable.getNumberOfColumns());
        cell.setBackgroundColor(color);
        this.classLevelReportTable.addCell(cell);
    }



   public void addConsolidatedData(){
       Paragraph p = new Paragraph("Consolidated Results", new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
       p.setAlignment(Element.ALIGN_CENTER);
       PdfPCell cell = new PdfPCell(p);
       cell.setColspan(4);
       addClassLevelDataInPdfTable(overallData);
   }
}
