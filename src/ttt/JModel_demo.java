package ttt;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
 
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
 
//=================================================
// File Name       :	JModel_demo
//------------------------------------------------------------------------------
// Author          :	Common
 
//类名：MyListModel
//属性：
//方法：
class MyListModel extends AbstractListModel{
 
	private String nations[] = {"中国","美国","韩国","法国","英国"};
 
	@Override
	public int getSize() {
		// TODO 自动生成的方法存根
		return this.nations.length;
	}
 
	@Override
	public Object getElementAt(int index) {		//返回指定标号的元素
		// TODO 自动生成的方法存根
		if(index<this.nations.length){
			return this.nations[index];
		}else{
			return null;
		}
	}
}
 
//类名：MyList
//属性：
//方法：
class myList implements ListSelectionListener{
	private JFrame frame = new JFrame("窗体");					//定义窗体
	private Container cont = frame.getContentPane();			//得到窗体容器
	private JList list1  = null;															//定义列表框
//	private JList list2  = null;															//定义列表框
	public myList(){
		this.list1 = new JList(new MyListModel());
//		this.list2 = new JList(new MyListModel());
		//定义一个列表框的边框显示条
		list1.setBorder(BorderFactory.createTitledBorder("哪个国家？"));
//		list2.setBorder(BorderFactory.createTitledBorder("Vector?"));
		//第一个列表框一次可以选择多个选项
		list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//第二个列表框每次可以选择一个选项
//		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
		list1.addListSelectionListener(this); 			//加入事件监听
//		list2.addListSelectionListener(this); 			//加入事件监听
		cont.add(new JScrollPane(this.list1));			//加入滚动条
 
		cont.add(this.list1);					//加入面板
//		cont.add(this.list2);					//加入面板
		this.frame.setSize(330,200);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new WindowAdapter(){	//加入事件监听
			public void windowClosing(WindowEvent arg0) {			//窗口关闭时触发，按下关闭按钮
			// TODO 自动生成的方法存根
			System.out.println("windowClosing-->窗口关闭");
			System.exit(1);
			}
		});
	}
 
	public void valueChanged(ListSelectionEvent e) {
		// TODO 自动生成的方法存根
		int temp[] = list1.getSelectedIndices();				//取得全部选定
		System.out.println("选定的内容：");
		for(int i=0;i<temp.length;i++){
			System.out.println(list1.getModel().getElementAt(i)+"、");
		}
	}
}
 
//主类
//Function        : 	JModel_demo
public class JModel_demo {
 
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new myList();
	}
 
}