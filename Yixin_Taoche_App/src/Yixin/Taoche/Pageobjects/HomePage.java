package Yixin.Taoche.Pageobjects;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

public class HomePage {
	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private AppiumDriver driver;

	public HomePage(AppiumDriver driver) {
		this.driver = driver;
	}

	// 返回首页中的搜索输入框
	public WebElement SearchInput() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于SearchInput的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.SearchInput"));
		return element;
	}

	// 返回首页中底部导航栏-首页
	public WebElement Homepage() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Homepage的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.homepage"));
		return element;
	}

	// 返回首页中底部导航栏-新车
	public WebElement Newcar() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Newcar的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.newcar"));
		return element;
	}

	// 返回首页中底部导航栏-二手车
	public WebElement Oldcar() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Oldcar的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.oldcar"));
		return element;
	}

	// 返回首页中底部导航栏-分期
	public WebElement Diffedate() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Diffedate的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.diffedate"));
		return element;
	}

	// 返回首页中底部导航栏-我的
	public WebElement Mine() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Mine的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.HomePage.mine"));
		return element;
	}
}
