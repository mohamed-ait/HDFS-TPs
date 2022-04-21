package exercice3;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.mortbay.log.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Mapper1 extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
    //split received line using  comma  and ignoring comma inside string :
        String values[]= value.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println(values[0]);
        //separate date elments using "-"
        String dates[] = values[1].split("-");
        //replace comma by point to be compiled
        String tmp=values[13].replace(',','.');
        Log.info("la temperature :"+tmp.substring(1,tmp.length()-1));
        Log.info("la temperature :"+Double.valueOf(tmp.substring(1,tmp.length()-1)));
        output.collect(new Text(dates[1]),new DoubleWritable(Double.valueOf(tmp.substring(1,tmp.length()-1))));


    }
}
