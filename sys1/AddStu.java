package sys1;

import SqlConnection.SqlConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddStu extends JDialog implements ActionListener {

    //定义添加学生信息的相关组件
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JButton jb1,jb2,jb3;
    ResultSet rs;
    int stuAge=0;
    Double stuSourse=0.0;
    int i=0;//用于判断到底点击了添加还是取消，来决定是否执行数据更新操作
    public int falg()
    {
        return i;
    }


    //这是添加学生界面的函数封装
    public void addView()
    {
        jl1=new JLabel("学 号：");
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
        jtf1.setBounds(70, 20, 130, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());//设置三维下凹效果

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

        jb1=new JButton("添 加");
        jb1.setFont(MyFont.f1);
        jb1.setBounds(95, 220, 90, 25);
        jb1.addActionListener(this);//按钮一定在这里添加监听器，否则无法实现

        jb2=new JButton("取 消");
        jb2.setFont(MyFont.f1);
        jb2.setBounds(300, 220, 90, 25);
        jb2.addActionListener(this);

        jb3=new JButton("清 除");
        jb3.setFont(MyFont.f1);
        jb3.setBounds(195,220,90,25);
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
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\添加.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\清除.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\取消.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);
        ScalePhoto(bi3,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi3);
        jb3.setIcon(bi2);

    }

    public AddStu(Frame Main,String title,boolean model)
    {
        //调用父类的构造方法，实现模式对话
        super(Main,title,model);
        //调用添加学生信息界面的的方法
        this.addView();
        //设置窗体的属性
        this.setSize(465,300);
        this.setLocationRelativeTo(null);//设置初始位置在中间
        this.getContentPane().setBackground(Color.LIGHT_GRAY);//设置背景必须是在显示窗口前面，否则不能显示出来
        this.setVisible(true);
        this.setResizable(false);//窗口大小不可改变

    }

    //小图标缩小
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //用于判断输入的学号是否存在时，如果存在则返回该学号，否则返回null,因此在这里，定义一个用于接收该返回的学号
        //并设置该No的初始值为空，否则报错。
        String No = null ;
        //当点击了添加按钮
        if(e.getSource()==jb1)
        {
            //***********************************//
            //获取文本框的信息
            String stuId=jtf1.getText().trim();
            //判断，不能让文本输入框的值为空
            if(stuId.equals(""))
            {
                JOptionPane.showMessageDialog(this, "请输入学号！");
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
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
                JOptionPane.showMessageDialog(this, "请输入地址！");
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

            //**********************************************//

            //首先先判断该主键是否在数据库中是否存在，其次分别判断性别是否为“男”或者“女”，年龄是否为数字，总学分是否为浮点型或双精度型
            String sql="select * from stuMessage where Id='"+stuId+"'";
            SqlConn sqlconn=new SqlConn();
            rs=sqlconn.sqlQuery(sql);
            try {
                while(rs.next())
                {   //为获取结果集当前行的第n列数据
                    No=rs.getString(1);//看到底是否存在该学生的学号，如果存在，则返回该学号，不存在，则为空。
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                // TODO: handle exception
            }
            if(No==null)
            {
                if((stuSex.equals("男")||stuSex.equals("女")))
                {
                    //调用数据库连接
                    sql="insert into stuMessage values('"+stuId+"','"+stuName+"','"+stuSex+"','"+stuAge+"','"+stuJg+"','"+stuZy+"','"+classId+"','"+stuSourse+"')";
                    //new 一个sqlconn类的对象
                    sqlconn=new SqlConn();
                    sqlconn.sqlUpdate(sql);
                    this.i=1;
                    //关闭数据库连接
                    sqlconn.closeSqlConn();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "性别应该是男或女！");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "该学号已经存在，请输入新的学号！");
            }
        }
        //如果点击了取消按钮，则关闭模式对话框
        else if(e.getSource()==jb2)
        {
            //退出当前窗口
            this.dispose();
        }
        else if(e.getSource()==jb3)
        {
            //清空文本框信息
            jtf1.setText("");
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

