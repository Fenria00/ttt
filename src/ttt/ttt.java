package ttt;

import java.io.File;
import java.util.ArrayList;

public class ttt {

	public static void main(String[] args) {
		 File f = new File("d:\\ccc"); //Ū��"00�o�Ӹ�Ƨ�"�A�n�O�o�N����Ƨ���m�P��java file�̭�
		 ArrayList<String> fileList = new ArrayList<String>(); //�ŧi�@���ʺA�}�C��String�����A�A�ت��Ψ��x�s�ɦW
	        if(f.isDirectory()) //�p�GfŪ�쪺�O��Ƨ��A�N�|����
	        {
	        	System.out.println("filename : "+f.getName()); //�L�X�ڭ̩�Ū�쪺��Ƨ�
	        	String []s=f.list(); //�ŧi�@��list
	            System.out.println("size : "+s.length); //�L�X��Ƨ��̪��ɮ׭Ӽ�
	            for(int i=0;i<s.length;i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //�N�ɦW�@�@�s��fileList�ʺA�}�C�̭�
	            }
	        }
	        for(int i=0;i<fileList.size();i++)
	        {
	            System.out.println(fileList.get(i)); //�L�X��Ƨ������ɦW
	        }
	}

}
