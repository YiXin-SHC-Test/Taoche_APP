package Yixin.Taoche.Util;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	// 用于测试执行过程中暂停程序执行的休眠方法
	public static void sleep(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 显示等待页面元素出现的封装方法，参数为页面元素的Xpath定位字符串
	public static void waitWebelement_ByXapth(AppiumDriver driver,
			String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 调用WebDriverWait的presenceOfElementLocated方法判断页面元素是否出现
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(xpathExpression)));
	}

	// 显示等待页面元素出现的封装方法，参数为页面元素的id定位字符串
	public static void waitWebelement_ById(AppiumDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 调用WebDriverWait的presenceOfElementLocated方法判断页面元素是否出现
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}
}
