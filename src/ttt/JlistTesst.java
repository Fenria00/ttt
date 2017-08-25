package ttt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class JlistTesst extends JFrame {
	
	public static void main(String[] args) {
		
		new JlistTesst(null).setVisible(true);

	}

	private JTextField textField;
	private JList list;
	
	public JlistTesst(String a){
		//初始
		System.out.println("JlistTesst start");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		//輸入path用的框
		textField = new JTextField();
		textField.setColumns(10);
		add(textField, BorderLayout.NORTH);
		
		//設定完path後讀取資料夾的按鈕1
		JButton btn1 = new JButton("set path");
		getContentPane().add(btn1);
		
		//點擊觸發事件1 主要為讀取path值抓資料夾內的檔案
		btn1.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//有吃到路徑才執行第二階段 - 載入所有檔案的list
				if(textField.getText()!=null){
					System.out.println(textField.getText());
					new JlistTesst(textField.getText());
				}else{
					System.out.println("xxxdsfsdddd13123");
				}
				System.out.println("button1 start:");
				System.out.println(textField.getText());
				final String exePath = textField.getText();
				File f = new File(exePath); //讀取"00這個資料夾"，要記得將此資料夾放置同個java file裡面
				final ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			        if(f.isDirectory()) //如果f讀到的是資料夾，就會執行
			        {
			        	System.out.println("filename : "+f.getName()); //印出我們所讀到的資料夾
			        	String []s=f.list(); //宣告一個list
			            System.out.println("size : "+s.length); //印出資料夾裡的檔案個數
			            for(int i=0;i<s.length;i++)
			            {
			                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡面
			            }
			        }
				list= new JList(fileList.toArray());
				getContentPane().add(list);
				
				JButton btn2 = new JButton("instell exe");
				getContentPane().add(btn2);
				btn2.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
					int[] indices=list.getSelectedIndices();	
					List<String> selectedList = list.getSelectedValuesList();
						for(int i = 0;i<selectedList.size();i++){
							String fileName = selectedList.get(i);
							try {
								File ff = new File(exePath+"\\"+fileName);
								ff.setExecutable(true);
								ff.setReadable(true);
								ff.setWritable(true);
								Process process =Runtime.getRuntime().exec("cmd /c  "+exePath+"\\"+fileName);
//								Process process2 = Runtime.getRuntime().exec(exePath+"\\"+fileName);
							} catch (IOException ss) {
								// TODO Auto-generated catch block
								ss.printStackTrace();
							}
						}
					}
				});
				
			}
		});
		
		//裝資料
		setSize(500,500);
	}
	
}
