package sys1;
//ͣ�β�ѯ

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class StopClass extends JDialog{
    //���崰����Ҫ�����
    TableModel tm;
    JTable jtb;
    JScrollPane jsp;

    public StopClass(Frame Main, String title, boolean model) {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main, title, model);
        //���ô��������
        jtb = new JTable();
        tm = new StopClassModel(null);
        jtb.setModel(tm);
        //�ñ����ʾ��Ϣ
        jtb.setVisible(true);
        jsp = new JScrollPane(jtb);
        //������Ϣ����ĵķ���
        this.add(jsp, "Center");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
}
