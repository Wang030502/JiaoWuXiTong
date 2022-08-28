package sys1;

import SqlConnection.SqlConn;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStu extends JDialog implements ActionListener {
    //定义修改学生信息的相关组件
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JButton jb1,jb2,jb3;
    int stuAge=0;
    Double stuSourse=0.0;

    //这是修改学生信息的界面函数的封装
    public void upView()
    {
        //加载数据库，获得选中的那一行的所有信息

        jl1=new JLabel("学 号：");
        //因为学号是主键，设置文本框不可编辑的同时，一般也设置标签灰色显示，以区别其他标签
        jl1.setEnabled(false);
        jl1.setBounds(20, 20, 60, 25);
        jl1.setFont(MyFont.f1);

        jl2=new JLabel("姓 名：");
        jl2.setFont(MyFont.f1);
        jl2.setBounds(250, 20, 60, 25);

        jl3=new JLabel("性 别：");
        jl3.setFont(MyFont.f1);
        jl3.setBounds(20, 60, 60, 25);

        jl4=new JLabel("年 龄：");
        jl4.setFont(MyFont.f1);
        jl4.setBounds(250, 60, 60, 25);

        jl5=new JLabel("出生地：");
        jl5.setFont(MyFont.f1);
        jl5.setBounds(14, 100, 60, 25);

        jl6=new JLabel("专 业：");
        jl6.setFont(MyFont.f1);
        jl6.setBounds(20, 140, 60, 25);

        jl7=new JLabel("班 级：");
        jl7.setFont(MyFont.f1);
        jl7.setBounds(20, 180, 60, 25);

        jl8=new JLabel("总学分：");
        jl8.setFont(MyFont.f1);
        jl8.setBounds(240, 180, 60, 25);

        jtf1=new JTextField(20);
        //由于学号是主键，因此不能修改，即设置障碍曙jtf1不可编辑
        jtf1.setEnabled(false);
        jtf1.setBounds(70, 20, 130, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf2=new JTextField(20);
        jtf2.setBounds(300, 20, 130, 25);
        jtf2.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf3=new JTextField(10);
        jtf3.setBounds(70, 60, 60, 25);
        jtf3.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf4=new JTextField(10);
        jtf4.setBounds(300, 60, 60, 25);
        jtf4.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf5=new JTextField(30);
        jtf5.setBounds(70, 100, 360, 25);
        jtf5.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf6=new JTextField(20);
        jtf6.setBounds(70, 140, 290, 25);
        jtf6.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf7=new JTextField(20);
        jtf7.setBounds(70, 180, 130, 25);
        jtf7.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf8=new JTextField(20);
        jtf8.setBounds(300, 180, 130, 25);
        jtf8.setBorder(BorderFactory.createLoweredBevelBorder());

        jb1=new JButton("修 改");
        jb1.setFont(MyFont.f1);
        jb1.setBounds(95, 220, 90, 25);
        jb1.addActionListener(this);

        jb2=new JButton("取 消");
        jb2.setFont(MyFont.f1);
        jb2.setBounds(285, 220, 90, 25);
        jb2.addActionListener(this);

        jb3=new JButton("清 除");
        jb3.setFont(MyFont.f1);
        jb3.setBounds(190,220,90,25);
        jb3.addActionListener(this);

        this.setLayout(null);
        //把组件添加到窗体
        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jtf2);
        this.add(jl3);
        this.add(jtf3);
        this.add(jl4);
        this.add(jtf4);
        this.add(jl5);
        this.add(jtf5);
        this.add(jl6);
        this.add(jtf6);
        this.add(jl7);
        this.add(jtf7);
        this.add(jl8);
        this.add(jtf8);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);

        //小图标
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\修改.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\清除.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\取消.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);
        ScalePhoto(bi3,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi3);
        jb3.setIcon(bi2);
    }

    //因为要修改信息，那么必须要获得所选中的那一行的所有信息，把它们添加到文本框作为默认值，因此构造方法还应添加一个参数即传递一个模型tm，并传递所选中的行号row
    public UpdateStu(Frame Main, String title, TableModel tm, int rowNo, boolean model)
    {
        //调用父类的构造方法，实现模式对话
        super(Main,title,model);

        //调用修改学生信息的界面的方法
        this.upView();

        //先从表模型中获取所选中的那一行数据
        //选中行的第0列为学号
        String stuId=(String)tm.getValueAt(rowNo, 0);
        System.out.println("sutId="+stuId);
        //选中行的第1列为姓名
        String stuName=(String)tm.getValueAt(rowNo, 1);
        System.out.println("sutName="+stuName);
        //选中行的第2列为性别
        String stuSex=(String)tm.getValueAt(rowNo, 2);
        System.out.println("stuSex="+stuSex);
        //选中行的第3列为年龄
        String stuAge=(String)tm.getValueAt(rowNo, 3);
        //选中行的第4列为地址
        String stuJg=(String)tm.getValueAt(rowNo, 4);
        String stuZy=(String)tm.getValueAt(rowNo, 5);
        String classId=(String)tm.getValueAt(rowNo, 6);
        String stuSourse=(String)tm.getValueAt(rowNo, 7);
        //设置文本框的默认值
        jtf1.setText(stuId);
        jtf2.setText(stuName);
        jtf3.setText(stuSex);
        jtf4.setText(stuAge);
        jtf5.setText(stuJg);
        jtf6.setText(stuZy);
        jtf7.setText(classId);
        jtf8.setText(stuSourse);

        //设置窗体的属性
        this.setSize(465,300);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setResizable(false);

    }

    //小图标缩小
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //当点击了修改按钮
        if(e.getSource()==jb1)
        {
            //获取文本框的信息
            String stuId=jtf1.getText().trim();
            String stuName=jtf2.getText().trim();
            if(stuName.equals(""))
            {
                JOptionPane.showMessageDialog(this, "请输入姓名！");
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            String stuSex=jtf3.getText().trim();
            if(stuSex.equals(""))
            {
                JOptionPane.showMessageDialog(this, "请输入性别！");
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }

            ////对于年龄，则需要进行两个判断，一个是不能为空，另一个必须是int型，下面用异常来判断输入的学生年龄是否是整型数
            //******************************************//
            try {
                stuAge=Integer.parseInt(jtf4.getText().trim());//把从文本框取得的字符串转换成整型，如果抛异常，则输入的不是整形数
                if(stuAge<1)
                {
                    JOptionPane.showMessageDialog(this, "年龄必须大于或等于1！");
                    return;
                }
            } catch (Exception e2) {
                //提示输入的不是整数
                JOptionPane.showMessageDialog(this, "请输入一个整数的年龄！");
                //如果抛异常，则返回到添加窗口，后面终止执行******************************//
                return;
                // TODO: handle exception
            }
            //*******************************************************************//
            String stuJg=jtf5.getText().trim();
            if(stuJg.equals(""))
            {
                JOptionPane.showMessageDialog(this, "请输入出生地！");
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            String stuZy=jtf6.getText().trim();
            if(stuZy.equals(""))
            {
                JOptionPane.showMessageDialog(this, "请输入专业！");
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            String classId=jtf7.getText().trim();
            if(classId.equals(""))
            {
                JOptionPane.showMessageDialog(this, "请输入班号！");
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }

            //*******************************************//
            try {
                stuSourse=Double.parseDouble(jtf8.getText().trim());
                if(stuSourse==0.0)
                {
                    JOptionPane.showMessageDialog(this, "请输入总学分！");
                    return;//返回到输入界面，如果没有return语句，则会回到主界面
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "请输入一个整数或小数的总学分！");
                return;
                // TODO: handle exception
            }

            //调用数据库连接
            //设置操纵更新的sql语句
            String sql="update StuMessage set Name='"+stuName+"',Sex='"+stuSex+"',Age='"+stuAge+"',address='"+stuJg+"',Major='"+stuZy+"',Class='"+classId+"',Source='"+stuSourse+"' where Id='"+stuId+"'";
            SqlConn sqlconn=new SqlConn();
            sqlconn.sqlUpdate(sql);
            //关闭数据库连接
            sqlconn.closeSqlConn();
            //关闭对话框
            this.dispose();
        }
        //如果点击了取消按钮，则关闭模式对话框
        else if(e.getSource()==jb2)
        {
            this.dispose();
        }
        //如果点击了清除按钮，则清除所有的广本框的内容，除了学号
        else if(e.getSource()==jb3)
        {
            //由于学号是主键，则不能修改！
            jtf2.setText("");
            jtf3.setText("");
            jtf4.setText("");
            jtf5.setText("");
            jtf6.setText("");
            jtf7.setText("");
            jtf8.setText("");
        }
    }
}


