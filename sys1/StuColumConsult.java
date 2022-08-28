package sys1;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ѧ���α��ѯ
public class StuColumConsult extends JDialog implements ActionListener {

    //�����ѯ����Ҫ���������
    JPanel jp1;
    JLabel jp1_jl1, jp1_jl2;
    JTextField jp1_jtf1;
    JButton jp1_jb1, jp1_jb2;
    JTable jtb;
    JScrollPane jsp;
    TableModel tm;
    int m;//��������ܴ�תΪ����
    int i;//�����ܺ�ż���ܵĿα���ͬ
    JComboBox cmb2 = new JComboBox();

    public StuColumConsult(Frame Main, String title, boolean model) {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main, title, model);
        jp1 = new JPanel();
        jp1_jl1 = new JLabel("������ѧ�ţ�");
        jp1_jl1.setFont(MyFont.f1);

        jp1_jtf1 = new JTextField(10);
        jp1_jl2 = new JLabel("��ѡ���ܴΣ�");
        jp1_jl2.setFont(MyFont.f1);

        jp1_jb1 = new JButton("�� ѯ");
        jp1_jb1.setFont(MyFont.f1);
        jp1_jb1.addActionListener(this);

        jp1_jb2 = new JButton("�� ��");
        jp1_jb2.setFont(MyFont.f1);
        jp1_jb2.addActionListener(this);

        cmb2.addItem("--��ѡ��--");
        cmb2.addItem("��һ��");
        cmb2.addItem("�ڶ���");
        cmb2.addItem("������");
        cmb2.addItem("������");
        cmb2.addItem("������");
        cmb2.addItem("������");
        cmb2.addItem("������");
        cmb2.addItem("�ڰ���");
        cmb2.addItem("�ھ���");
        cmb2.addItem("��ʮ��");
        cmb2.addItem("��ʮһ��");
        cmb2.addItem("��ʮ����");
        cmb2.addItem("��ʮ����");
        cmb2.addItem("��ʮ����");
        cmb2.addItem("��ʮ����");
        cmb2.addItem("��ʮ����");
        cmb2.addItem("��ʮ����");
        cmb2.addItem("��ʮ����");

        //���
        jp1.add(jp1_jl1);
        jp1.add(jp1_jtf1);
        jp1.add(jp1_jl2);
        jp1.add(cmb2);
        JLabel JL = new JLabel("    ");
        jp1.add(JL);//������ťֱ�ӵĿ�϶
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);

        jtb = new JTable();
        jsp = new JScrollPane(jtb);
        this.add(jp1, "North");
        this.add(jsp, "Center");

        //Сͼ��
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\��ѯ.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\���.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);

        jp1_jb1.setIcon(bi1);
        jp1_jb2.setIcon(bi2);

        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    //Сͼ����С
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        //�������˲�ѯ��ť
        if (arg0.getSource() == jp1_jb1) {
            //��ȡ�ı����ֵ
            String Id = jp1_jtf1.getText().trim();//����trim()��ȥ���ı���ǰ������еĿո񣬵�����ȥ���ַ����еĿո�
            String Week = (String) cmb2.getSelectedItem();

            if (Id.equals("") && Week.equals("")) {
                JOptionPane.showMessageDialog(this, "������ѧ�ź��ܴ�", "��ʾ", 1);
                return;
            } else if (Id.equals("")) {
                JOptionPane.showMessageDialog(this, "������ѧ��", "��ʾ", 1);
                return;
            } else if (Week.equals("--��ѡ��--")) {
                JOptionPane.showMessageDialog(this, "��ѡ���ܴ�", "��ʾ", 1);
                return;
            } else if (Id.length() < 11) {
                JOptionPane.showMessageDialog(this, "�������ѧ������", "��ʾ", 1);
                return;
            } else {
                if(Week.equals("��һ��")||Week.equals("������")||Week.equals("������")||Week.equals("������")||Week.equals("�ھ���")||Week.equals("��ʮһ��")||Week.equals("��ʮ����")||Week.equals("��ʮ����")||Week.equals("��ʮ����")){
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



