package employe;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Reporter;


public class EmployeMapper1 extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{

	public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
			throws IOException {
		String values[]=value.toString().split(",");
		
		output.collect(new Text(values[2]), new DoubleWritable(Double.valueOf(values[4])));
	}

}
