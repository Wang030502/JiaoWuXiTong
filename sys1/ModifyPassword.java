package sys1;

import SqlConnection.SqlConn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ModifyPassword extends JDialog implements ActionListener {

    //创建窗口所需要的组件
    JLabel jl1, jl2, jl3;
    JPasswordField jtf1, jtf2, jtf3;
    JButton jb1, jb2, jb3;
    SqlConn sqlConn;
    ResultSet rs;
    String OriginPsw;
    public static int i = 1;//i=0，密码修改成功则关闭当前所有的对话框，并且重新登录

    public void MP() {
        jl1 = new JLabel("原密码:");
        jl1.setBounds(75, 20, 60, 25);
        jl1.setFont(MyFont.f1);

        jl2 = new JLabel("新密码:");
        jl2.setFont(MyFont.f1);
        jl2.setBounds(75, 50, 60, 25);

        jl3 = new JLabel("再次输入新密码:");
        jl3.setFont(MyFont.f1);
        jl3.setBounds(15, 80, 120, 25);

        jtf1 = new JPasswordField(20);
        jtf1.setBounds(140, 18, 130, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf2 = new JPasswordField(  20);
        jtf2.setBounds(140, 48, 130, 25);
        jtf2.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf3 = new JPasswordField(20);
        jtf3.setBounds(140, 78, 130, 25);
        jtf3.setBorder(BorderFactory.createLoweredBevelBorder());

        jb1 = new JButton("修 改");
        jb1.setFont(MyFont.f1);
        jb1.setBounds(45, 120, 80, 25);
        jb1.addActionListener(this);

        jb2 = new JButton("取 消");
        jb2.setFont(MyFont.f1);
        jb2.setBounds(225, 120, 80, 25);
        jb2.addActionListener(this);

        jb3 = new JButton("清 除");
        jb3.setFont(MyFont.f1);
        jb3.setBounds(135, 120, 80, 25);
        jb3.addActionListener(this);

        //设置窗体的默认布局为空
        //将组件添加到窗体中
        this.setLayout(null);
        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jtf2);
        this.add(jl3);
        this.add(jtf3);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
    }

    public ModifyPassword(Frame Main, String title, boolean model) {
        //调用父类的构造方法，实现模式对话
        super(Main, title, model);

        //调用修改学生,老师密码的界面的方法
        this.MP();

        //设置窗体的属性
        this.setSize(365, 200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
        //当点击了修改按钮
        if (e.getSource() == jb1) {
            //获取数据体登录账号的密码
            String sql1 ="select password from login where userId='"+loginModel.a+"'";
            sqlConn = new SqlConn();
            rs = sqlConn.sqlQuery(sql1);
           //遍历获得密码，不能直接查询来获取密码
            try {
                while (rs.next()){
                    OriginPsw = rs.getString(1);
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
            //获取文本框的信息
            String Psw = new String(jtf1.getPassword()).trim();
            String NewPaw = new String(jtf2.getPassword()).trim();
            String AgainPsw = new String(jtf3.getPassword()).trim();

            if (Psw.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入原密码！", "警告", 2);
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            if (NewPaw.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入新密码！", "提示", 1);
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            if (AgainPsw.equals("")) {
                JOptionPane.showMessageDialog(this, "请再次输入新密码", "提示", 1);
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            if (!(NewPaw.equals(AgainPsw))) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不一致", "警告", 2);
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            if (!(OriginPsw.equals(Psw))) {
                JOptionPane.showMessageDialog(this, "原密码错误", "警告", 2);
                return;//返回到输入界面，如果没有return语句，则会回到主界面
            }
            //调用数据库连接
            //设置操纵更新的sql语句
            Object[] options = {"确定退出", "取消修改"};
            int respose = JOptionPane.showOptionDialog(this, "修改成功，请您重新登录", "提示", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
            if (respose == 0) {
                String sql = "update login set password='"+NewPaw+"' where userId='"+loginModel.a+"'";
                SqlConn sqlconn = new SqlConn();
                sqlconn.sqlUpdate(sql);
                //关闭数据库连接
                sqlconn.closeSqlConn();
                //关闭对话框
                i=0;
                this.dispose();
            } else if (respose == 1) {
                return;
            }
        }
        //如果点击了取消按钮，则关闭模式对话框
        else if (e.getSource() == jb2) {
            this.dispose();
        }
        //如果点击了清除按钮，则清除所有的广本框的内容
        else if (e.getSource() == jb3) {
            //由于学号是主键，则不能修改！
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
        }
    }
}
