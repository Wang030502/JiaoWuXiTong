/*
 * ���ܣ�����ѧ����Ϣ��ѯ���ڣ����û��ڹ����ڣ���������ĶԻ���ʵ��
 * */
package sys1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindStu extends JDialog implements ActionListener{
    //�����ѯ����Ҫ���������
    JPanel jp1;
    JLabel jp1_jl1;
    JTextField jp1_jtf1;
    JButton jp1_jb1,jp1_jb2,jp1_jb3;
    JTable jtb;
    JScrollPane jsp;
    ShowStuMessageModel tm;

    public FindStu(Frame Main,String title ,boolean model)
    {
        //���ø���Ĺ��췽����ʵ��ģʽ�Ի�
        super(Main,title,model);
        jp1=new JPanel();

        jp1_jl1=new JLabel("������ѧ�ţ�");
        jp1_jl1.setFont(MyFont.f1);
        jp1_jtf1=new JTextField(15);

        jp1_jb1=new JButton("�� ѯ");
        jp1_jb1.setFont(MyFont.f1);
        jp1_jb1.addActionListener(this);

        jp1_jb2=new JButton("�� ��");
        jp1_jb2.setFont(MyFont.f1);
        jp1_jb2.addActionListener(this);

        jp1_jb3=new JButton("��ʾ����ѧ��");
        jp1_jb3.setFont(MyFont.f1);
        jp1_jb3.addActionListener(this);

        //�������ӵ�JPanel��
        jp1.add(jp1_jl1);
        jp1.add(jp1_jtf1);
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);
        jp1.add(jp1_jb3);

        jtb=new JTable();
        jsp=new JScrollPane(jtb);
        this.add(jp1,"North");
        this.add(jsp,"Center");

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

        this.setSize(700,400);
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
        if(arg0.getSource()==jp1_jb1)
        {
            //��ȡ�ı����ֵ
            String Id=jp1_jtf1.getText().trim();//����trim()��ȥ���ı���ǰ������еĿո񣬵�����ȥ���ַ����еĿո�
            String sql="select * from stuMessage where Id='"+Id+"'";

            //����ģ��
            tm=new ShowStuMessageModel(sql);
            jtb.setModel(tm);
        }
        //�������������ť
        else if(arg0.getSource()==jp1_jb2)
        {
            jp1_jtf1.setText("");
        }
        //����������ʾ����ѧ��
        else if(arg0.getSource()==jp1_jb3)
        {
            tm=new ShowStuMessageModel(null);
            jtb.setModel(tm);
        }
    }

}
