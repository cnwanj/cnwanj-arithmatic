package org.gxuwz.arithmatic.designPattern.main8_责任链模式;

/**
 * @author: cnwanj
 * @date: 2022-04-25 22:40:39
 * @version: 1.0
 * @desc: 责任链模式（行为模式）
 * 描述：
 * 		为请求者创建一个处理者链，发送一个请求，可能会经过多个处理者。
 * 		通常每个处理者都会引用下一个处理者。
 *
 * 优点：实现请求者和处理者解耦，请求者不需要知道谁处理，处理者也不需要知道请求者的全貌。
 * 缺点：不利于调试；在链条较长的时候需要将整个链条执行。
 */
public class ChainPattern {
	private static AbstractLogger getChainLoggers() {
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.WARNING);
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return errorLogger;
	}

	public static void main(String[] args) {
		getChainLoggers()
			.logMessage(AbstractLogger.INFO, "Information.")
			.logMessage(AbstractLogger.WARNING, "Waring.");

//		AbstractLogger chainLoggers = getChainLoggers();
//		chainLoggers.logMessage(AbstractLogger.INFO, "Information.");
//		chainLoggers.logMessage(AbstractLogger.WARNING, "Waring.");
//		chainLoggers.logMessage(AbstractLogger.ERROR, "Error.");
	}
}

/**
 * 创建抽象日志类
 */
abstract class AbstractLogger {

	public static int INFO = 1;
	public static int WARNING = 2;
	public static int ERROR = 3;

	protected int level;

	// 下一个元素
	protected AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public AbstractLogger logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
		return nextLogger;
	}

	abstract protected void write(String message);
}

/**
 * 创建3个扩展了该日志类的实体类
 */
class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("console-logger: " + message);
	}
}
class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("error-logger: " + message);
	}
}
class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("file-logger: " + message);
	}
}
