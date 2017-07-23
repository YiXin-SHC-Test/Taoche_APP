package Yixin.Taoche.TestScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Yixin.Taoche.Modules.App_BaseCase;
import Yixin.Taoche.Pageobjects.HomePage;
import Yixin.Taoche.Pageobjects.LoginPage;
import Yixin.Taoche.Pageobjects.MinePage;
import Yixin.Taoche.Util.Constant;
import Yixin.Taoche.Util.Log;
import Yixin.Taoche.Util.WaitUtil;

public class Login_Test extends App_BaseCase {
	public static Logger logger = Logger.getLogger(Startup_Test.class);

	@Test
	public void Login() throws Exception {
		Log.startTestCase("启动APP");
		Log.startTestCase("进入APP首页");
		HomePage homePage = new HomePage(driver);
		MinePage minePage = new MinePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		// 定位首页下方导航栏"我的按钮"，点击进入个人中心页面
		homePage.Mine().click();
		// 验证个人中心界面是否已登录状态
		if (driver.getPageSource().contains("请登录")) {
			minePage.Please_login().click();
			// 通过账号密码登录
			loginPage.Zhanghao_login().click();
			WaitUtil.sleep(1000);
			loginPage.password_tel().sendKeys(Constant.UserName);
			loginPage.new_password().sendKeys(Constant.Password);
			loginPage.loginbtn().click();
			WaitUtil.sleep(1000);
			Assert.assertTrue(driver.getPageSource().contains("易鑫用户"));
		} else {
			Log.info("用户已登录");
			System.out.println("用户已登录");
			Assert.assertTrue(driver.getPageSource().contains("易鑫用户"));
		}
	}
}
