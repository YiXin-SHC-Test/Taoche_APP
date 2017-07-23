package Yixin.Taoche.Util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App_common {

	AppiumDriver driver;

	// 点击某元素
	public void tab(WebElement element, AppiumDriver driver) {
		try {
			TouchAction ta = new TouchAction(driver);
			ta.tap(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 点击某坐标
	public void tab(int x, int y, AppiumDriver driver) {
		try {
			TouchAction ta = new TouchAction(driver);
			ta.tap(x, y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 在某元素上长按
	public void longPress(By by, AppiumDriver driver) {
		try {
			WebElement element = driver.findElement(by);
			TouchAction ta = new TouchAction(driver);
			ta.longPress(element).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取应用占屏幕大小
	public int[] appScreen() {
		int width = driver.manage().window().getSize().getWidth();
		int heightScreen = driver.manage().window().getSize().getWidth();
		int[] appWidthAndHight = { width, heightScreen };
		return appWidthAndHight;
	}

	// 向下滑动
	public void swipeToDown(int duration) {
		int starty = this.appScreen()[1] * 1 / 5;
		int endy = this.appScreen()[1] * 4 / 5;
		int x = this.appScreen()[1] * 1 / 2;
		try {
			driver.swipe(x, starty, x, endy, duration);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 向左滑动
	public void swipeToLeft(int duration) {
		int startx = this.appScreen()[0] * 4 / 5;
		int endx = this.appScreen()[0] * 1 / 5;
		int y = this.appScreen()[1] * 1 / 2;
		try {
			driver.swipe(startx, y, endx, y, duration);
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 向上滑动
	public void swipeToUp(int duration) {
		int starty = this.appScreen()[1] * 4 / 5;
		int endy = this.appScreen()[1] * 1 / 5;
		int x = this.appScreen()[1] * 1 / 2;
		try {
			driver.swipe(x, starty, x, endy, duration);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 向右滑动
	public void swipeToRight(int duration) {
		int startx = this.appScreen()[0] * 1 / 5;
		int endx = this.appScreen()[0] * 4 / 5;
		int y = this.appScreen()[1] * 1 / 2;
		try {
			driver.swipe(startx, y, endx, y, duration);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 滑动方法，通过参数实现各个方向滑动
	public void swipe(String direction, int duration) {
		switch (direction) {
		case "Up":
			this.swipeToUp(duration);
			break;
		case "Down":
			this.swipeToDown(duration);
			break;
		case "Left":
			this.swipeToLeft(duration);
			break;
		case "Right":
			this.swipeToRight(duration);
			break;
		default:
			break;
		}
	}

	// 封装swipe方法，实现在某元素上滑动
	// 在元素上滑动
	public void swipeOnElement(WebElement element, String direction,
			int duration) {
		// x,y分别为元素的起始坐标点
		int x = element.getLocation().getX();// 获取该元素起始x值
		int y = element.getLocation().getY();// 获取该元素起始y值
		int elementWidth = element.getSize().getWidth();
		int elementHight = element.getSize().getHeight();
		switch (direction) {
		case "Up":
			int startx = x + elementWidth / 2;
			int starty = y + elementHight * 4 / 5;
			int endy = y + elementHight * 1 / 5;
			driver.swipe(startx, starty, startx, endy, duration);
			break;
		case "Down":
			startx = x + elementWidth / 2;
			starty = y + elementHight * 1 / 5;
			endy = y + elementHight * 4 / 5;
			driver.swipe(startx, starty, startx, endy, duration);
			break;
		case "Left":
			starty = x + elementWidth / 2;
			startx = y + elementHight * 4 / 5;
			int endx = y + elementHight * 1 / 5;
			driver.swipe(startx, starty, endx, starty, duration);
			break;
		case "Right":
			starty = x + elementWidth / 2;
			startx = y + elementHight * 1 / 5;
			endx = y + elementHight * 4 / 5;
			driver.swipe(startx, starty, endx, starty, duration);
			break;
		default:
			break;
		}
	}

	// 在某方向上滑动直至期望的元素出现
	public void swipeUntilElementAppear(By by, String direction, int duration) {
		boolean flag = true;
		while (flag) {
			try {
				driver.findElement(by);
				flag = false;
			} catch (Exception e) {
				this.swipe(direction, duration);
			}
		}
	}

	// 元素是否存在
	public boolean isElementExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 在指定超时时间内元素是否存在，如果存则立即返回结果，如不存在则在超时后返回结果
	public boolean isElementExist(By by, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.presenceOfElementLocated(by));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void wait(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	// 启动闪屏页滑动操作
	public void Splash_screen(){
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		int startx = width * 7 / 8;
		int endx = width * 1 / 8;
		int y = height * 1 / 2;

		// 每次启动时，有启动应用的闪屏页，需向左滑动3次
		try {
			for (int i = 0; i < 3; i++) {
				driver.swipe(startx, y, endx, y, 2000);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 最后一个闪屏页找不到可定位元素，所以找到image的classname执行点击操作进入APP首页
		driver.findElement(By.className("android.widget.ImageView")).click();
	}
}
