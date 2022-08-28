package sys1;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//教室课表查询
public class ClassColumSelect extends JDialog implements ActionListener {
    //定义查询所需要的面板和组件
    JPanel jp1;
    JLabel jp1_jl1, jp1_jl2, jp2_jl1, jp2_jl2;
    JTextField jp1_jtf1, jp1_jtf2;
    JButton jp1_jb1, jp1_jb2, jp1_jb3;
    JTable jtb;
    JScrollPane jsp;
    TableModel tm;
    JComboBox cmb = new JComboBox();
    JComboBox cmb2 = new JComboBox();

    public ClassColumSelect(Frame Main, String title, boolean model) {
        //调用父类的构造方法，实现模式对话
        super(Main, title, model);
        jp1 = new JPanel();

        jp1_jl1 = new JLabel("请输入教学楼：");
        jp1_jl1.setFont(MyFont.f1);

        jp1_jtf1 = new JTextField(10);

        jp1_jl2 = new JLabel("请输入教室：");
        jp1_jl2.setFont(MyFont.f1);

        jp1_jtf2 = new JTextField(10);

        jp2_jl1 = new JLabel("请选择周次：");
        jp2_jl1.setFont(MyFont.f1);

        jp2_jl2 = new JLabel("请选择星期：");
        jp2_jl2.setFont(MyFont.f1);

        jp1_jb1 = new JButton("查 询");
        jp1_jb1.setFont(MyFont.f1);
        jp1_jb1.addActionListener(this);

        jp1_jb2 = new JButton("清 除");
        jp1_jb2.setFont(MyFont.f1);
        jp1_jb2.addActionListener(this);

        jp1_jb3 = new JButton("显示所有课程");
        jp1_jb3.setFont(MyFont.f1);
        jp1_jb3.addActionListener(this);

        cmb.addItem("--请选择--");
        cmb.addItem("星期一");
        cmb.addItem("星期二");
        cmb.addItem("星期三");
        cmb.addItem("星期四");
        cmb.addItem("星期五");
        cmb.addItem("星期六");
        cmb.addItem("星期天");

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

        jp1.add(jp1_jl1);
        jp1.add(jp1_jtf1);
        jp1.add(jp1_jl2);
        jp1.add(jp1_jtf2);
        jp1.add(jp2_jl1);
        jp1.add(cmb2);
        jp1.add(jp2_jl2);
        jp1.add(cmb);
        JLabel JL = new JLabel("                 ");//美观，中间隔开
        jp1.add(JL);
        jp1.add(jp1_jb1);
        JLabel JL2 = new JLabel("    ");
        jp1.add(JL2);
        jp1.add(jp1_jb2);
        JLabel JL3 = new JLabel("    ");
        jp1.add(JL3);
        jp1.add(jp1_jb3);

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

        jtb = new JTable();
        jsp = new JScrollPane(jtb);
        this.add(jp1, "Center");
        this.add(jsp, "South");

        this.setSize(700, 540);
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
            String sql;
            //获取文本框的值
            String TeachBuilding = jp1_jtf1.getText().trim();//其中trim()是去掉文本框前面可能有的空格，但不能去掉字符串中的空格
            String Class = jp1_jtf2.getText().trim();
            //获取选择的信息
            String Week = (String) cmb2.getSelectedItem();
            String Day = (String) cmb.getSelectedItem();

            //有很多种情况，你应该每样都考虑到
            //并且，你应当先判断输入满足少的，比如当你教学楼和教室输入，和当你只有教室输入时，你应该先判断只输入了教室的。
            //因为我们判断的是没有输入的，你只输入了教室，没输入的就有三个，你输入了教学楼和教室，没输入的就有两个，所以我们要先判断没输入的多的，因为没输入的少包括了没输入的多的情况
            if (TeachBuilding.equals("") && Class.equals("") && Week.equals("--请选择--") && Day.equals("--请选择--")) {
                //当你都没有输入的时候，显示所有教学楼的所有教室的所有周次和星期的课程
                sql = "select * from ClassColumSelect";
            } else if (Class.equals("") && Week.equals("--请选择--") && Day.equals("--请选择--")) {
                //当你只输入了教学楼
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "'";
            } else if (TeachBuilding.equals("") && Class.equals("") && Week.equals("--请选择--")) {
                //当你只选择了星期
                sql = "select * from ClassColumSelect where Day='" + Day + "'";
            } else if (TeachBuilding.equals("") && Day.equals("--请选择--") && Week.equals("--请选择--")) {
                //当你只输入了教室
                sql = "select * from ClassColumSelect where Class='" + Class + "'";
            } else if (TeachBuilding.equals("") && Class.equals("") && Day.equals("--请选择--")) {
                //当你只选择了周次
                sql = "select * from ClassColumSelect where Week='" + Week + "'";
            } else if (Week.equals("--请选择--") && Day.equals("--请选择--")) {
                //当你只输入了教学楼和教室
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "')";
            } else if (Class.equals("") && Day.equals("--请选择--")) {
                //当你只输了教学楼和周次
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Week='" + Week + "')";
            } else if (Class.equals("") && Week.equals("--请选择--")) {
                //当你只输入了教学楼和星期
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Day='" + Day + "')";
            } else if (TeachBuilding.equals("") && Day.equals("--请选择--")) {
                //当你只输入了教室和周次
                sql = "select * from ClassColumSelect where Class='" + Class + "' and (Week='" + Week + "')";
            } else if (TeachBuilding.equals("") && Week.equals("--请选择--")) {
                //当你只输入了教室和星期
                sql = "select * from ClassColumSelect where Class='" + Class + "'and (Day='" + Day + "')";
            } else if (TeachBuilding.equals("") && Class.equals("")) {
                //当你只输了周次和星期
                sql = "select * from ClassColumSelect where Week='" + Week + "'and (Day='" + Day + "')";
            } else if (TeachBuilding.equals("")) {
                //当你只有教学楼没有输入
                sql = "select * from ClassColumSelect where Class='" + Class + "' and (Week='" + Week + "')and (Day='" + Day + "')";
            } else if (Class.equals("")) {
                //当你只有教室没有输入
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Week='" + Week + "')and (Day='" + Day + "')";
            } else if (Week.equals("--请选择--")) {
                //当你只有周次没有选择时
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "') and (Day='" + Day + "')";
            } else if (Day.equals("--请选择--")) {
                //当你只有星期没有选择时
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "') and (Week='" + Week + "')";
            } else {
                //当你全部都输入了
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "') and (Week='" + Week + "')and (Day='" + Day + "')";
            }

            //调用模型
            tm = new ClassColumSelectModel(sql);
            //重新显示表结构
            jtb.setModel(tm);
        } else if (arg0.getSource() == jp1_jb2) {
            //清空文本信息
            jp1_jtf1.setText("");
            jp1_jtf2.setText("");
        } else if (arg0.getSource() == jp1_jb3) {
            //调用模型
            tm = new ClassColumSelectModel(null);
            //重新显示表结构
            jtb.setModel(tm);
        }
    }
}
