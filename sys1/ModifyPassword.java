package sys1;

import SqlConnection.SqlConn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ModifyPassword extends JDialog implements ActionListener {

    //������������Ҫ�����
    JLabel jl1, jl2, jl3;
    JPasswordField jtf1, jtf2, jtf3;
    JButton jb1, jb2, jb3;
    SqlConn sqlConn;
    ResultSet rs;
    String OriginPsw;
    public static int i = 1;//i=0�������޸ĳɹ���رյ�ǰ���еĶԻ��򣬲������µ�¼

    public void MP() {
        jl1 = new JLabel("ԭ����:");
        jl1.setBounds(75, 20, 60, 25);
        jl1.setFont(MyFont.f1);

        jl2 = new JLabel("������:");
        jl2.setFont(MyFont.f1);
        jl2.setBounds(75, 50, 60, 25);

        jl3 = new JLabel("�ٴ�����������:");
        jl3.setFont(MyFont.f1);
        jl3.setBounds(15, 80, 120, 25);

        jtf1 = new JPasswordField(20);
        jtf1.setBounds(140, 18, 130, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf2 = new JPasswordField(  20);
        jtf2.setBounds(140, 48, 130, 25);
        jtf2.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf3 = new JPasswordField(20);
        jtf3.setBounds(140, 78, 130, 25);
        jtf3.setBorder(BorderFactory.createLoweredBevelBorder());

        jb1 = new JButton("�� ��");
        jb1.setFont(MyFont.f1);
        jb1.setBounds(45, 120, 80, 25);
        jb1.addActionListener(this);

        jb2 = new JButton("ȡ ��");
        jb2.setFont(MyFont.f1);
        jb2.setBounds(225, 120, 80, 25);
        jb2.addActionListener(this);

        jb3 = new JButton("�� ��");
        jb3.setFont(MyFont.f1);
        jb3.setBounds(135, 120, 80, 25);
        jb3.addActionListener(this);

        //���ô����Ĭ�ϲ���Ϊ��
        //�������ӵ�������
        this.setLayout(null);
        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jtf2);
        this.add(jl3);
        this.add(jtf3);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
    }

    public ModifyPassword(Frame Main, String title, boolean model) {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main, title, model);

        //�����޸�ѧ��,��ʦ����Ľ���ķ���
        this.MP();

        //���ô��������
        this.setSize(365, 200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
        //��������޸İ�ť
        if (e.getSource() == jb1) {
            //��ȡ�������¼�˺ŵ�����
            String sql1 ="select password from login where userId='"+loginModel.a+"'";
            sqlConn = new SqlConn();
            rs = sqlConn.sqlQuery(sql1);
           //����������룬����ֱ�Ӳ�ѯ����ȡ����
            try {
                while (rs.next()){
                    OriginPsw = rs.getString(1);
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
            //��ȡ�ı������Ϣ
            String Psw = new String(jtf1.getPassword()).trim();
            String NewPaw = new String(jtf2.getPassword()).trim();
            String AgainPsw = new String(jtf3.getPassword()).trim();

            if (Psw.equals("")) {
                JOptionPane.showMessageDialog(this, "������ԭ���룡", "����", 2);
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            if (NewPaw.equals("")) {
                JOptionPane.showMessageDialog(this, "�����������룡", "��ʾ", 1);
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            if (AgainPsw.equals("")) {
                JOptionPane.showMessageDialog(this, "���ٴ�����������", "��ʾ", 1);
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            if (!(NewPaw.equals(AgainPsw))) {
                JOptionPane.showMessageDialog(this, "������������벻һ��", "����", 2);
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            if (!(OriginPsw.equals(Psw))) {
                JOptionPane.showMessageDialog(this, "ԭ�������", "����", 2);
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            //�������ݿ�����
            //���ò��ݸ��µ�sql���
            Object[] options = {"ȷ���˳�", "ȡ���޸�"};
            int respose = JOptionPane.showOptionDialog(this, "�޸ĳɹ����������µ�¼", "��ʾ", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
            if (respose == 0) {
                String sql = "update login set password='"+NewPaw+"' where userId='"+loginModel.a+"'";
                SqlConn sqlconn = new SqlConn();
                sqlconn.sqlUpdate(sql);
                //�ر����ݿ�����
                sqlconn.closeSqlConn();
                //�رնԻ���
                i=0;
                this.dispose();
            } else if (respose == 1) {
                return;
            }
        }
        //��������ȡ����ť����ر�ģʽ�Ի���
        else if (e.getSource() == jb2) {
            this.dispose();
        }
        //�������������ť����������еĹ㱾�������
        else if (e.getSource() == jb3) {
            //����ѧ���������������޸ģ�
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
        }
    }
}
