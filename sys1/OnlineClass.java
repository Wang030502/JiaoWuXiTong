package sys1;
//在线选课窗口

import SqlConnection.SqlConn;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineClass extends JDialog implements ActionListener {

    JPanel jp;
    JButton jb1, jb2;
    TableModel tm;
    JTable jtb;
    JScrollPane jsp;
    public static int i = 0;//用于判断是否选择了该课程，然后表立马更新

    public void addView() {
        jb1 = new JButton("选 择");
        jb1.setFont(MyFont.f1);
        jb1.setSize(80, 25);
        jb1.addActionListener(this);

        jb2 = new JButton("取 消");
        jb2.setFont(MyFont.f1);
        jb2.setSize(80, 25);
        jb2.addActionListener(this);

        JLabel jl = new JLabel("         ");
        jp = new JPanel();
        jp.add(jb1);
        jp.add(jl);
        jp.add(jb2);

        //添加到窗口
        this.add(jp, BorderLayout.SOUTH);
        this.add(jsp, "Center");

        //小图标
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\选择.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\取消.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi2);
    }

    public OnlineClass(Frame Main, String title, boolean model) {
        //调用父类的构造方法，实现模式对话
        super(Main, title, model);
        //设置窗体的属性
        jtb = new JTable();
        tm = new OnlineClassModel(null);
        jtb.setModel(tm);
        //让表格显示信息
        jtb.setVisible(true);
        jsp = new JScrollPane(jtb);
        //调用信息界面的的方法
        this.addView();

        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
    //小图标缩小
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == jb1) {
            //到得某一行，即选择的那一行
            int rowNo = jtb.getSelectedRow();
            //判断是否已经选择一行，如果没有选择，则弹出一个对话框，当等于-1时，表示没有选择
            if (rowNo == -1) {
                JOptionPane.showMessageDialog(this, "你没有选择一行！", "提示", 1);
                return;
            } else {
                //获取某行某列的数据
                String Remain = (String) tm.getValueAt(rowNo, 5);//某一行的第5列就是剩余数
                int s = Integer.parseInt(Remain);//转型String---int
                String Colum = (String) tm.getValueAt(rowNo, 0);//某一行的第0列就是课程名称
                String Teacher = (String) tm.getValueAt(rowNo, 1);
                String Place = (String) tm.getValueAt(rowNo, 2);
                String Week = (String) tm.getValueAt(rowNo, 3);
                String Source = (String) tm.getValueAt(rowNo, 4);
                int s2 = Integer.parseInt(Source);
                String All = (String) tm.getValueAt(rowNo, 6);
                int s3 = Integer.parseInt(All);
                String Nature = "公选";//你选择的课程属性都为公选

                Object[] options = {"确定", "取消"};
                int respose = JOptionPane.showOptionDialog(this, "确认选择该课程吗？", "提示", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
                if (respose == 0) {
                    if (s <= 0) {
                        JOptionPane.showMessageDialog(this, "该课程人数已满","提示",1);
                    } else {
                        this.i = 1;
                        //连接数据库
                        SqlConn sqlconn = new SqlConn();
                        //注意：********这在里必须调用关闭数据库连接的方法，在这里，如果没有关闭资源，则表模型无法更新成功，切记！！！！！
                        String sql = "insert into ModifyClass values('" + Colum + "','" + Teacher + "','" + Place + "','" + Week + "','" + s2 + "','" + (s - 1) + "','" + s3 + "')";
                        sqlconn.sqlUpdate(sql);//调用数据库
                        sql = "insert into selectColum values('" + Colum + "','" + Teacher + "','" + Place + "','" + Week + "','" + Source + "','" + Nature + "')";
                        sqlconn.sqlUpdate(sql);
                        sql = "delete from OnlineClass where Colum='" + Colum + "'";
                        sqlconn.sqlDelete(sql);
                        sqlconn.closeSqlConn();//关闭数据库
                        tm = new OnlineClassModel(null);
                        jtb.setModel(tm);
                    }
                } else if (respose == 1) {
                    return;
                }
            }
        } else if (arg0.getSource() == jb2) {
            this.dispose();
        }
    }
}