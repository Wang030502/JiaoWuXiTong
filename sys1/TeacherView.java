package sys1;

import SqlConnection.SqlConn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeacherView extends JFrame implements ActionListener {
    //����˵���ҪҪ�����
    JMenuBar jmb;
    JMenu jm1, jm2, jm3, jm4;
    JMenuItem jm1_0, jm1_1, jm2_1, jm2_2, jm2_3, jm2_4, jm2_5;
    JMenuItem jm3_1, jm3_2, jm4_1, jm4_2, jm4_3, jm4_4;
    private Timer time;
    JLabel timelabel;

    //����һ�����������ʾѧ����Ϣ
    JTable jtb;
    //����һ��������壬���ڴ�ű��
    JScrollPane jsp;

    //����һ�����ģ�ͣ����ڸ��±�����
    ShowStuMessageModel tm;
    ShowTchMessageModel stmm;


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

        //��ӵ�����
        jm1.add(jm1_0);
        jm1.add(jm1_1);

        jm2 = new JMenu("ѧ������");
        jm2.setFont(MyFont.f1);

        jm2_1 = new JMenuItem("<-ѧ���б�->");
        jm2_1.addActionListener(this);
        jm2_1.setFont(MyFont.f2);

        jm2_2 = new JMenuItem("<-����ѧ��->");
        jm2_2.addActionListener(this);
        jm2_2.setFont(MyFont.f2);

        jm2_3 = new JMenuItem("<-�޸�ѧ��->");
        jm2_3.addActionListener(this);
        jm2_3.setFont(MyFont.f2);

        jm2_4 = new JMenuItem("<-���ѧ��->");
        jm2_4.addActionListener(this);
        jm2_4.setFont(MyFont.f2);

        jm2_5 = new JMenuItem("<-ɾ��ѧ��->");
        jm2_5.addActionListener(this);
        jm2_5.setFont(MyFont.f2);

        //��ӵ�����
        //���ң���ӣ��޸ģ�ɾ��
        jm2.add(jm2_1);
        jm2.add(jm2_2);
        jm2.add(jm2_4);
        jm2.add(jm2_3);
        jm2.add(jm2_5);

        jm4 = new JMenu("�γ̹���");
        jm4.setFont(MyFont.f1);

        jm4_1 = new JMenuItem("<-�γ����->");
        jm4_1.setFont(MyFont.f2);
        jm4_1.addActionListener(this);

        jm4_2 = new JMenuItem("<-ѧ���α��ѯ->");
        jm4_2.setFont(MyFont.f2);
        jm4_2.addActionListener(this);

        jm4_3 = new JMenuItem("<-���ҿα��ѯ->");
        jm4_3.setFont(MyFont.f2);
        jm4_3.addActionListener(this);

        jm4_4 = new JMenuItem("<-�ҵĿα�->");
        jm4_4.setFont(MyFont.f2);
        jm4_4.addActionListener(this);

        //��ӵ�����
        jm4.add(jm4_4);
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

        //��ӵ�����
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
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ϵͳ.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�˳���¼.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�˳�ϵͳ.png");
        ImageIcon bi4 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�ڼ�ѧ������.png");
        ImageIcon bi5 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ѧ���б�.png");
        ImageIcon bi6 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�����û�.png");
        ImageIcon bi7 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\���ѧ��.png");
        ImageIcon bi8 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�޸��û���Ϣ.png");
        ImageIcon bi9 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ɾ���û�.png");
        ImageIcon bi10 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�γ̹���.png");
        ImageIcon bi11 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�ҵĿγ�.png");
        ImageIcon bi12 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\���.png");
        ImageIcon bi13 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\��ѯѧ���α�.png");
        ImageIcon bi14 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\����.png");
        ImageIcon bi15 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\ϵͳ����.png");
        ImageIcon bi16 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�ҵ���Ϣ_������Ϣ.png");
        ImageIcon bi17 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\�޸�����.png");

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
        ScalePhoto(bi15, 15, 15);
        ScalePhoto(bi16, 15, 15);
        ScalePhoto(bi17, 15, 15);

        //��ͼƬ���뵽������ȥ
        jm1.setIcon(bi1);//ϵͳ
        jm1_0.setIcon(bi2);
        jm1_1.setIcon(bi3);
        jm2.setIcon(bi4);//ѧ������
        jm2_1.setIcon(bi5);
        jm2_2.setIcon(bi6);
        jm2_4.setIcon(bi7);
        jm2_3.setIcon(bi8);
        jm2_5.setIcon(bi9);
        jm4.setIcon(bi10);//�γ̹���
        jm4_4.setIcon(bi11);//�ҵĿα�
        jm4_1.setIcon(bi12);//�γ����
        jm4_2.setIcon(bi13);//ѧ���α��ѯ
        jm4_3.setIcon(bi14);//���ҿα��ѯ
        jm3.setIcon(bi15);//ϵͳ����
        jm3_1.setIcon(bi16);
        jm3_2.setIcon(bi17);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TeacherView();
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

    public TeacherView() {
        //����ʱ��
        getTimelabel();
        //���ò˵�����
        this.menuInit();

        //����½�������ʱ�������ʾ�Ľ���
        jtb = new JTable();

        //�ڸյ�½��ȥ��ʱ����������ʾ�����������ʱ��ʾ������������ʱ��Ӱ���ٶȣ�Ҳ��̫���ϳ��� ����������ﲻ�ø�������ģ��
        jsp = new JScrollPane(jtb);
        this.add(jsp, "Center");

        //���ô�������
        this.setSize(900, 500);
        this.setTitle("�ϻ���ѧ����ϵͳ-->��ʦ��");

        //��¼ʱ����
        JOptionPane.showMessageDialog(this, "��ӭ��¼", "��ʾ", 1);

        //���ô��ڵĳ�ʼλ��
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����X�˳�

        //���Ͻ�Сͼ��
        try {
            this.setIconImage(ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\index8.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
        //�˳�ϵͳ
        if (arg0.getSource() == jm1_1) {
            Object[] options = {"ȷ��", "ȡ��"};
            int respose = JOptionPane.showOptionDialog(this, "��ȷ��Ҫ�˳�ϵͳ��", "��ʾ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                System.exit(0);//�˳�ϵͳ
            } else if (respose == 1) {
                return;
            }
        }
        //�˳���¼
        else if (arg0.getSource() == jm1_0) {
            Object[] options = {"ȷ��", "ȡ��"};
            int respose = JOptionPane.showOptionDialog(this, "��ȷ��Ҫ�˳���¼��", "��ʾ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                this.dispose();//�رյ�ǰ
                new Login();//�����µĵ�¼����
            } else if (respose == 1) {
                return;
            }
        }
        //ѧ���б�
        else if (arg0.getSource() == jm2_1) {
            tm = new ShowStuMessageModel(null);
            jtb.setModel(tm);
            //�ñ����ʾѧ����Ϣ
            jtb.setVisible(true);
        }
        //����ѧ��
        else if (arg0.getSource() == jm2_2) {
            FindStu ST = new FindStu(this, "ѧ����Ϣ��ѯ", true);
            //this����ʾ�ڵ�ǰ����֮�ϣ��ڶ������⣬true����ģʽ�Ի���
        }
        //���ѧ��
        else if (arg0.getSource() == jm2_4) {
            AddStu addstu = new AddStu(this, "���ѧ����Ϣ", true);
            if (addstu.falg() == 1) {
                //���µ�ǰ���ڵ�ѧ����Ϣ���Ա����ѧ����Ϣ����ܿ�������Ϣ
                tm = new ShowStuMessageModel(null);
                jtb.setModel(tm);
            } else {
                //����������
            }
        }
        //�޸�ѧ��
        else if (arg0.getSource() == jm2_3) {
            //���ж��Ƿ�ѡ����һ�У�û��ѡ�У��򷵻�-1�����ѡ�У��򷵻�ѡ�е���һ�е���ţ�Ҳ���ǵڼ���
            int rowNo = jtb.getSelectedRow();
            if (rowNo == -1) {
                //û��ѡ�У���ʾ��Ϣ
                JOptionPane.showMessageDialog(this, "��û��ѡ��һ�У�");
                return;
            } else {
                //�õ�ѡ�����һ�е�ѧ��
                //String stuId=(String)tm.getValueAt(rowNo, 0);//ѧ�����ַ�������Щ��ת��
                //��Ҫ�ѵ�ǰ���������ģ�ͺ���ѡ�����һ�е���Ŵ���ȥ
                UpdateStu updateStu = new UpdateStu(this, "�޸�ѧ����Ϣ", tm, rowNo, true);
                //���µ�ǰ���ڵ�ѧ����Ϣ���Ա����ѧ����Ϣ����ܿ�������Ϣ
                tm = new ShowStuMessageModel(null);
                jtb.setModel(tm);
            }
        }
        //ɾ��ѧ��
        else if (arg0.getSource() == jm2_5) {
            //����ĳһ�У���ѡ�����һ��
            int rowNo = jtb.getSelectedRow();
            //�ж��Ƿ��Ѿ�ѡ��һ�У����û��ѡ���򵯳�һ���Ի��򣬵�����-1ʱ����ʾû��ѡ��
            if (rowNo == -1) {
                JOptionPane.showMessageDialog(this, "��û��ѡ��һ�У�", "��ʾ", 1);
                return;
            } else {
                //�õ�ѡ�����һ�е�ѧ��
                String stuId = (String) tm.getValueAt(rowNo, 0);//ĳһ�еĵ�0�о���ѧ�ţ���Ϊ�õ���ѧ�����ַ��������Ե�ת��
                String sql = "delete from stuMessage where Id='" + stuId + "'";
                Object[] options = {"ȷ��", "ȡ��"};
                int respose = JOptionPane.showOptionDialog(this, "��ȷ��Ҫɾ����ѧ����", "����", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (respose == 0) {
                    //�������ݿ�
                    SqlConn sqlconn = new SqlConn();
                    sqlconn.sqlDelete(sql);
                    //ע�⣺********�����������ùر����ݿ����ӵķ�������������û�йر���Դ�����ģ���޷����³ɹ����мǣ���������
                    sqlconn.closeSqlConn();
                    tm = new ShowStuMessageModel(null);
                    jtb.setModel(tm);
                } else if (respose == 1) {
                    return;
                }
            }
        }
        //�ҵ���Ϣ
        else if (arg0.getSource() == jm3_1) {
            stmm = new ShowTchMessageModel(null, loginModel.a);
            jtb.setModel(stmm);
            //�ñ����ʾ��ʦ��Ϣ
            jtb.setVisible(true);
        }
        //�޸�����
        else if (arg0.getSource() == jm3_2) {
            ModifyPassword ModifyTch = new ModifyPassword(this, "�޸�������Ϣ", true);
            if (ModifyPassword.i == 0) {//i��¼�Ƿ��޸ĳɹ�
                this.dispose();
                new Login();
            }
        }
        //���ҿα��ѯ
        else if (arg0.getSource() == jm4_3) {
            ClassColumSelect CCS = new ClassColumSelect(this, "���ҿα��ѯ", true);
        }
        //ѧ���α��ѯ
        else if (arg0.getSource() == jm4_2) {
            StuColumConsult SCC = new StuColumConsult(this, "ѧ���α��ѯ", true);
        }
        //�ҵĿα�
        else if (arg0.getSource() == jm4_4) {
            TeacherColum TC = new TeacherColum(this, "�ҵĿα�", true);
        }
        //�γ����
        else if (arg0.getSource() == jm4_1) {
            ColumLeave CL = new ColumLeave(this, "�γ����", true);
        }
    }
}
