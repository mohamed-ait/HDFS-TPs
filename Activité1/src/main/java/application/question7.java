package application;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class question7 {
public static void main(String[] args) throws IOException {
	Configuration conf=new Configuration();
    conf.set("fs.defaultFS","hdfs://localhost:9000");
    conf.set("dfs.replication","1");
    Path src1= new Path("/home/med/TPs/TP1JAVA");
    Path src2= new Path("/home/med/TPs/TP2JAVA");
    Path dst = new Path("/BDCC/JAVA/TPs");
    FileSystem fs=FileSystem.get(conf);
    fs.copyFromLocalFile(src1, dst);
    fs.copyFromLocalFile(src2, dst);
    fs.close();
}
}

