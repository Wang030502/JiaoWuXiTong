package sys1;

import SqlConnection.SqlConn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeacherView extends JFrame implements ActionListener {
    //定义菜单需要要的组件
    JMenuBar jmb;
    JMenu jm1, jm2, jm3, jm4;
    JMenuItem jm1_0, jm1_1, jm2_1, jm2_2, jm2_3, jm2_4, jm2_5;
    JMenuItem jm3_1, jm3_2, jm4_1, jm4_2, jm4_3, jm4_4;
    private Timer time;
    JLabel timelabel;

    //定义一个表格，用于显示学生信息
    JTable jtb;
    //定义一个滚动面板，用于存放表格
    JScrollPane jsp;

    //定义一个表格模型，用于更新表数据
    ShowStuMessageModel tm;
    ShowTchMessageModel stmm;


    //把菜单封装成一个函数
    public void menuInit() {
        jm1 = new JMenu("系统");
        jm1.setFont(MyFont.f1);

        jm1_0 = new JMenuItem("<-退出登录->");
        jm1_1 = new JMenuItem("<-退出系统->");
        jm1_0.addActionListener(this);
        jm1_1.addActionListener(this);
        jm1_0.setFont(MyFont.f2);
        jm1_1.setFont(MyFont.f2);

        //添加到窗体
        jm1.add(jm1_0);
        jm1.add(jm1_1);

        jm2 = new JMenu("学生管理");
        jm2.setFont(MyFont.f1);

        jm2_1 = new JMenuItem("<-学生列表->");
        jm2_1.addActionListener(this);
        jm2_1.setFont(MyFont.f2);

        jm2_2 = new JMenuItem("<-查找学生->");
        jm2_2.addActionListener(this);
        jm2_2.setFont(MyFont.f2);

        jm2_3 = new JMenuItem("<-修改学生->");
        jm2_3.addActionListener(this);
        jm2_3.setFont(MyFont.f2);

        jm2_4 = new JMenuItem("<-添加学生->");
        jm2_4.addActionListener(this);
        jm2_4.setFont(MyFont.f2);

        jm2_5 = new JMenuItem("<-删除学生->");
        jm2_5.addActionListener(this);
        jm2_5.setFont(MyFont.f2);

        //添加到窗体
        //查找，添加，修改，删除
        jm2.add(jm2_1);
        jm2.add(jm2_2);
        jm2.add(jm2_4);
        jm2.add(jm2_3);
        jm2.add(jm2_5);

        jm4 = new JMenu("课程管理");
        jm4.setFont(MyFont.f1);

        jm4_1 = new JMenuItem("<-课程请假->");
        jm4_1.setFont(MyFont.f2);
        jm4_1.addActionListener(this);

        jm4_2 = new JMenuItem("<-学生课表查询->");
        jm4_2.setFont(MyFont.f2);
        jm4_2.addActionListener(this);

        jm4_3 = new JMenuItem("<-教室课表查询->");
        jm4_3.setFont(MyFont.f2);
        jm4_3.addActionListener(this);

        jm4_4 = new JMenuItem("<-我的课表->");
        jm4_4.setFont(MyFont.f2);
        jm4_4.addActionListener(this);

        //添加到窗体
        jm4.add(jm4_4);
        jm4.add(jm4_1);
        jm4.add(jm4_2);
        jm4.add(jm4_3);

        jm3 = new JMenu("系统设置");
        jm3.setFont(MyFont.f1);

        jm3_1 = new JMenuItem("<-我的信息->");
        jm3_1.setFont(MyFont.f2);
        jm3_1.addActionListener(this);

        jm3_2 = new JMenuItem("<-修改密码->");
        jm3_2.setFont(MyFont.f2);
        jm3_2.addActionListener(this);

        //添加到窗体
        jm3.add(jm3_1);
        jm3.add(jm3_2);

        //设置菜单条
        jmb = new JMenuBar();
        //把菜单添加到菜单条
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm4);
        jmb.add(jm3);
        //把时间显示在最右边，不会其他的方法哈哈
        JLabel jLabel = new JLabel("                                                                                                  ");
        jmb.add(jLabel);
        jmb.add(timelabel);
        //把菜单条添加到窗体
        this.setJMenuBar(jmb);


        //小图标
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\系统.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\退出登录.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\退出系统.png");
        ImageIcon bi4 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\在籍学生管理.png");
        ImageIcon bi5 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\学生列表.png");
        ImageIcon bi6 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\查找用户.png");
        ImageIcon bi7 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\添加学生.png");
        ImageIcon bi8 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\修改用户信息.png");
        ImageIcon bi9 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\删除用户.png");
        ImageIcon bi10 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\课程管理.png");
        ImageIcon bi11 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\我的课程.png");
        ImageIcon bi12 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\请假.png");
        ImageIcon bi13 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\查询学生课表.png");
        ImageIcon bi14 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\教室.png");
        ImageIcon bi15 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\系统设置.png");
        ImageIcon bi16 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\我的信息_基本信息.png");
        ImageIcon bi17 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\修改密码.png");

        //图片缩放
        ScalePhoto(bi1, 15, 15);
        ScalePhoto(bi2, 15, 15);
        ScalePhoto(bi3, 15, 15);
        ScalePhoto(bi4, 15, 15);
        ScalePhoto(bi5, 15, 15);
        ScalePhoto(bi6, 15, 15);
        ScalePhoto(bi7, 15, 15);
        ScalePhoto(bi8, 15, 15);
        ScalePhoto(bi9, 15, 15);
        ScalePhoto(bi10, 15, 15);
        ScalePhoto(bi11, 15, 15);
        ScalePhoto(bi12, 15, 15);
        ScalePhoto(bi13, 15, 15);
        ScalePhoto(bi14, 15, 15);
        ScalePhoto(bi15, 15, 15);
        ScalePhoto(bi16, 15, 15);
        ScalePhoto(bi17, 15, 15);

        //将图片加入到内容中去
        jm1.setIcon(bi1);//系统
        jm1_0.setIcon(bi2);
        jm1_1.setIcon(bi3);
        jm2.setIcon(bi4);//学生管理
        jm2_1.setIcon(bi5);
        jm2_2.setIcon(bi6);
        jm2_4.setIcon(bi7);
        jm2_3.setIcon(bi8);
        jm2_5.setIcon(bi9);
        jm4.setIcon(bi10);//课程管理
        jm4_4.setIcon(bi11);//我的课表
        jm4_1.setIcon(bi12);//课程请假
        jm4_2.setIcon(bi13);//学生课表查询
        jm4_3.setIcon(bi14);//教室课表查询
        jm3.setIcon(bi15);//系统设置
        jm3_1.setIcon(bi16);
        jm3_2.setIcon(bi17);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TeacherView();
    }

    //小图标缩小
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    //时间显示
    private JLabel getTimelabel() {
        if (timelabel == null) {
            timelabel = new JLabel("");
            timelabel.setBounds(5, 65, 200, 20);
            timelabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
            timelabel.setForeground(new Color(14, 13, 13, 255));
            time = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    timelabel.setText(new SimpleDateFormat("yyyy年MM月dd日 EEEE HH:mm:ss").format(new Date()));
                }
            });
            time.start();
        }
        return timelabel;
    }

    public TeacherView() {
        //调用时间
        getTimelabel();
        //调用菜单函数
        this.menuInit();

        //当登陆进入界面时，最初显示的界面
        jtb = new JTable();

        //在刚登陆进去的时候不让数据显示出来，如果即时显示，当数据量大时，影响速度，也不太符合常规 ，因此在这里不用更新数据模型
        jsp = new JScrollPane(jtb);
        this.add(jsp, "Center");

        //设置窗体属性
        this.setSize(900, 500);
        this.setTitle("南华大学教务系统-->教师端");

        //登录时弹出
        JOptionPane.showMessageDialog(this, "欢迎登录", "提示", 1);

        //设置窗口的初始位置
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//单机X退出

        //左上角小图标
        try {
            this.setIconImage(ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\index8.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
        //退出系统
        if (arg0.getSource() == jm1_1) {
            Object[] options = {"确定", "取消"};
            int respose = JOptionPane.showOptionDialog(this, "你确认要退出系统吗？", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                System.exit(0);//退出系统
            } else if (respose == 1) {
                return;
            }
        }
        //退出登录
        else if (arg0.getSource() == jm1_0) {
            Object[] options = {"确定", "取消"};
            int respose = JOptionPane.showOptionDialog(this, "你确认要退出登录吗？", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                this.dispose();//关闭当前
                new Login();//创建新的登录界面
            } else if (respose == 1) {
                return;
            }
        }
        //学生列表
        else if (arg0.getSource() == jm2_1) {
            tm = new ShowStuMessageModel(null);
            jtb.setModel(tm);
            //让表格显示学生信息
            jtb.setVisible(true);
        }
        //查找学生
        else if (arg0.getSource() == jm2_2) {
            FindStu ST = new FindStu(this, "学生信息查询", true);
            //this是显示于当前窗口之上，第二个标题，true代表模式对话框
        }
        //添加学生
        else if (arg0.getSource() == jm2_4) {
            AddStu addstu = new AddStu(this, "添加学生信息", true);
            if (addstu.falg() == 1) {
                //更新当前窗口的学生信息，以便添加学生信息后就能看到新信息
                tm = new ShowStuMessageModel(null);
                jtb.setModel(tm);
            } else {
                //不更新数据
            }
        }
        //修改学生
        else if (arg0.getSource() == jm2_3) {
            //先判断是否选择了一行，没有选中，则返回-1，如果选中，则返回选中的那一行的序号，也就是第几行
            int rowNo = jtb.getSelectedRow();
            if (rowNo == -1) {
                //没有选中，提示信息
                JOptionPane.showMessageDialog(this, "你没有选中一行！");
                return;
            } else {
                //得到选择的那一行的学号
                //String stuId=(String)tm.getValueAt(rowNo, 0);//学号是字符串，因些得转型
                //需要把当前的这个数据模型和所选择的那一行的序号传过去
                UpdateStu updateStu = new UpdateStu(this, "修改学生信息", tm, rowNo, true);
                //更新当前窗口的学生信息，以便更新学生信息后就能看到新信息
                tm = new ShowStuMessageModel(null);
                jtb.setModel(tm);
            }
        }
        //删除学生
        else if (arg0.getSource() == jm2_5) {
            //到得某一行，即选择的那一行
            int rowNo = jtb.getSelectedRow();
            //判断是否已经选择一行，如果没有选择，则弹出一个对话框，当等于-1时，表示没有选择
            if (rowNo == -1) {
                JOptionPane.showMessageDialog(this, "你没有选择一行！", "提示", 1);
                return;
            } else {
                //得到选择的那一行的学号
                String stuId = (String) tm.getValueAt(rowNo, 0);//某一行的第0列就是学号，因为得到的学号是字符串，所以得转型
                String sql = "delete from stuMessage where Id='" + stuId + "'";
                Object[] options = {"确定", "取消"};
                int respose = JOptionPane.showOptionDialog(this, "你确认要删除该学生吗？", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (respose == 0) {
                    //连接数据库
                    SqlConn sqlconn = new SqlConn();
                    sqlconn.sqlDelete(sql);
                    //注意：********这在里必须调用关闭数据库连接的方法，在这里，如果没有关闭资源，则表模型无法更新成功，切记！！！！！
                    sqlconn.closeSqlConn();
                    tm = new ShowStuMessageModel(null);
                    jtb.setModel(tm);
                } else if (respose == 1) {
                    return;
                }
            }
        }
        //我的信息
        else if (arg0.getSource() == jm3_1) {
            stmm = new ShowTchMessageModel(null, loginModel.a);
            jtb.setModel(stmm);
            //让表格显示教师信息
            jtb.setVisible(true);
        }
        //修改密码
        else if (arg0.getSource() == jm3_2) {
            ModifyPassword ModifyTch = new ModifyPassword(this, "修改密码信息", true);
            if (ModifyPassword.i == 0) {//i记录是否修改成功
                this.dispose();
                new Login();
            }
        }
        //教室课表查询
        else if (arg0.getSource() == jm4_3) {
            ClassColumSelect CCS = new ClassColumSelect(this, "教室课表查询", true);
        }
        //学生课表查询
        else if (arg0.getSource() == jm4_2) {
            StuColumConsult SCC = new StuColumConsult(this, "学生课表查询", true);
        }
        //我的课表
        else if (arg0.getSource() == jm4_4) {
            TeacherColum TC = new TeacherColum(this, "我的课表", true);
        }
        //课程请假
        else if (arg0.getSource() == jm4_1) {
            ColumLeave CL = new ColumLeave(this, "课程请假", true);
        }
    }
}
