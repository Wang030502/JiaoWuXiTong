package sys1;
//ÿ�ܿα���һ��


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
    public static int i = 1;//�����ܿα���ż���ܿα���ͬ
    int m = 1;//��¼�ǵڼ��ܿα�

    public void addView() {
        jb1 = new JButton("��һ��");
        jb1.setFont(MyFont.f1);
        jb1.setSize(80, 25);
        jb1.addActionListener(this);

        jb2 = new JButton("��һ��");
        jb2.setFont(MyFont.f1);
        jb2.setSize(80, 25);
        jb2.addActionListener(this);

        JLabel jl = new JLabel("         ");
        jp = new JPanel();
        jp.add(jb1);
        jp.add(jl);
        jp.add(jb2);

        //��ӵ�����
        this.add(jp, BorderLayout.SOUTH);
        this.add(jsp, "Center");

        //Сͼ��
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\��һ��.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\��һ��.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi2);
        jb2.setHorizontalTextPosition(JButton.LEFT);//��ͼ������ұ�

    }



    public MyColum(Frame Main, String title, boolean model) {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main, title, model);
        //���ô��������
        jtb = new JTable();
        tm = new MyColumTableModel(null, i, m);//��ȥ����ʾ��һ�ܵ�
        jtb.setModel(tm);
        //�ñ����ʾ��Ϣ
        jtb.setVisible(true);
        jsp = new JScrollPane(jtb);
        //������Ϣ����ĵķ���
        this.addView();

        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    //Сͼ����С
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        //�����һ��
        if (arg0.getSource() == jb2) {
            if (m > 17) {
                //�α���ʾ���18��
                JOptionPane.showMessageDialog(this, "�޷�����һ��", "����", 2);
                return;
            } else {
                ++m;//��m��
                ++i;//�����ܻ���ż����
                if (i % 2 == 0) {//ż���ܿα�
                    i = 2;
                }
                if (i % 2 == 1) {//�����ܿα�
                    i = 1;
                }
                tm = new MyColumTableModel(null, i, m);//i���������ܻ���ż���ܣ�m����ڼ���
                jtb.setModel(tm);
            }
        }//��������һ��
        else if (arg0.getSource() == jb1) {
            if (m <= 1) {
                JOptionPane.showMessageDialog(this, "�޷�����һ��", "����", 2);
                return;
            } else {
                --i;
                --m;
                if (i % 2 == 0) {//ż���ܿα�
                    i = 2;
                }
                if (i % 2 == 1) {//�����ܿα�
                    i = 1;
                }
                tm = new MyColumTableModel(null, i, m);
                //���±�ṹ
                jtb.setModel(tm);
            }
        }
    }
}