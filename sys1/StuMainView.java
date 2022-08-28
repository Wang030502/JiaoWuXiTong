package sys1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;

public class StuMainView extends JFrame implements ActionListener {
    //定义菜单需要要的组件
    JMenuBar jmb;
    JMenu jm1, jm2, jm3, jm4;
    JMenuItem jm1_0, jm1_1, jm2_0, jm2_1, jm2_2, jm4_1, jm4_2, jm4_3;
    JMenuItem jm3_1, jm3_2;
    private Timer time;
    JLabel timelabel;

    //定义一个表格，用于显示课程信息
    JTable jtb;
    //定义一个滚动面板，用于存放表格
    JScrollPane jsp;

    //定义一个表格模型，用于更新表数据
    TableModel tm;

    //我的信息
    ShowStuMessageModel myms;

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
        jm1.add(jm1_0);
        jm1.addSeparator();
        jm1.add(jm1_1);

        jm2 = new JMenu("选课管理");
        jm2.setFont(MyFont.f1);
        jm2_0 = new JMenuItem("<-我的课程->");
        jm2_0.addActionListener(this);
        jm2_0.setFont(MyFont.f2);
        jm2_1 = new JMenuItem("<-在线选课->");
        jm2_1.addActionListener(this);
        jm2_1.setFont(MyFont.f2);
        jm2_2 = new JMenuItem("<-修改选课->");
        jm2_2.addActionListener(this);
        jm2_2.setFont(MyFont.f2);

        jm2.add(jm2_0);
        jm2.addSeparator();
        jm2.add(jm2_1);
        jm2.add(jm2_2);

        jm4 = new JMenu("我的课表");
        jm4.setFont(MyFont.f1);
        jm4_1 = new JMenuItem("<-学期理论课表->");
        jm4_1.addActionListener(this);
        jm4_1.setFont(MyFont.f2);
        jm4_2 = new JMenuItem("<-教室课表查询->");
        jm4_2.addActionListener(this);
        jm4_2.setFont(MyFont.f2);
        jm4_3 = new JMenuItem("<-停课查询->");
        jm4_3.addActionListener(this);
        jm4_3.setFont(MyFont.f2);
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

        //添加组件
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
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\系统设置.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\我的信息_基本信息.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\修改密码.png");
        ImageIcon bi4 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\课程表.png");
        ImageIcon bi5 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\课表信息.png");
        ImageIcon bi6 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\教室.png");
        ImageIcon bi7 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\停课.png");
        ImageIcon bi8 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\选课_线性.png");
        ImageIcon bi9 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\我的课程.png");
        ImageIcon bi10 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\已选课程.png");
        ImageIcon bi11 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\选课.png");
        ImageIcon bi12 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\系统.png");
        ImageIcon bi13 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\退出登录.png");
        ImageIcon bi14 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\退出系统.png");

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

        //将图片加入到内容中去
        jm3.setIcon(bi1);//系统设置
        jm3_1.setIcon(bi2);
        jm3_2.setIcon(bi3);
        jm4.setIcon(bi4);//我的课表
        jm4_1.setIcon(bi5);
        jm4_2.setIcon(bi6);
        jm4_3.setIcon(bi7);
        jm2.setIcon(bi8);//选课管理
        jm2_0.setIcon(bi9);//我的课程
        jm2_1.setIcon(bi10);//在线选课
        jm2_2.setIcon(bi11);//修改选课
        jm1.setIcon(bi12);
        jm1_0.setIcon(bi13);
        jm1_1.setIcon(bi14);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StuMainView manageview = new StuMainView();
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

    public StuMainView() {
        //调用时间
        getTimelabel();
        //调用菜单函数
        this.menuInit();

        //当登陆进入界面时，最初显示的界面
        jtb = new JTable();
        //在刚登陆进去的时候不让数据显示出来，如果即时显示，当数据量大时，影响速度，也不太符合常规，因此这时不显示数据
        jsp = new JScrollPane(jtb);
        this.add(jsp, "Center");


        //设置窗体属性
        this.setSize(900, 500);
        this.setTitle("南华大学教务系统-->学生端");
        //设置窗口的初始位置
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x则退出程序

        //登录时弹出
        JOptionPane.showMessageDialog(this, "欢迎登录", "提示", 1);

        //try——catch来设置左上角小图标
        try {
            this.setIconImage(ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\index8.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //设置可见
        this.setVisible(true);

    }


    //*************************事件响应***********************//
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        //退出系统
        if (arg0.getSource() == jm1_1) {
            Object[] options = {"确定", "取消"};
            int respose = JOptionPane.showOptionDialog(this, "你确认要退出系统吗？", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                System.exit(0);//虚拟机退出系统
            } else if (respose == 1) {
                return;
            }
        }
        //退出登录
        else if (arg0.getSource() == jm1_0) {
            Object[] options = {"确定", "取消"};
            int respose = JOptionPane.showOptionDialog(this, "你确认要退出登录吗？", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                this.dispose();
                new Login();
            } else if (respose == 1) {
                return;
            }
        }
        //我的课表
        else if (arg0.getSource() == jm4_1) {
            MyColum MC = new MyColum(this, "我的课表", true);
        }
        //我的信息
        else if (arg0.getSource() == jm3_1) {
            myms = new ShowStuMessageModel(null, loginModel.a);
            jtb.setModel(myms);
            //让表格显示学生信息
            jtb.setVisible(true);
        }
        //修改密码
        else if (arg0.getSource() == jm3_2) {
            ModifyPassword ModifyStu = new ModifyPassword(this, "修改密码信息", true);
            if (ModifyPassword.i == 0) {//i记录是否修改成功
                this.dispose();
                new Login();
            }
        }
        //在线选课
        else if (arg0.getSource() == jm2_1) {
            OnlineClass OC = new OnlineClass(this, "在线选课", true);
            if (OnlineClass.i == 1) {
                //更新当前窗口的信息，以便添加信息后就能看到新信息
                tm = new OnlineClassModel(null);
                jtb.setModel(tm);
            } else {
                //不更新数据
            }
        }
        //我的课程
        else if (arg0.getSource() == jm2_0) {
            tm = new SelectColumTableModel(null);
            jtb.setModel(tm);
            //让表格显示学生信息
            jtb.setVisible(true);
        }
        //修改选课
        else if (arg0.getSource() == jm2_2) {
            ModifyClass OC = new ModifyClass(this, "修改选课", true);
            if (ModifyClass.i == 1) {
                //更新当前窗口的信息，以便添加信息后就能看到新信息
                tm = new SelectColumTableModel(null);
                jtb.setModel(tm);
            } else {
                //不更新数据
            }
        }
        //教室课表查询
        else if (arg0.getSource() == jm4_2) {
            ClassColumSelect CCS = new ClassColumSelect(this, "教室课表查询", true);
        }
        //停课查询
        else if (arg0.getSource() == jm4_3) {
            StopClass SC = new StopClass(this, "停课查询", true);
        }
    }
}


