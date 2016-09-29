//title			:ProcessTweet.java
//description	:Process the Tweet file based on regex
//author		:Shixun Liu
//date			:2016/08/23
//usage			:Unimelb_KT_Assignment1_Approx String Matching
//=============================================================================\
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcessTweet {
		 
	    public ArrayList<String[]> list;
	    String path;
	     
	    ProcessTweet(String path){
	        this.list = new ArrayList<String[]>();
	        this.path = path;
	    }
	         
	    public void getText() throws IOException{
	         
	        String str = null;  
	 
	        BufferedReader br = new BufferedReader(new FileReader(this.path));
	        while((str = br.readLine())!=null){
	 
	            str = str.replaceAll("[^a-zA-Z\\W]*|https?://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)","");
	            str = str.replaceAll("\\W+"," ");
	             
	            list.add(str.toLowerCase().trim().split(" "));
	        }
	         
	        br.close();
	    }
}
