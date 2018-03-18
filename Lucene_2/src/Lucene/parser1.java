package Lucene;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class parser1 {
	public static void main(String[] args) throws IOException {
	
		List<String> results = new ArrayList<String>();
	    	File[] file = new File("/Users/supreetsingh/Desktop/IR Assignement2/Assignment_Two/ft").listFiles();
	    	System.out.println(file);
	    	ArrayList<String> files1 = new ArrayList<String>();
	    	for (File files : file) {
	    		if(files.isDirectory()) {
	    			System.out.println(files.getPath());
	    			System.out.println();
	    			for(File f:files.listFiles()) {
	    				files1.add(f.getAbsolutePath());
	    		
	    			}
	    			} }
//	    	
//	    		if(files.isFile()){
//	    		    System.out.println(files.getAbsolutePath());
//    			//System.out.println("Directory: " + file.length);
//	    		//results.add(files.getName());    		
//	    		//System.out.println(files.getName());
//	    		} 
	    		//else if(files.isDirectory()) {
	    		//	System.out.println(files.getAbsolutePath());
	    		//}
//	    		
	    for(String f: files1) {
	    	System.out.println(f);
    	File input = new File(f);
	    	Document doc = Jsoup.parse(input,"UTF-8", "");
 		   
    		doc.select("docid").remove();
    	    doc.select("tablerow").remove();
    	    doc.select("table").remove();
    	    doc.select("tablecell").remove();
    	    doc.select("rowrule").remove();
    	    doc.select("cellrule").remove();
    	    doc.select("section").remove();
    	    doc.select("length").remove();
    	    doc.select("graphic").remove();
    	    doc.select("docid").remove();
    	    doc.select("dateline").remove();
    	    doc.select("date").remove();
    	    doc.select("correction-date").remove();

    	  
    	    Elements docs = doc.select("doc");
    	    //System.out.println(docs.size());

    	    for (Element e: docs) {

    	      	String DocNo = e.getElementsByTag("Docno").text();
	    		String TextContent = e.getElementsByTag("Text").text();
	    		String Headline = e.getElementsByTag("Headline").text();
	    		String ByLine = e.getElementsByTag("Byline").text();
	    		String Profile =e.getElementsByTag("Profile").text();
	    		

	    			System.out.println(DocNo + ":   ");
				System.out.println("Headline" + ":   " + Headline);
				System.out.println("TextContent" + ":   " + TextContent);
				System.out.println("ByLine" + ":   " + ByLine);
				System.out.println("Profile" + ":   " + Profile);
			
    			
    				 File result = new File("/Users/supreetsingh/Desktop/IR Assignement2/ft_docs/"+DocNo);
    	             PrintWriter writer = new PrintWriter(result, "UTF-8");
    	             writer.println(DocNo + '\n'+ Headline + '\n'+ TextContent+'\n'+ ByLine + '\n'+ Profile);
    	             writer.close();
	    }
	    	
	    }
	    			
	}}