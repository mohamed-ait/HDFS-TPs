package employe;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;


public class EmployeReducer1 extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, Text>{

	public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, Text> output,
			Reporter reporter) throws IOException {
		double per;
		double max=values.next().get();
		double min=max;
		while(values.hasNext()) {
			per=values.next().get();
			if(per<min)min=per;
			else if(per>max)max=per;
		}
		String out="minSalaire->"+String.valueOf(min)+"\t maxSalaire------>"+String.valueOf(max);
		output.collect(key, new Text(out));
		
	}

}
