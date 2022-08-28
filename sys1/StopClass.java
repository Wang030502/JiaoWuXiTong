package sys1;
//停课查询

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class StopClass extends JDialog{
    //定义窗口需要的组件
    TableModel tm;
    JTable jtb;
    JScrollPane jsp;

    public StopClass(Frame Main, String title, boolean model) {
        //调用父类的构造方法，实现模式对话
        super(Main, title, model);
        //设置窗体的属性
        jtb = new JTable();
        tm = new StopClassModel(null);
        jtb.setModel(tm);
        //让表格显示信息
        jtb.setVisible(true);
        jsp = new JScrollPane(jtb);
        //调用信息界面的的方法
        this.add(jsp, "Center");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
}
