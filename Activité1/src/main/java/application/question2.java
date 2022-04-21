package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class question2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Configuration conf=new Configuration();
     conf.set("fs.defaultFS","hdfs://localhost:9000");
     conf.set("dfs.replication","1");
     try {
         FileSystem fs=FileSystem.get(conf);
         Path path1=new Path("/BDCC/CPP/Cours/CoursCPP1.txt");
         Path path2=new Path("/BDCC/CPP/Cours/CoursCPP2.txt");
         Path path3=new Path("/BDCC/CPP/Cours/CoursCPP3.txt");
         FSDataOutputStream fsos1=fs.create(path1);
         FSDataOutputStream fsos2=fs.create(path2);
         FSDataOutputStream fsos3=fs.create(path3);
         BufferedWriter bw1=new BufferedWriter(new OutputStreamWriter(fsos1));
         BufferedWriter bw2=new BufferedWriter(new OutputStreamWriter(fsos2));
         BufferedWriter bw3=new BufferedWriter(new OutputStreamWriter(fsos3));
         //add content to created files :
         bw1.write("the content of the first file");
         bw1.close();
         bw2.write("the content of the second file");
         bw2.close();
         bw3.write("the content of the third file");
         bw3.close();
     }catch (Exception e){
         e.printStackTrace();
     }
	}
}
