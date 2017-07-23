package Yixin.Taoche.Pageobjects;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

public class MinePage {
	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private AppiumDriver driver;

	public MinePage(AppiumDriver driver) {
		this.driver = driver;
	}

	// 返回首页中的搜索输入框
	public WebElement Please_login() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于please_login的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.MinePage.please_login"));
		return element;
	}
}
