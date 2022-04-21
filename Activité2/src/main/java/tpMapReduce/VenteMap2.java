package tpMapReduce;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class VenteMap2 extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{

    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter)
            throws IOException {

        String ventes[]=value.toString().split(" ");
        String dateVille=new String(ventes[0]+ventes[1]);

        output.collect(new Text(dateVille), new DoubleWritable(Double.valueOf(ventes[3])));

    }

}
