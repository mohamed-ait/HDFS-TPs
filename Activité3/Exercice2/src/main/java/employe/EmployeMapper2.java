package employe;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Reporter;
import org.mortbay.log.Log;


public class EmployeMapper2 extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String values[]=value.toString().split(",");
		
		output.collect(new Text(values[2]), new IntWritable(1));
		Log.info("---------------->"+values[2]);
	}

}
