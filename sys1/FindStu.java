/*
 * 功能：这是学生信息查询窗口，采用基于管理窗口，即主界面的对话框实现
 * */
package sys1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindStu extends JDialog implements ActionListener{
    //定义查询所需要的面板和组件
    JPanel jp1;
    JLabel jp1_jl1;
    JTextField jp1_jtf1;
    JButton jp1_jb1,jp1_jb2,jp1_jb3;
    JTable jtb;
    JScrollPane jsp;
    ShowStuMessageModel tm;

    public FindStu(Frame Main,String title ,boolean model)
    {
        //调用父类的构造方法，实现模式对话
        super(Main,title,model);
        jp1=new JPanel();

        jp1_jl1=new JLabel("请输入学号：");
        jp1_jl1.setFont(MyFont.f1);
        jp1_jtf1=new JTextField(15);

        jp1_jb1=new JButton("查 询");
        jp1_jb1.setFont(MyFont.f1);
        jp1_jb1.addActionListener(this);

        jp1_jb2=new JButton("清 除");
        jp1_jb2.setFont(MyFont.f1);
        jp1_jb2.addActionListener(this);

        jp1_jb3=new JButton("显示所有学生");
        jp1_jb3.setFont(MyFont.f1);
        jp1_jb3.addActionListener(this);

        //把组件添加到JPanel中
        jp1.add(jp1_jl1);
        jp1.add(jp1_jtf1);
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);
        jp1.add(jp1_jb3);

        jtb=new JTable();
        jsp=new JScrollPane(jtb);
        this.add(jp1,"North");
        this.add(jsp,"Center");

        //小图标
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\查询.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\清除.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\显示所有记录.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);
        ScalePhoto(bi3,15,15);

        jp1_jb1.setIcon(bi1);
        jp1_jb2.setIcon(bi2);
        jp1_jb3.setIcon(bi3);

        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    //小图标缩小
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        //如果点击了查询按钮
        if(arg0.getSource()==jp1_jb1)
        {
            //获取文本框的值
            String Id=jp1_jtf1.getText().trim();//其中trim()是去掉文本框前面可能有的空格，但不能去掉字符串中的空格
            String sql="select * from stuMessage where Id='"+Id+"'";

            //调用模型
            tm=new ShowStuMessageModel(sql);
            jtb.setModel(tm);
        }
        //如果点击了清除按钮
        else if(arg0.getSource()==jp1_jb2)
        {
            jp1_jtf1.setText("");
        }
        //如果点击了显示所有学生
        else if(arg0.getSource()==jp1_jb3)
        {
            tm=new ShowStuMessageModel(null);
            jtb.setModel(tm);
        }
    }

}
