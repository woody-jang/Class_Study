package kr.co.greenart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog2 {
	private static Logger logger = LoggerFactory.getLogger(TestLog2.class);
	
	public static void main(String[] args) {
		logger.info("slf4j -> log4j 기록 남기는 중");
		logger.debug("debug");
		logger.warn("warning");
		logger.error("error");
	}
}
