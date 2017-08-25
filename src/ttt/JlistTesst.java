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
		//��l
		System.out.println("JlistTesst start");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		//��Jpath�Ϊ���
		textField = new JTextField();
		textField.setColumns(10);
		add(textField, BorderLayout.NORTH);
		
		//�]�w��path��Ū����Ƨ������s1
		JButton btn1 = new JButton("set path");
		getContentPane().add(btn1);
		
		//�I��Ĳ�o�ƥ�1 �D�n��Ū��path�ȧ��Ƨ������ɮ�
		btn1.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//���Y����|�~����ĤG���q - ���J�Ҧ��ɮת�list
				if(textField.getText()!=null){
					System.out.println(textField.getText());
					new JlistTesst(textField.getText());
				}else{
					System.out.println("xxxdsfsdddd13123");
				}
				System.out.println("button1 start:");
				System.out.println(textField.getText());
				final String exePath = textField.getText();
				File f = new File(exePath); //Ū��"00�o�Ӹ�Ƨ�"�A�n�O�o�N����Ƨ���m�P��java file�̭�
				final ArrayList<String> fileList = new ArrayList<String>(); //�ŧi�@���ʺA�}�C��String�����A�A�ت��Ψ��x�s�ɦW
			        if(f.isDirectory()) //�p�GfŪ�쪺�O��Ƨ��A�N�|����
			        {
			        	System.out.println("filename : "+f.getName()); //�L�X�ڭ̩�Ū�쪺��Ƨ�
			        	String []s=f.list(); //�ŧi�@��list
			            System.out.println("size : "+s.length); //�L�X��Ƨ��̪��ɮ׭Ӽ�
			            for(int i=0;i<s.length;i++)
			            {
			                fileList.add(s[i]); //�N�ɦW�@�@�s��fileList�ʺA�}�C�̭�
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
		
		//�˸��
		setSize(500,500);
	}
	
}
