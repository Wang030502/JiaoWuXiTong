package sys1;
//�޸�ѡ��

import SqlConnection.SqlConn;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyClass extends JDialog implements ActionListener {
    JPanel jp;
    JButton jb1, jb2;
    TableModel tm;
    JTable jtb;
    JScrollPane jsp;
    public static int i = 0;//iΪ1��ʱ��ȷ�����޸Ŀγ̣�iΪ0��ȡ���޸�

    public void addView() {
        jb1 = new JButton("�� ��");
        jb1.setFont(MyFont.f1);
        jb1.setSize(80, 25);
        jb1.addActionListener(this);

        jb2 = new JButton("ȡ ��");
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
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\�˳�.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\ȡ��.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi2);
    }

    public ModifyClass(Frame Main, String title, boolean model) {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main, title, model);
        //���ô��������
        jtb = new JTable();
        tm = new ModifyClassModel(null);
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
        if (arg0.getSource() == jb1) {
            //����ĳһ�У���ѡ�����һ��
            int rowNo = jtb.getSelectedRow();
            //�ж��Ƿ��Ѿ�ѡ��һ�У����û��ѡ���򵯳�һ���Ի��򣬵�����-1ʱ����ʾû��ѡ��
            if (rowNo == -1) {
                JOptionPane.showMessageDialog(this, "��û��ѡ��һ�У�", "��ʾ", 1);
                return;
            } else {
                //int Remain2 = (Integer) tm.getValueAt(rowNo,5);��ʾ�쳣
                String Remain = (String) tm.getValueAt(rowNo, 5);//ĳһ�еĵ�5�о���ʣ����
                int s = Integer.parseInt(Remain);//��Ҫת����Ϊ�����˿���ʣ����Ҫ��1
                String Colum = (String) tm.getValueAt(rowNo, 0);//ĳһ�еĵ�0�о��ǿγ�����
                String Teacher = (String) tm.getValueAt(rowNo, 1);
                String Place = (String) tm.getValueAt(rowNo, 2);
                String Source = (String) tm.getValueAt(rowNo, 4);
                String Week = (String) tm.getValueAt(rowNo, 3);
                int s2 = Integer.parseInt(Source);//ҲҪת�ͣ������ݿ������õ�Ϊint
                String All = (String) tm.getValueAt(rowNo, 6);
                int s3 = Integer.parseInt(All);//ҲҪת�ͣ������ݿ������õ�Ϊint

                Object[] options = {"ȷ��", "ȡ��"};
                int respose = JOptionPane.showOptionDialog(this, "ȷ���˳��ÿγ���", "��ʾ", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
                if (respose == 0) {
                    i = 1;
                    //�������ݿ�
                    SqlConn sqlconn = new SqlConn();
                    //sqlconn.sqlUpdate(sql);
                    //ע�⣺********�����������ùر����ݿ����ӵķ�������������û�йر���Դ�����ģ���޷����³ɹ����мǣ���������
                    //�����˿�֮����ɾ����ѡ�еĿγ�
                    String sql = "delete from ModifyClass where Colum='" + Colum + "'";
                    sqlconn.sqlDelete(sql);
                    //Ȼ�����ҵĿγ���ͬ��ҲҪɾ����Ҫ�˳��Ŀγ�
                    sql = "delete from SelectColum where columName='" + Colum + "'";
                    sqlconn.sqlDelete(sql);
                    //������˳��Ŀγ����²��뵽����ѡ����
                    sql = "insert into OnlineClass values('" + Colum + "','" + Teacher + "','" + Place + "','" + Week + "','" + s2 + "','" + (s + 1) + "','" + s3 + "')";
                    sqlconn.sqlUpdate(sql);
                    //�ر����ݿ�����
                    sqlconn.closeSqlConn();

                    tm = new ModifyClassModel(null);
                    //������ʾ���
                    jtb.setModel(tm);

                } else if (respose == 1) {
                    return;
                }
            }
        }
        //ȡ����ť
        else if (arg0.getSource() == jb2) {
            this.dispose();//�رմ���
        }
    }
}