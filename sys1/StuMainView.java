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
    //����˵���ҪҪ�����
    JMenuBar jmb;
    JMenu jm1, jm2, jm3, jm4;
    JMenuItem jm1_0, jm1_1, jm2_0, jm2_1, jm2_2, jm4_1, jm4_2, jm4_3;
    JMenuItem jm3_1, jm3_2;
    private Timer time;
    JLabel timelabel;

    //����һ�����������ʾ�γ���Ϣ
    JTable jtb;
    //����һ��������壬���ڴ�ű��
    JScrollPane jsp;

    //����һ�����ģ�ͣ����ڸ��±�����
    TableModel tm;

    //�ҵ���Ϣ
    ShowStuMessageModel myms;

    //�Ѳ˵���װ��һ������
    public void menuInit() {
        jm1 = new JMenu("ϵͳ");
        jm1.setFont(MyFont.f1);

        jm1_0 = new JMenuItem("<-�˳���¼->");
        jm1_1 = new JMenuItem("<-�˳�ϵͳ->");
        jm1_0.addActionListener(this);
        jm1_1.addActionListener(this);
        jm1_0.setFont(MyFont.f2);
        jm1_1.setFont(MyFont.f2);
        jm1.add(jm1_0);
        jm1.addSeparator();
        jm1.add(jm1_1);

        jm2 = new JMenu("ѡ�ι���");
        jm2.setFont(MyFont.f1);
        jm2_0 = new JMenuItem("<-�ҵĿγ�->");
        jm2_0.addActionListener(this);
        jm2_0.setFont(MyFont.f2);
        jm2_1 = new JMenuItem("<-����ѡ��->");
        jm2_1.addActionListener(this);
        jm2_1.setFont(MyFont.f2);
        jm2_2 = new JMenuItem("<-�޸�ѡ��->");
        jm2_2.addActionListener(this);
        jm2_2.setFont(MyFont.f2);

        jm2.add(jm2_0);
        jm2.addSeparator();
        jm2.add(jm2_1);
        jm2.add(jm2_2);

        jm4 = new JMenu("�ҵĿα�");
        jm4.setFont(MyFont.f1);
        jm4_1 = new JMenuItem("<-ѧ�����ۿα�->");
        jm4_1.addActionListener(this);
        jm4_1.setFont(MyFont.f2);
        jm4_2 = new JMenuItem("<-���ҿα��ѯ->");
        jm4_2.addActionListener(this);
        jm4_2.setFont(MyFont.f2);
        jm4_3 = new JMenuItem("<-ͣ�β�ѯ->");
        jm4_3.addActionListener(this);
        jm4_3.setFont(MyFont.f2);
        jm4.add(jm4_1);
        jm4.add(jm4_2);
        jm4.add(jm4_3);

        jm3 = new JMenu("ϵͳ����");
        jm3.setFont(MyFont.f1);
        jm3_1 = new JMenuItem("<-�ҵ���Ϣ->");
        jm3_1.setFont(MyFont.f2);
        jm3_1.addActionListener(this);
        jm3_2 = new JMenuItem("<-�޸�����->");
        jm3_2.setFont(MyFont.f2);
        jm3_2.addActionListener(this);

        //������
        jm3.add(jm3_1);
        jm3.add(jm3_2);

        //���ò˵���
        jmb = new JMenuBar();
        //�Ѳ˵���ӵ��˵���
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm4);
        jmb.add(jm3);
        //��ʱ����ʾ�����ұߣ����������ķ�������
        JLabel jLabel = new JLabel("                                                                                                  ");
        jmb.add(jLabel);
        jmb.add(timelabel);

        //�Ѳ˵�����ӵ�����
        this.setJMenuBar(jmb);


        //Сͼ��
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ϵͳ����.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�ҵ���Ϣ_������Ϣ.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�޸�����.png");
        ImageIcon bi4 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�γ̱�.png");
        ImageIcon bi5 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�α���Ϣ.png");
        ImageIcon bi6 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\����.png");
        ImageIcon bi7 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ͣ��.png");
        ImageIcon bi8 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ѡ��_����.png");
        ImageIcon bi9 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�ҵĿγ�.png");
        ImageIcon bi10 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\��ѡ�γ�.png");
        ImageIcon bi11 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ѡ��.png");
        ImageIcon bi12 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ϵͳ.png");
        ImageIcon bi13 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�˳���¼.png");
        ImageIcon bi14 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�˳�ϵͳ.png");

        //ͼƬ����
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

        //��ͼƬ���뵽������ȥ
        jm3.setIcon(bi1);//ϵͳ����
        jm3_1.setIcon(bi2);
        jm3_2.setIcon(bi3);
        jm4.setIcon(bi4);//�ҵĿα�
        jm4_1.setIcon(bi5);
        jm4_2.setIcon(bi6);
        jm4_3.setIcon(bi7);
        jm2.setIcon(bi8);//ѡ�ι���
        jm2_0.setIcon(bi9);//�ҵĿγ�
        jm2_1.setIcon(bi10);//����ѡ��
        jm2_2.setIcon(bi11);//�޸�ѡ��
        jm1.setIcon(bi12);
        jm1_0.setIcon(bi13);
        jm1_1.setIcon(bi14);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StuMainView manageview = new StuMainView();
    }

    //Сͼ����С
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    //ʱ����ʾ
    private JLabel getTimelabel() {
        if (timelabel == null) {
            timelabel = new JLabel("");
            timelabel.setBounds(5, 65, 200, 20);
            timelabel.setFont(new Font("΢���ź�", Font.BOLD, 12));
            timelabel.setForeground(new Color(14, 13, 13, 255));
            time = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    timelabel.setText(new SimpleDateFormat("yyyy��MM��dd�� EEEE HH:mm:ss").format(new Date()));
                }
            });
            time.start();
        }
        return timelabel;
    }

    public StuMainView() {
        //����ʱ��
        getTimelabel();
        //���ò˵�����
        this.menuInit();

        //����½�������ʱ�������ʾ�Ľ���
        jtb = new JTable();
        //�ڸյ�½��ȥ��ʱ����������ʾ�����������ʱ��ʾ������������ʱ��Ӱ���ٶȣ�Ҳ��̫���ϳ��棬�����ʱ����ʾ����
        jsp = new JScrollPane(jtb);
        this.add(jsp, "Center");


        //���ô�������
        this.setSize(900, 500);
        this.setTitle("�ϻ���ѧ����ϵͳ-->ѧ����");
        //���ô��ڵĳ�ʼλ��
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���x���˳�����

        //��¼ʱ����
        JOptionPane.showMessageDialog(this, "��ӭ��¼", "��ʾ", 1);

        //try����catch���������Ͻ�Сͼ��
        try {
            this.setIconImage(ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\index8.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //���ÿɼ�
        this.setVisible(true);

    }


    //*************************�¼���Ӧ***********************//
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        //�˳�ϵͳ
        if (arg0.getSource() == jm1_1) {
            Object[] options = {"ȷ��", "ȡ��"};
            int respose = JOptionPane.showOptionDialog(this, "��ȷ��Ҫ�˳�ϵͳ��", "��ʾ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                System.exit(0);//������˳�ϵͳ
            } else if (respose == 1) {
                return;
            }
        }
        //�˳���¼
        else if (arg0.getSource() == jm1_0) {
            Object[] options = {"ȷ��", "ȡ��"};
            int respose = JOptionPane.showOptionDialog(this, "��ȷ��Ҫ�˳���¼��", "��ʾ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                this.dispose();
                new Login();
            } else if (respose == 1) {
                return;
            }
        }
        //�ҵĿα�
        else if (arg0.getSource() == jm4_1) {
            MyColum MC = new MyColum(this, "�ҵĿα�", true);
        }
        //�ҵ���Ϣ
        else if (arg0.getSource() == jm3_1) {
            myms = new ShowStuMessageModel(null, loginModel.a);
            jtb.setModel(myms);
            //�ñ����ʾѧ����Ϣ
            jtb.setVisible(true);
        }
        //�޸�����
        else if (arg0.getSource() == jm3_2) {
            ModifyPassword ModifyStu = new ModifyPassword(this, "�޸�������Ϣ", true);
            if (ModifyPassword.i == 0) {//i��¼�Ƿ��޸ĳɹ�
                this.dispose();
                new Login();
            }
        }
        //����ѡ��
        else if (arg0.getSource() == jm2_1) {
            OnlineClass OC = new OnlineClass(this, "����ѡ��", true);
            if (OnlineClass.i == 1) {
                //���µ�ǰ���ڵ���Ϣ���Ա������Ϣ����ܿ�������Ϣ
                tm = new OnlineClassModel(null);
                jtb.setModel(tm);
            } else {
                //����������
            }
        }
        //�ҵĿγ�
        else if (arg0.getSource() == jm2_0) {
            tm = new SelectColumTableModel(null);
            jtb.setModel(tm);
            //�ñ����ʾѧ����Ϣ
            jtb.setVisible(true);
        }
        //�޸�ѡ��
        else if (arg0.getSource() == jm2_2) {
            ModifyClass OC = new ModifyClass(this, "�޸�ѡ��", true);
            if (ModifyClass.i == 1) {
                //���µ�ǰ���ڵ���Ϣ���Ա������Ϣ����ܿ�������Ϣ
                tm = new SelectColumTableModel(null);
                jtb.setModel(tm);
            } else {
                //����������
            }
        }
        //���ҿα��ѯ
        else if (arg0.getSource() == jm4_2) {
            ClassColumSelect CCS = new ClassColumSelect(this, "���ҿα��ѯ", true);
        }
        //ͣ�β�ѯ
        else if (arg0.getSource() == jm4_3) {
            StopClass SC = new StopClass(this, "ͣ�β�ѯ", true);
        }
    }
}


