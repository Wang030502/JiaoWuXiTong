package sys1;

import SqlConnection.SqlConn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddStu extends JDialog implements ActionListener {

    //�������ѧ����Ϣ��������
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
    JButton jb1,jb2,jb3;
    ResultSet rs;
    int stuAge=0;
    Double stuSourse=0.0;
    int i=0;//�����жϵ��׵������ӻ���ȡ�����������Ƿ�ִ�����ݸ��²���
    public int falg()
    {
        return i;
    }


    //�������ѧ������ĺ�����װ
    public void addView()
    {
        jl1=new JLabel("ѧ �ţ�");
        jl1.setBounds(20, 20, 60, 25);
        jl1.setFont(MyFont.f1);

        jl2=new JLabel("�� ����");
        jl2.setFont(MyFont.f1);
        jl2.setBounds(250, 20, 60, 25);

        jl3=new JLabel("�� ��");
        jl3.setFont(MyFont.f1);
        jl3.setBounds(20, 60, 60, 25);

        jl4=new JLabel("�� �䣺");
        jl4.setFont(MyFont.f1);
        jl4.setBounds(250, 60, 60, 25);

        jl5=new JLabel("�����أ�");
        jl5.setFont(MyFont.f1);
        jl5.setBounds(14, 100, 60, 25);

        jl6=new JLabel("ר ҵ��");
        jl6.setFont(MyFont.f1);
        jl6.setBounds(20, 140, 60, 25);

        jl7=new JLabel("�� ����");
        jl7.setFont(MyFont.f1);
        jl7.setBounds(20, 180, 60, 25);

        jl8=new JLabel("��ѧ�֣�");
        jl8.setFont(MyFont.f1);
        jl8.setBounds(240, 180, 60, 25);

        jtf1=new JTextField(20);
        jtf1.setBounds(70, 20, 130, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());//������ά�°�Ч��

        jtf2=new JTextField(20);
        jtf2.setBounds(300, 20, 130, 25);
        jtf2.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf3=new JTextField(10);
        jtf3.setBounds(70, 60, 60, 25);
        jtf3.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf4=new JTextField(10);
        jtf4.setBounds(300, 60, 60, 25);
        jtf4.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf5=new JTextField(30);
        jtf5.setBounds(70, 100, 360, 25);
        jtf5.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf6=new JTextField(20);
        jtf6.setBounds(70, 140, 290, 25);
        jtf6.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf7=new JTextField(20);
        jtf7.setBounds(70, 180, 130, 25);
        jtf7.setBorder(BorderFactory.createLoweredBevelBorder());

        jtf8=new JTextField(20);
        jtf8.setBounds(300, 180, 130, 25);
        jtf8.setBorder(BorderFactory.createLoweredBevelBorder());

        jb1=new JButton("�� ��");
        jb1.setFont(MyFont.f1);
        jb1.setBounds(95, 220, 90, 25);
        jb1.addActionListener(this);//��ťһ����������Ӽ������������޷�ʵ��

        jb2=new JButton("ȡ ��");
        jb2.setFont(MyFont.f1);
        jb2.setBounds(300, 220, 90, 25);
        jb2.addActionListener(this);

        jb3=new JButton("�� ��");
        jb3.setFont(MyFont.f1);
        jb3.setBounds(195,220,90,25);
        jb3.addActionListener(this);

        this.setLayout(null);
        //�������ӵ�����
        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jtf2);
        this.add(jl3);
        this.add(jtf3);
        this.add(jl4);
        this.add(jtf4);
        this.add(jl5);
        this.add(jtf5);
        this.add(jl6);
        this.add(jtf6);
        this.add(jl7);
        this.add(jtf7);
        this.add(jl8);
        this.add(jtf8);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);

        //Сͼ��
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\���.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\���.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\ȡ��.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);
        ScalePhoto(bi3,15,15);

        jb1.setIcon(bi1);
        jb2.setIcon(bi3);
        jb3.setIcon(bi2);

    }

    public AddStu(Frame Main,String title,boolean model)
    {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main,title,model);
        //�������ѧ����Ϣ����ĵķ���
        this.addView();
        //���ô��������
        this.setSize(465,300);
        this.setLocationRelativeTo(null);//���ó�ʼλ�����м�
        this.getContentPane().setBackground(Color.LIGHT_GRAY);//���ñ�������������ʾ����ǰ�棬��������ʾ����
        this.setVisible(true);
        this.setResizable(false);//���ڴ�С���ɸı�

    }

    //Сͼ����С
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //�����ж������ѧ���Ƿ����ʱ����������򷵻ظ�ѧ�ţ����򷵻�null,������������һ�����ڽ��ո÷��ص�ѧ��
        //�����ø�No�ĳ�ʼֵΪ�գ����򱨴�
        String No = null ;
        //���������Ӱ�ť
        if(e.getSource()==jb1)
        {
            //***********************************//
            //��ȡ�ı������Ϣ
            String stuId=jtf1.getText().trim();
            //�жϣ��������ı�������ֵΪ��
            if(stuId.equals(""))
            {
                JOptionPane.showMessageDialog(this, "������ѧ�ţ�");
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            String stuName=jtf2.getText().trim();
            if(stuName.equals(""))
            {
                JOptionPane.showMessageDialog(this, "������������");
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            String stuSex=jtf3.getText().trim();
            if(stuSex.equals(""))
            {
                JOptionPane.showMessageDialog(this, "�������Ա�");
                return;//���ص�������棬���û��return��䣬���ص�������
            }

            ////�������䣬����Ҫ���������жϣ�һ���ǲ���Ϊ�գ���һ��������int�ͣ��������쳣���ж������ѧ�������Ƿ���������
            //******************************************//
            try {
                stuAge=Integer.parseInt(jtf4.getText().trim());//�Ѵ��ı���ȡ�õ��ַ���ת�������ͣ�������쳣��������Ĳ���������
                if(stuAge<1)
                {
                    JOptionPane.showMessageDialog(this, "���������ڻ����1��");
                    return;
                }
            } catch (Exception e2) {
                //��ʾ����Ĳ�������
                JOptionPane.showMessageDialog(this, "������һ�����������䣡");
                //������쳣���򷵻ص���Ӵ��ڣ�������ִֹ��******************************//
                return;
                // TODO: handle exception
            }
            //*******************************************************************//
            String stuJg=jtf5.getText().trim();
            if(stuJg.equals(""))
            {
                JOptionPane.showMessageDialog(this, "�������ַ��");
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            String stuZy=jtf6.getText().trim();
            if(stuZy.equals(""))
            {
                JOptionPane.showMessageDialog(this, "������רҵ��");
                return;//���ص�������棬���û��return��䣬���ص�������
            }
            String classId=jtf7.getText().trim();
            if(classId.equals(""))
            {
                JOptionPane.showMessageDialog(this, "�������ţ�");
                return;//���ص�������棬���û��return��䣬���ص�������
            }

            //*******************************************//
            try {
                stuSourse=Double.parseDouble(jtf8.getText().trim());
                if(stuSourse==0.0)
                {
                    JOptionPane.showMessageDialog(this, "��������ѧ�֣�");
                    return;//���ص�������棬���û��return��䣬���ص�������
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "������һ��������С������ѧ�֣�");
                return;
                // TODO: handle exception
            }

            //**********************************************//

            //�������жϸ������Ƿ������ݿ����Ƿ���ڣ���ηֱ��ж��Ա��Ƿ�Ϊ���С����ߡ�Ů���������Ƿ�Ϊ���֣���ѧ���Ƿ�Ϊ�����ͻ�˫������
            String sql="select * from stuMessage where Id='"+stuId+"'";
            SqlConn sqlconn=new SqlConn();
            rs=sqlconn.sqlQuery(sql);
            try {
                while(rs.next())
                {   //Ϊ��ȡ�������ǰ�еĵ�n������
                    No=rs.getString(1);//�������Ƿ���ڸ�ѧ����ѧ�ţ�������ڣ��򷵻ظ�ѧ�ţ������ڣ���Ϊ�ա�
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                // TODO: handle exception
            }
            if(No==null)
            {
                if((stuSex.equals("��")||stuSex.equals("Ů")))
                {
                    //�������ݿ�����
                    sql="insert into stuMessage values('"+stuId+"','"+stuName+"','"+stuSex+"','"+stuAge+"','"+stuJg+"','"+stuZy+"','"+classId+"','"+stuSourse+"')";
                    //new һ��sqlconn��Ķ���
                    sqlconn=new SqlConn();
                    sqlconn.sqlUpdate(sql);
                    this.i=1;
                    //�ر����ݿ�����
                    sqlconn.closeSqlConn();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "�Ա�Ӧ�����л�Ů��");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "��ѧ���Ѿ����ڣ��������µ�ѧ�ţ�");
            }
        }
        //��������ȡ����ť����ر�ģʽ�Ի���
        else if(e.getSource()==jb2)
        {
            //�˳���ǰ����
            this.dispose();
        }
        else if(e.getSource()==jb3)
        {
            //����ı�����Ϣ
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
            jtf4.setText("");
            jtf5.setText("");
            jtf6.setText("");
            jtf7.setText("");
            jtf8.setText("");

        }
    }
}

