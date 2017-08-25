package ttt;

import java.io.File;
import java.util.ArrayList;

public class ttt {

	public static void main(String[] args) {
		 File f = new File("d:\\ccc"); //讀取"00這個資料夾"，要記得將此資料夾放置同個java file裡面
		 ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
	        if(f.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	System.out.println("filename : "+f.getName()); //印出我們所讀到的資料夾
	        	String []s=f.list(); //宣告一個list
	            System.out.println("size : "+s.length); //印出資料夾裡的檔案個數
	            for(int i=0;i<s.length;i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡面
	            }
	        }
	        for(int i=0;i<fileList.size();i++)
	        {
	            System.out.println(fileList.get(i)); //印出資料夾內的檔名
	        }
	}

}
