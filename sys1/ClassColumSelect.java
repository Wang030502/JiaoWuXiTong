package sys1;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//���ҿα��ѯ
public class ClassColumSelect extends JDialog implements ActionListener {
    //�����ѯ����Ҫ���������
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
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main, title, model);
        jp1 = new JPanel();

        jp1_jl1 = new JLabel("�������ѧ¥��");
        jp1_jl1.setFont(MyFont.f1);

        jp1_jtf1 = new JTextField(10);

        jp1_jl2 = new JLabel("��������ң�");
        jp1_jl2.setFont(MyFont.f1);

        jp1_jtf2 = new JTextField(10);

        jp2_jl1 = new JLabel("��ѡ���ܴΣ�");
        jp2_jl1.setFont(MyFont.f1);

        jp2_jl2 = new JLabel("��ѡ�����ڣ�");
        jp2_jl2.setFont(MyFont.f1);

        jp1_jb1 = new JButton("�� ѯ");
        jp1_jb1.setFont(MyFont.f1);
        jp1_jb1.addActionListener(this);

        jp1_jb2 = new JButton("�� ��");
        jp1_jb2.setFont(MyFont.f1);
        jp1_jb2.addActionListener(this);

        jp1_jb3 = new JButton("��ʾ���пγ�");
        jp1_jb3.setFont(MyFont.f1);
        jp1_jb3.addActionListener(this);

        cmb.addItem("--��ѡ��--");
        cmb.addItem("����һ");
        cmb.addItem("���ڶ�");
        cmb.addItem("������");
        cmb.addItem("������");
        cmb.addItem("������");
        cmb.addItem("������");
        cmb.addItem("������");

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

        jp1.add(jp1_jl1);
        jp1.add(jp1_jtf1);
        jp1.add(jp1_jl2);
        jp1.add(jp1_jtf2);
        jp1.add(jp2_jl1);
        jp1.add(cmb2);
        jp1.add(jp2_jl2);
        jp1.add(cmb);
        JLabel JL = new JLabel("                 ");//���ۣ��м����
        jp1.add(JL);
        jp1.add(jp1_jb1);
        JLabel JL2 = new JLabel("    ");
        jp1.add(JL2);
        jp1.add(jp1_jb2);
        JLabel JL3 = new JLabel("    ");
        jp1.add(JL3);
        jp1.add(jp1_jb3);

        //Сͼ��
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\��ѯ.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\���.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\��ʾ���м�¼.png");

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

    //Сͼ����С
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
        //�������˲�ѯ��ť
        if (arg0.getSource() == jp1_jb1) {
            String sql;
            //��ȡ�ı����ֵ
            String TeachBuilding = jp1_jtf1.getText().trim();//����trim()��ȥ���ı���ǰ������еĿո񣬵�����ȥ���ַ����еĿո�
            String Class = jp1_jtf2.getText().trim();
            //��ȡѡ�����Ϣ
            String Week = (String) cmb2.getSelectedItem();
            String Day = (String) cmb.getSelectedItem();

            //�кܶ����������Ӧ��ÿ�������ǵ�
            //���ң���Ӧ�����ж����������ٵģ����統���ѧ¥�ͽ������룬�͵���ֻ�н�������ʱ����Ӧ�����ж�ֻ�����˽��ҵġ�
            //��Ϊ�����жϵ���û������ģ���ֻ�����˽��ң�û����ľ����������������˽�ѧ¥�ͽ��ң�û����ľ�����������������Ҫ���ж�û����Ķ�ģ���Ϊû������ٰ�����û����Ķ�����
            if (TeachBuilding.equals("") && Class.equals("") && Week.equals("--��ѡ��--") && Day.equals("--��ѡ��--")) {
                //���㶼û�������ʱ����ʾ���н�ѧ¥�����н��ҵ������ܴκ����ڵĿγ�
                sql = "select * from ClassColumSelect";
            } else if (Class.equals("") && Week.equals("--��ѡ��--") && Day.equals("--��ѡ��--")) {
                //����ֻ�����˽�ѧ¥
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "'";
            } else if (TeachBuilding.equals("") && Class.equals("") && Week.equals("--��ѡ��--")) {
                //����ֻѡ��������
                sql = "select * from ClassColumSelect where Day='" + Day + "'";
            } else if (TeachBuilding.equals("") && Day.equals("--��ѡ��--") && Week.equals("--��ѡ��--")) {
                //����ֻ�����˽���
                sql = "select * from ClassColumSelect where Class='" + Class + "'";
            } else if (TeachBuilding.equals("") && Class.equals("") && Day.equals("--��ѡ��--")) {
                //����ֻѡ�����ܴ�
                sql = "select * from ClassColumSelect where Week='" + Week + "'";
            } else if (Week.equals("--��ѡ��--") && Day.equals("--��ѡ��--")) {
                //����ֻ�����˽�ѧ¥�ͽ���
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "')";
            } else if (Class.equals("") && Day.equals("--��ѡ��--")) {
                //����ֻ���˽�ѧ¥���ܴ�
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Week='" + Week + "')";
            } else if (Class.equals("") && Week.equals("--��ѡ��--")) {
                //����ֻ�����˽�ѧ¥������
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Day='" + Day + "')";
            } else if (TeachBuilding.equals("") && Day.equals("--��ѡ��--")) {
                //����ֻ�����˽��Һ��ܴ�
                sql = "select * from ClassColumSelect where Class='" + Class + "' and (Week='" + Week + "')";
            } else if (TeachBuilding.equals("") && Week.equals("--��ѡ��--")) {
                //����ֻ�����˽��Һ�����
                sql = "select * from ClassColumSelect where Class='" + Class + "'and (Day='" + Day + "')";
            } else if (TeachBuilding.equals("") && Class.equals("")) {
                //����ֻ�����ܴκ�����
                sql = "select * from ClassColumSelect where Week='" + Week + "'and (Day='" + Day + "')";
            } else if (TeachBuilding.equals("")) {
                //����ֻ�н�ѧ¥û������
                sql = "select * from ClassColumSelect where Class='" + Class + "' and (Week='" + Week + "')and (Day='" + Day + "')";
            } else if (Class.equals("")) {
                //����ֻ�н���û������
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Week='" + Week + "')and (Day='" + Day + "')";
            } else if (Week.equals("--��ѡ��--")) {
                //����ֻ���ܴ�û��ѡ��ʱ
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "') and (Day='" + Day + "')";
            } else if (Day.equals("--��ѡ��--")) {
                //����ֻ������û��ѡ��ʱ
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "') and (Week='" + Week + "')";
            } else {
                //����ȫ����������
                sql = "select * from ClassColumSelect where TeachBuilding='" + TeachBuilding + "' and (Class='" + Class + "') and (Week='" + Week + "')and (Day='" + Day + "')";
            }

            //����ģ��
            tm = new ClassColumSelectModel(sql);
            //������ʾ��ṹ
            jtb.setModel(tm);
        } else if (arg0.getSource() == jp1_jb2) {
            //����ı���Ϣ
            jp1_jtf1.setText("");
            jp1_jtf2.setText("");
        } else if (arg0.getSource() == jp1_jb3) {
            //����ģ��
            tm = new ClassColumSelectModel(null);
            //������ʾ��ṹ
            jtb.setModel(tm);
        }
    }
}
