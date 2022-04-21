package tpMapReduce;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;


public class VenteMap1 extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {

    public void map(LongWritable key, Text values, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {
        String venteEls[]=values.toString().split(" ");
        //add (key,value) to OutputCollector :
        output.collect(new Text(venteEls[1]),new DoubleWritable(Double.valueOf(venteEls[3])));

    }



}