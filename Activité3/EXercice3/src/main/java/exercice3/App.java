package exercice3;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
       JobConf job = new JobConf();
        job.setJobName("le main et le max des temperatures mois  ");
        job.setJarByClass(App.class);
        job.setMapperClass(Mapper1.class);
        job.setReducerClass(Reducer1.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        job.setInputFormat(TextInputFormat.class);
        job.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.addInputPath(job, new Path("temperatures.csv"));
        FileOutputFormat.setOutputPath(job, new Path("output"));
        try {
            JobClient.runJob(job);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }}
