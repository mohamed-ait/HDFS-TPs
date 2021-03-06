package tpMapReduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class VenteReduce1 extends MapReduceBase implements Reducer<Text, DoubleWritable,Text,DoubleWritable>
{

    public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output,
                       Reporter reporter) throws IOException {
        double ventes=0;
        while(values.hasNext()) {
            ventes+=values.next().get();
        }
        output.collect(key, new DoubleWritable(ventes));
    }
}