package kr.co.greenart;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
	private static Logger logger = LoggerFactory.getLogger(TestLogger.class);
	@Test
	public void test() {
		logger.info("Info 메세지 작동 테스트");
		logger.warn("Warn 메세지");
		logger.error("Error 메세지");
		assertNotNull(logger);
	}
}
