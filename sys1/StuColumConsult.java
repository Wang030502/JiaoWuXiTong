package sys1;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//学生课表查询
public class StuColumConsult extends JDialog implements ActionListener {

    //定义查询所需要的面板和组件
    JPanel jp1;
    JLabel jp1_jl1, jp1_jl2;
    JTextField jp1_jtf1;
    JButton jp1_jb1, jp1_jb2;
    JTable jtb;
    JScrollPane jsp;
    TableModel tm;
    int m;//将输入的周次转为数字
    int i;//奇数周和偶数周的课表相同
    JComboBox cmb2 = new JComboBox();

    public StuColumConsult(Frame Main, String title, boolean model) {
        //调用父类的构造方法，实现模式对话
        super(Main, title, model);
        jp1 = new JPanel();
        jp1_jl1 = new JLabel("请输入学号：");
        jp1_jl1.setFont(MyFont.f1);

        jp1_jtf1 = new JTextField(10);
        jp1_jl2 = new JLabel("请选择周次：");
        jp1_jl2.setFont(MyFont.f1);

        jp1_jb1 = new JButton("查 询");
        jp1_jb1.setFont(MyFont.f1);
        jp1_jb1.addActionListener(this);

        jp1_jb2 = new JButton("清 除");
        jp1_jb2.setFont(MyFont.f1);
        jp1_jb2.addActionListener(this);

        cmb2.addItem("--请选择--");
        cmb2.addItem("第一周");
        cmb2.addItem("第二周");
        cmb2.addItem("第三周");
        cmb2.addItem("第四周");
        cmb2.addItem("第五周");
        cmb2.addItem("第六周");
        cmb2.addItem("第七周");
        cmb2.addItem("第八周");
        cmb2.addItem("第九周");
        cmb2.addItem("第十周");
        cmb2.addItem("第十一周");
        cmb2.addItem("第十二周");
        cmb2.addItem("第十三周");
        cmb2.addItem("第十四周");
        cmb2.addItem("第十五周");
        cmb2.addItem("第十六周");
        cmb2.addItem("第十七周");
        cmb2.addItem("第十八周");

        //添加
        jp1.add(jp1_jl1);
        jp1.add(jp1_jtf1);
        jp1.add(jp1_jl2);
        jp1.add(cmb2);
        JLabel JL = new JLabel("    ");
        jp1.add(JL);//两个按钮直接的空隙
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);

        jtb = new JTable();
        jsp = new JScrollPane(jtb);
        this.add(jp1, "North");
        this.add(jsp, "Center");

        //小图标
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\查询.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\清除.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);

        jp1_jb1.setIcon(bi1);
        jp1_jb2.setIcon(bi2);

        this.setSize(700, 400);
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
        if (arg0.getSource() == jp1_jb1) {
            //获取文本框的值
            String Id = jp1_jtf1.getText().trim();//其中trim()是去掉文本框前面可能有的空格，但不能去掉字符串中的空格
            String Week = (String) cmb2.getSelectedItem();

            if (Id.equals("") && Week.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入学号和周次", "提示", 1);
                return;
            } else if (Id.equals("")) {
                JOptionPane.showMessageDialog(this, "请输入学号", "提示", 1);
                return;
            } else if (Week.equals("--请选择--")) {
                JOptionPane.showMessageDialog(this, "请选择周次", "提示", 1);
                return;
            } else if (Id.length() < 11) {
                JOptionPane.showMessageDialog(this, "您输入的学号有误", "提示", 1);
                return;
            } else {
                if(Week.equals("第一周")||Week.equals("第三周")||Week.equals("第五周")||Week.equals("第七周")||Week.equals("第九周")||Week.equals("第十一周")||Week.equals("第十三周")||Week.equals("第十五周")||Week.equals("第十七周")){
                    i=1;
                }else {
                    i = 2;
                }
                tm = new MyColumTableModel(null, Week,i);
                jtb.setModel(tm);
            }
        } else if (arg0.getSource() == jp1_jb2) {
            jp1_jtf1.setText("");
        }
    }
}



