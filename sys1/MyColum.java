package sys1;
//每周课表都不一样


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyColum extends JDialog implements ActionListener {
    JPanel jp;
    JButton jb1, jb2;
    TableModel tm;
    JTable jtb;
    JScrollPane jsp;
    public static int i = 1;//奇数周课表与偶数周课表相同
    int m = 1;//记录是第几周课表

    public void addView() {
        jb1 = new JButton("上一周");
        jb1.setFont(MyFont.f1);
        jb1.setSize(80, 25);
        jb1.addActionListener(this);

        jb2 = new JButton("下一周");
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
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\上一个.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\下一个.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi2);
        jb2.setHorizontalTextPosition(JButton.LEFT);//将图标放在右边

    }



    public MyColum(Frame Main, String title, boolean model) {
        //调用父类的构造方法，实现模式对话
        super(Main, title, model);
        //设置窗体的属性
        jtb = new JTable();
        tm = new MyColumTableModel(null, i, m);//进去先显示第一周的
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
        //点击下一周
        if (arg0.getSource() == jb2) {
            if (m > 17) {
                //课表显示最多18周
                JOptionPane.showMessageDialog(this, "无法再下一周", "警告", 2);
                return;
            } else {
                ++m;//第m周
                ++i;//奇数周或者偶数周
                if (i % 2 == 0) {//偶数周课表
                    i = 2;
                }
                if (i % 2 == 1) {//奇数周课表
                    i = 1;
                }
                tm = new MyColumTableModel(null, i, m);//i代表奇数周还是偶数周，m代表第几周
                jtb.setModel(tm);
            }
        }//当你点击上一周
        else if (arg0.getSource() == jb1) {
            if (m <= 1) {
                JOptionPane.showMessageDialog(this, "无法再上一周", "警告", 2);
                return;
            } else {
                --i;
                --m;
                if (i % 2 == 0) {//偶数周课表
                    i = 2;
                }
                if (i % 2 == 1) {//奇数周课表
                    i = 1;
                }
                tm = new MyColumTableModel(null, i, m);
                //更新表结构
                jtb.setModel(tm);
            }
        }
    }
}