package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class question1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Configuration conf=new Configuration();
     conf.set("fs.defaultFS","hdfs://localhost:9000");
     conf.set("dfs.replication","1");
  try {
	  FileSystem fs=FileSystem.get(conf);
      Path path1=new Path("/BDCC/CPP/Cours");
      Path path2=new Path("/BDCC/CPP/TPS");
      Path path3=new Path("/BDCC/JAVA/Cours");
      Path path4=new Path("/BDCC/JAVA/TPs");
      fs.mkdirs(path1);
      fs.mkdirs(path1);
      fs.mkdirs(path1);
      fs.mkdirs(path1);
      fs.close();
  }

   catch (Exception e){
         e.printStackTrace();
     }
	}
}
