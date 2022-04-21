package application;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class question5 {
public static void main(String[] args) throws IOException {
	Configuration conf=new Configuration();
    conf.set("fs.defaultFS","hdfs://localhost:9000");
    conf.set("dfs.replication","1");
    FileSystem fs=FileSystem.get(conf);
    Path path3= new Path("/BDCC/JAVA/Cours/CoursCPP3.txt");
    Path path1= new Path("/BDCC/JAVA/Cours/CoursCPP1.txt");
    Path path2= new Path("/BDCC/JAVA/Cours/CoursCPP2.txt");
    Path path11= new Path("/BDCC/JAVA/Cours/CoursJAVA1.txt");
    Path path22= new Path("/BDCC/JAVA/Cours/CoursJAVA2.txt");
    fs.delete(path3, true);
    fs.rename(path1, path11);
    fs.rename(path2, path22);
}
}
