package spark.sample.gradle;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launch {
	
	private final static Logger LOG = LoggerFactory.getLogger(Launch.class);

	public static void main(String[] args) {

		SparkConf sparkConfig = new SparkConf();
		sparkConfig.setAppName("Sample Gradle Spark");
		sparkConfig.setMaster("local");
		
		JavaSparkContext sc = new JavaSparkContext(sparkConfig);
		
		JavaRDD<String> rdd = sc.parallelize(Arrays.asList("1", "1", "2", "3", "5", "8"));
		long result = rdd.count();
		LOG.info("Result Size: "+result);
		
		sc.stop();

	}

}
