package com.oem.framework.core.base;

import com.aventstack.extentreports.ExtentTest;
import com.oem.framework.core.Globals;
import com.oem.framework.core.TestExecutionContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> implements Base {

   // protected static ThreadLocal threadLocalPage=new ThreadLocal<>();
    protected final WebDriver driver;
    private int DEFAULT_EXPLICIT_WAIT=3;
    protected final String testName;
    protected TestExecutionContext testExecutionContext;
    protected Logger logger=getLogger();

    public BasePage() {
        testExecutionContext = Globals.getTestExecutionContext(Thread.currentThread().getId());
        driver = testExecutionContext.getDriver();
        testName = testExecutionContext.getTestName();
    }
    
    /**
     * Set value of the webelement by passing locator and value
     * @param by
     * @param value
     */
    public void setValue(By by, String value){
        waitForElementPresent(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }
    
    /**
     * clear data present in the webelement
     * @param by
     */
    public void clearValue(By by) {
    	waitForElementPresent(by);
        driver.findElement(by).clear();
    }
    
    /**
     * Click on a particular webelement by entering its locator as argument.
     * @param by
     */
    public void click(By by){
        waitForElementPresent(by);
        driver.findElement(by).click();
    }
    public void refreshPage() {
    	driver.navigate().refresh();
    }

    public void waitForElementPresent(By locatn) {
       waitForElementPresent(locatn,DEFAULT_EXPLICIT_WAIT);
    }
    public void waitForElementPresent(By locatn,int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(locatn));

        } catch (Exception e) {

        }
    }
    /**
     * Explicitely wait for an element to dissapear.
     * @param locator
     */
    public void waitForElementInvisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

        } catch (Exception e) {

        }
    }

    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        int i = 0;
        while (true) {
            if (driver.findElement(locator).isDisplayed())
                break;
            else if (i < 5) {
                logger.info("searching element by scroll up");
                ((JavascriptExecutor) driver).executeScript("scroll(0,100)");
                i++;
            } else if (i < 10) {
                logger.info("searching element by scroll down");
                ((JavascriptExecutor) driver).executeScript("scroll(0,100)");
                i++;
            } else {
                logger.info("not able to find element by scrolling up and down");
                break;
            }
        }
    }

    public String getText(By locator){
        waitForElementPresent(locator);
        return driver.findElement(locator).getText();
    }
    public String getAttribute(By locator, String attributeName) {
        String attribute = "";
        waitForElementPresent(locator);
        try {
            attribute = driver.findElement(locator).getAttribute(attributeName);
            logger.info("Attribute value is: " + attribute);
        } catch (Exception e) {
            logger.info("Not able to fetch attribute value- " + e.getMessage());
        }
        return attribute;
    }


    public void selectByVisibleText(By locator, String value){
        waitForElementPresent(locator);
        new Select(driver.findElement(locator)).selectByVisibleText(value);
    }

    public void selectByIndex(By locator, int index){
        waitForElementPresent(locator);
        new Select(driver.findElement(locator)).selectByIndex(index);
    }

    public void selectByValue(By locator, String value){
        waitForElementPresent(locator);
        new Select(driver.findElement(locator)).selectByValue(value);
    }
    
    public void selectByPartOfVisibleText(By locatorsOfOptions, String value) {
    	List<WebElement> options = driver.findElements(locatorsOfOptions);
    	for (WebElement option : options) {
    	    if (option.getText().contains(value)) {
    	        option.click();
    	        break;
    	    }
    	}
    }

    public boolean isElementPresent(By locator) {
    	return isElementPresent(locator,DEFAULT_EXPLICIT_WAIT);
    }

    public boolean isElementPresent(By locator,int waitTime) {
        waitForElementPresent(locator,waitTime);
        try {
            WebElement element = driver.findElement(locator);
            if (element == null)
                return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    protected void load() {

    }

    protected boolean isCustomerDashboardPage(){
        if(driver.getCurrentUrl().contains("CustomerDashboard"))
            return true;
        return false;
    }

    protected boolean isSignInPage(){
        if(driver.getCurrentUrl().contains("Account/Login"))
            return true;
        return false;

    }

    protected boolean isAdminDashboardPage(){
        if(driver.getCurrentUrl().contains("AdminDashboard"))
            return true;
        return false;
    }

    protected void verifyElementPresent(By element){
        Assert.assertTrue(isElementPresent(element),"Element "+element +" doesn't exit");
    }
    /**
     * Used to enter data into a webelement based by passing locator and data as arguments
     * @param locator
     * @param keys
     */
    public void sendSpecialKeys(By locator,Keys keys){
        driver.findElement(locator).clear();
    	driver.findElement(locator).sendKeys(keys);
    }
    /**
     * Used to select a future date from date picker by entering date, month and year as arguments. For selecting a month, enter 0 for January and 11 for December.
     * @param dayOfMonth
     * @param monthNumber
     * @param year
     */
    public void selectFutureDateCalender(int dayOfMonth, int monthNumber, int year)
	{
		int count = 0;
		while(count<=60) 
		{
			try {
				driver.findElement(By.xpath("//td[@data-month = '" + monthNumber + "' and @data-year = '" + year + "']/a[text() = '" + dayOfMonth + "']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//a[@data-handler = 'next']/span[text() = 'Next']")).click();
				count++;
			}
		}
	}
    /**
     * Used to select a previous date from date picker by entering date, month and year as arguments. For selecting a month, enter 0 for January and 11 for December.
     * @param dayOfMonth
     * @param monthNumber
     * @param year
     */
    public void selectPrevDateCalender(int dayOfMonth, int monthNumber, int year) 
	{
		int count = 0;
		while(count<=60) 
		{
			try {
				driver.findElement(By.xpath("//td[@data-month = '" + monthNumber + "' and @data-year = '" + year + "']/a[text() = '" + dayOfMonth + "']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//a[@data-handler = 'prev']/span[text() = 'Prev']")).click();
				count++;
			}
		}
	}
    public String addDaysToCurrentDate(int addDSays){
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date()); // Now use today date.
    	c.add(Calendar.DATE, addDSays); // Adding  days
    	String output = sdf.format(c.getTime());
    	return output;
    }
    /**
     * Get properties file key value based on your arguments
     * @param key
     * @return String
     * @throws Throwable
     */
    public String getPropertyFileData(String key) throws Exception
    {
    	FileInputStream fObj = new FileInputStream("./data/commonData.properties");
    	Properties pObj = new Properties();
    	pObj.load(fObj);
    	String data = pObj.getProperty(key);
    	return data;
    }
    /**
     * Used to read data from excel sheet based on your arguments (testScriptData.xlsx) 
     * @param sheetNum
     * @param rowNum
     * @param cellNum
     * @return String
     * @throws Throwable
     */
    public String readExcelData(String sheetNum, int rowNum, int cellNum) throws Exception
    {
    	FileInputStream fObj = new FileInputStream("./data/testscriptdata.xlsx");
    	Workbook wb = WorkbookFactory.create(fObj);
    	Sheet sh = wb.getSheet(sheetNum);
    	Row row = sh.getRow(rowNum);
    	Cell cel = row.getCell(cellNum);
    	String data = cel.getStringCellValue();
    	return data;
    }
    public int readExcelIntData(String sheetNum, int rowNum, int cellNum) throws Throwable
    {
    	FileInputStream fObj = new FileInputStream("./data/testscriptdata.xlsx");
    	Workbook wb = WorkbookFactory.create(fObj);
    	Sheet sh = wb.getSheet(sheetNum);
    	Row row = sh.getRow(rowNum);
    	Cell cel = row.getCell(cellNum);
    	int data = (int) cel.getNumericCellValue();
    	return data;
    }
    public void setExcelIntData(String sheetName, int rowNum, int celNum, int data) throws Throwable
   	{
   		FileInputStream fis = new FileInputStream("./data/testscriptData.xlsx");
   		Workbook wb = WorkbookFactory.create(fis);
   		Sheet sh = wb.getSheet(sheetName);
   		Row row = sh.getRow(rowNum);
   		Cell cel = row.getCell(celNum);
   		cel.setCellValue(data);
   		FileOutputStream fos = new FileOutputStream("./data/testscriptData.xlsx");		
   		wb.write(fos);
   		wb.close();
   	}
    public void setExcelData(String sheetName, int rowNum, int celNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./data/testscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/testscriptData.xlsx");		
		wb.write(fos);
		wb.close();
	}
    /**
     * Used to check if the dropdown contains the value
     * @param locator of dropdown
     * @param value
     * @return boolean
     */
    public boolean isElementExistInDropDown(By locator, String value)
    {
    	List<WebElement> allElements = driver.findElements(locator);
    	boolean status = false;
    	for (WebElement element: allElements) {
            if(element.getText().contains(value)==true) 
            {
            	status = true;
            }
        }
    	return status;
    }
    /**
     * Used to check if the list contains the value
     * @param locator identifying all elements of list
     * @param value
     * @return boolean
     */
    public boolean isElementExistInList(By locator, String value)
    {
    	List<WebElement> allElements = driver.findElements(locator);
    	boolean status = false;
    	for (WebElement element: allElements) {
            if(element.getText().contains(value)==true) 
            {
            	status = true;
            }
        }
    	return status;
    }
    public void actionsClick(By locator) {
    	Actions actions = new Actions(driver);
    	actions.moveToElement((WebElement) locator).click().build().perform();
    }


    /**
     * Returns true if all the check box in the list is enabled.
     * @param locator
     */
    public boolean checkboxListEnabledStatus(By locator) {
	   	List<WebElement> allElements = driver.findElements(locator);
	    boolean status = true;
	   	for (WebElement element: allElements) {
	        if(element.isEnabled()==false) 
	            {
	            	status = false;
	            	break;
	            }
	        }
	return status;
	}
    public void numberOfCheckListPresent(By locator){
    	List<WebElement> els = driver.findElements(locator);
    	int i=1;
    	int selected=0;
    	int notSelected=0;
    	System.out.println("Number Of Elemnts present in List is  "+els.size());
    	for ( WebElement el : els ) {
    		System.out.println("Elemnt "+i+" is : "+el.getText());
    	    if ( el.isSelected() ) {
    	    	selected++;
    	    
    	    }
    	    else{
    	    	notSelected++;
    	    }
    	    i++;
    	    }
    	if(selected>notSelected){
    		System.out.println("All the items are selected"+selected);
    	}
    	else
    		System.out.println("All the items are Not selected"+notSelected);

    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)");
    }
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void mouseOver(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();

    }
    public void staticWait(int secs){
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String currentDate() {
		LocalDate myObj1 = LocalDate.now(); 
		Object d1 = myObj1;
		String date = d1.toString();

		int day = Integer.parseInt(date.substring(8, 10));
		int month = Integer.parseInt(date.substring(5, 7));
		int year = Integer.parseInt(date.substring(0, 4));
		String currentDate = day + "/" + month + "/" + year;
		return currentDate;
	}
    public String getCuttrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();

		String systemdate = dateFormat.format(date);
		return systemdate;
	}

}

