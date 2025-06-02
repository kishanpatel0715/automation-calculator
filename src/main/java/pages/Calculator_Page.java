package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import helpers.Browser_Helper;

public class Calculator_Page {

	WebDriver driver; 
	
	public Calculator_Page()
	{
		driver = Browser_Helper.getDriver();
	}
	
	public By googleTextBox = By.id("APjFqb"); 
	public By button0 = By.xpath("//*[@id='rso']//div[text()='0']");
	public By button1 = By.xpath("//*[@id='rso']//div[text()='1']");
	public By button2 = By.xpath("//*[@id='rso']//div[text()='2']");
	public By button3 = By.xpath("//*[@id='rso']//div[text()='3']");
	public By button4 = By.xpath("//*[@id='rso']//div[text()='4']");
	public By button5 = By.xpath("//*[@id='rso']//div[text()='5']");
	public By button6 = By.xpath("//*[@id='rso']//div[text()='6']");
	public By button7 = By.xpath("//*[@id='rso']//div[text()='7']");
	public By button8 = By.xpath("//*[@id='rso']//div[text()='8']");
	public By button9 = By.xpath("//*[@id='rso']//div[text()='9']");
	public By buttonDecimal = By.xpath("//*[@id='rso']//div[text()='.']");
	public By operatorEqual = By.xpath("//*[@id='rso']//div[text()='=']");
	public By operatorPlus = By.xpath("//*[@id='rso']//div[text()='+']");
	public By operatorMinus = By.xpath("//*[@id='rso']//div[text()='−']");
	public By operatorMultiply = By.xpath("//*[@id='rso']//div[text()='×']");
	public By operatorDivide = By.xpath("//*[@id='rso']//div[text()='÷']");
	public By buttonAC = By.xpath("//*[@id='rso']//div[text()='AC']");
	public By buttonCE = By.xpath("//*[@id='rso']//div[text()='CE']");
	public By displayAnswer = By.id("cwos");
	
	public void searchGoogle(String keyword) 
	{
		driver.findElement(googleTextBox).sendKeys("Calculator" + Keys.ENTER);
	}
	
	public void enterNumber(String number)
	{
		for(int i=0; i<number.length(); i++)
		{
			char digit = number.charAt(i);	
			switch(digit)
			{
			case '0':
				driver.findElement(button0).click();
				break;
			case '1':
				driver.findElement(button1).click();
				break;
			case '2': 
				driver.findElement(button2).click();
				break;
			case '3': 
				driver.findElement(button3).click();
				break;
			case '4': 
				driver.findElement(button4).click();
				break;
			case '5': 
				driver.findElement(button5).click();
				break;
			case '6': 
				driver.findElement(button6).click();
				break;
			case '7': 
				driver.findElement(button7).click();
				break;
			case '8': 
				driver.findElement(button8).click();
				break;
			case '9': 
				driver.findElement(button9).click();
				break;
			case '.': 
				driver.findElement(buttonDecimal).click();
				break;
			case '-':
				driver.findElement(operatorMinus).click();
				break;
			}
		}
	}	
	
		public void enterSign(String function)
		{
			switch(function.toLowerCase())
			{
			 case "addition":
				 driver.findElement(operatorPlus).click();
				 break;
			 case "subtraction":
				 driver.findElement(operatorMinus).click();
				 break;
			 case "multiplication":
				 driver.findElement(operatorMultiply).click();
				 break;
			 case "division":
				 driver.findElement(operatorDivide).click();
				 break;
			}
		}
		
		public void confirm()
		{
			driver.findElement(operatorEqual).click();
		}
		
		public String getAnswer()
		{
			return driver.findElement(displayAnswer).getText();
		}
		
		public void clearAll()
		{
			driver.findElement(buttonAC).click();
		}
		
		public void clearEntry()
		{
			driver.findElement(buttonCE).click();
		}
}