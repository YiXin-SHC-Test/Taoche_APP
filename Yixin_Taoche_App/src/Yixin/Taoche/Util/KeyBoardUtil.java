package Yixin.Taoche.Util;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyBoardUtil {
	// 按Tab键的封装方法
	public static void pressTabKey() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		// 调用keyPress方法来实现按下Tab键
		robot.keyPress(KeyEvent.VK_TAB);
		// 调用keyRelease方法来实现释放Tab键
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	// 按Enter键的封装方法
	public static void pressEnter() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		// 调用keyPress方法来实现按下Tab键
		robot.keyPress(KeyEvent.VK_ENTER);
		// 调用keyRelease方法来实现释放Tab键
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
