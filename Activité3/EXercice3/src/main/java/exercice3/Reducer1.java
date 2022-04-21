package exercice3;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

public class Reducer1 extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, Text>
{

    @Override
    public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        double min=0;
        double per;
        double max=0;
        while(values.hasNext()) {
            if((per=values.next().get())<min)min=per;
            else if(per>max)max=per;
        }
        String out="minTemperature->"+String.valueOf(min)+"\tmaxTemperature------>"+String.valueOf(max);
        output.collect(key, new Text(out));

    }
}
