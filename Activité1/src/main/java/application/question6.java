package application;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class question6 {
public static void main(String[] args) throws IOException {
	Configuration conf=new Configuration();
    conf.set("fs.defaultFS","hdfs://localhost:8000");
    conf.set("dfs.replication","1");
    FileSystem fs=FileSystem.get(conf);
	File file1=new File("/home/med/test/TP1CPP");
	File file2=new File("/home/med/test/TP2CPP");
	File file3=new File("/home/med/test/TP1JAVA");
	File file4=new File("/home/med/test/TP2JAVA");
	File file5=new File("/home/med/test/TP3JAVA.");
	
}
}
