package application;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class question8 {
public static void main(String[] args) throws IOException {
	Configuration conf=new Configuration();
    conf.set("fs.defaultFS","hdfs://localhost:9000");
    conf.set("dfs.replication","1");
    FileSystem fs=FileSystem.get(conf);
    Path path = new Path("/BDCC");
    RemoteIterator<LocatedFileStatus> it = fs.listFiles(path, true);
    while(it.hasNext()) {
    	LocatedFileStatus lfs=it.next();
    	System.out.println(lfs.getPath()+"---->"+lfs.getPermission());
    }
    
  
}
}
