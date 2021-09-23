import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLog {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TestLog.class.getName());
//		ConsoleHandler consoleHandler = new ConsoleHandler();
//		consoleHandler.setFormatter(new SimpleFormatter());
//		logger.addHandler(consoleHandler);
//		logger.info("로거를 통해 info 메세지 기록");
		
		try {
			FileHandler fileHandler = new FileHandler("my-log.log");
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			
			logger.info("파일에 기록되는지? Info 메세지 기록");
			logger.warning("경고 레벨의 기록남기기");
			logger.log(Level.WARNING, "msg");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
