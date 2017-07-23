package Yixin.Taoche.Pageobjects;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;

import Yixin.Taoche.Util.ObjectMap;

public class LoginPage {
	private WebElement element = null;
	// 指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap("config/objectMap.properties");
	private AppiumDriver driver;

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
	}

	// 手机快捷登录页
	// 返回账号密码登录选项
	public WebElement Zhanghao_login() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于Zhanghao_login的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.zhanghaoLogin"));
		return element;
	}

	// 账号密码登录页
	// 返回手机号输入框
	public WebElement password_tel() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于password_tel的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.password_tel"));
		return element;
	}

	// 返回密码输入框
	public WebElement new_password() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于new_password的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.new_password"));
		return element;
	}

	// 返回登录按钮
	public WebElement loginbtn() throws Exception {
		// 使用objectMap类中的getLocator方法获取配置文件中关于loginbtn的定位方式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("taoche.LoginPage.loginbtn"));
		return element;
	}
}
