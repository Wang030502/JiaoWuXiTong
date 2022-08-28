package sys1;

import javax.swing.*;
import java.awt.event.ActionListener;

import SqlConnection.SqlConn;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
    //定义登陆窗口需要的组件
    JLabel jl1, jl2;
    JTextField jtf1;
    JPasswordField jpf1;
    JButton jb1, jb2;

    //定义用于连接数据库的组件，也就是com.SqlConnection类下的SqlConn方法
    SqlConn sqlconn;
    //定义用于传送SQL语句的变量
    String sql;
    //定义一个用于接收登陆验证返回来的记录集
    ResultSet rs;
    //声明用于验证登陆用户的模型
    loginModel loginModel;
    int flag;

    public static void main(String[] args) {
        Login login = new Login();
    }

    public Login() {

        //创建登陆所需的组件
        jl1 = new JLabel("账 号：");
        jl1.setFont(MyFont.f1);
        jl1.setBounds(50, 50, 60, 25);

        jl2 = new JLabel("密 码：");
        jl2.setFont(MyFont.f1);
        jl2.setBounds(50, 90, 60, 25);

        jtf1 = new JTextField(20);
        jtf1.setBounds(110, 50, 150, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());//设置文本框下凹，三维效果

        jpf1 = new JPasswordField(20);
        jpf1.setBorder(BorderFactory.createLoweredBevelBorder());
        jpf1.setBounds(110, 90, 150, 25);

        jb1 = new JButton("登 陆");
        jb1.setFont(MyFont.f1);
        jb1.addActionListener(this);
        jb1.setBounds(85, 130, 75, 25);

        jb2 = new JButton("退出");
        jb2.setFont(MyFont.f1);
        jb2.addActionListener(this);
        jb2.setBounds(175, 130, 75, 25);

        //设置凸起来的效果
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());

        //添加到窗体
        //先设置窗体的空布局
        this.setLayout(null);
        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jpf1);
        this.add(jb1);
        this.add(jb2);

        //创建一个BackImage对象
        BackImage bi = new BackImage();
        //设定图片的位置
        bi.setBounds(0, 0, 350, 250);
        this.add(bi);
        this.setSize(350, 250);
        this.setTitle("南华大学教务系统");
        //设置窗口在屏幕的初始位置,为中间
        this.setLocationRelativeTo(null);
        //设置窗口不可改变大小
        this.setResizable(false);
        //注意：************设置窗口的背景颜色，由于是继承Swing包，所以必须先得到窗口的一个面板，然后再通过这个面板去设置背景色，否则设置不显示出来
        //this.getContentPane().setBackground(Color.gray);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x则退出程序

        //左上角小图标
        try {
            this.setIconImage(ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\index8.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    //创建一个内部类，并继承JPanle，用于画背景图片
    class BackImage extends JPanel {
        Image im;

        public BackImage() {
            try {
                im = ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\Login.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //要把图片画到JPanle，需要重写一个Paint方法
        public void paint(Graphics g) //此处的paint中的p是小写，
        //如果是大写，则就是重写paint方法了，而是一个新的方法了，那么后面的图片是不会输出的
        {
            g.drawImage(im, 0, 0, 350, 250, this);
        }
    }

    //监听器
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //如果说点击了登陆按钮
        if (e.getSource() == jb1) {
            //获取输入的用户名和密码
            //trim()：去除字符串里的空格
            String userId = jtf1.getText().trim();//获取登录账号
            System.out.println("userId=" + userId);//打印在显示台
            String password = new String(jpf1.getPassword());
            //此处不能通过getText()来获取，从安全角度考虑，通过getPassword()来获取，即可通过new String这便是数组
            System.out.println("password=" + password);//打印在显示台

            if ((userId.equals("") || userId == null) && (password.equals("") || password == null)) {
                JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "提示", 2);
            } else {
                if (userId.equals("") || userId == null) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示", 2);
                } else if (password.equals("") || password == null) {
                    JOptionPane.showMessageDialog(null, "密码不能为空！", "提示", 2);
                } else {
                    //调用处理登陆用户验证的模型
                    loginModel = new loginModel();
                    flag = loginModel.checkUser(userId, password);//检查账号密码是对应的是学生还是老师
                    //判断用户名和密码是否正确
                    if (flag == 0) {
                        //0为教师窗口
                        new TeacherView();//创建教师窗口
                        this.dispose();//关闭当前窗口
                    }
                    if (flag == 1) {
                        //1为学生窗口
                        new StuMainView();
                        this.dispose();
                    }
                    if (flag == 2) {
                        JOptionPane.showMessageDialog(this, "用户名或密码错误！", "警告", 2);
                    }
                }
            }
        }//退出按钮
        else if (e.getSource() == jb2) {
            Object[] options = {"确定", "取消"};
            int respose = JOptionPane.showOptionDialog(this, "你确认要退出系统吗？", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                System.out.println("你按下了确认按钮！");
                System.exit(0);//退出系统
            } else if (respose == 1) {
                System.out.println("你按下了取消按钮！");
                return;
            }
        }
    }
}
