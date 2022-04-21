package tpMapReduce;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class Application2 {
    public static void main(String[] args) {
        //create an insance of jobConf
        try{

            JobConf job=new JobConf();
            job.setJobName("la somme des ventes par ville et date ");
            job.setJarByClass(Application2.class);

            job.setMapperClass(VenteMap2.class);
            job.setReducerClass(VenteReduce2.class);

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(DoubleWritable.class);

            job.setInputFormat(TextInputFormat.class);
            job.setOutputFormat(TextOutputFormat.class);

            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job,new Path(args[1]));
            JobClient.runJob(job);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
