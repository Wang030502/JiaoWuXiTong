package sys1;

import javax.swing.*;
import java.awt.event.ActionListener;

import SqlConnection.SqlConn;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
    //�����½������Ҫ�����
    JLabel jl1, jl2;
    JTextField jtf1;
    JPasswordField jpf1;
    JButton jb1, jb2;

    //���������������ݿ�������Ҳ����com.SqlConnection���µ�SqlConn����
    SqlConn sqlconn;
    //�������ڴ���SQL���ı���
    String sql;
    //����һ�����ڽ��յ�½��֤�������ļ�¼��
    ResultSet rs;
    //����������֤��½�û���ģ��
    loginModel loginModel;
    int flag;

    public static void main(String[] args) {
        Login login = new Login();
    }

    public Login() {

        //������½��������
        jl1 = new JLabel("�� �ţ�");
        jl1.setFont(MyFont.f1);
        jl1.setBounds(50, 50, 60, 25);

        jl2 = new JLabel("�� �룺");
        jl2.setFont(MyFont.f1);
        jl2.setBounds(50, 90, 60, 25);

        jtf1 = new JTextField(20);
        jtf1.setBounds(110, 50, 150, 25);
        jtf1.setBorder(BorderFactory.createLoweredBevelBorder());//�����ı����°�����άЧ��

        jpf1 = new JPasswordField(20);
        jpf1.setBorder(BorderFactory.createLoweredBevelBorder());
        jpf1.setBounds(110, 90, 150, 25);

        jb1 = new JButton("�� ½");
        jb1.setFont(MyFont.f1);
        jb1.addActionListener(this);
        jb1.setBounds(85, 130, 75, 25);

        jb2 = new JButton("�˳�");
        jb2.setFont(MyFont.f1);
        jb2.addActionListener(this);
        jb2.setBounds(175, 130, 75, 25);

        //����͹������Ч��
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());

        //��ӵ�����
        //�����ô���Ŀղ���
        this.setLayout(null);
        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jpf1);
        this.add(jb1);
        this.add(jb2);

        //����һ��BackImage����
        BackImage bi = new BackImage();
        //�趨ͼƬ��λ��
        bi.setBounds(0, 0, 350, 250);
        this.add(bi);
        this.setSize(350, 250);
        this.setTitle("�ϻ���ѧ����ϵͳ");
        //���ô�������Ļ�ĳ�ʼλ��,Ϊ�м�
        this.setLocationRelativeTo(null);
        //���ô��ڲ��ɸı��С
        this.setResizable(false);
        //ע�⣺************���ô��ڵı�����ɫ�������Ǽ̳�Swing�������Ա����ȵõ����ڵ�һ����壬Ȼ����ͨ��������ȥ���ñ���ɫ���������ò���ʾ����
        //this.getContentPane().setBackground(Color.gray);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���x���˳�����

        //���Ͻ�Сͼ��
        try {
            this.setIconImage(ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\index8.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    //����һ���ڲ��࣬���̳�JPanle�����ڻ�����ͼƬ
    class BackImage extends JPanel {
        Image im;

        public BackImage() {
            try {
                im = ImageIO.read(new File("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images\\Login.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Ҫ��ͼƬ����JPanle����Ҫ��дһ��Paint����
        public void paint(Graphics g) //�˴���paint�е�p��Сд��
        //����Ǵ�д���������дpaint�����ˣ�����һ���µķ����ˣ���ô�����ͼƬ�ǲ��������
        {
            g.drawImage(im, 0, 0, 350, 250, this);
        }
    }

    //������
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //���˵����˵�½��ť
        if (e.getSource() == jb1) {
            //��ȡ������û���������
            //trim()��ȥ���ַ�����Ŀո�
            String userId = jtf1.getText().trim();//��ȡ��¼�˺�
            System.out.println("userId=" + userId);//��ӡ����ʾ̨
            String password = new String(jpf1.getPassword());
            //�˴�����ͨ��getText()����ȡ���Ӱ�ȫ�Ƕȿ��ǣ�ͨ��getPassword()����ȡ������ͨ��new String���������
            System.out.println("password=" + password);//��ӡ����ʾ̨

            if ((userId.equals("") || userId == null) && (password.equals("") || password == null)) {
                JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�", "��ʾ", 2);
            } else {
                if (userId.equals("") || userId == null) {
                    JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�", "��ʾ", 2);
                } else if (password.equals("") || password == null) {
                    JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "��ʾ", 2);
                } else {
                    //���ô����½�û���֤��ģ��
                    loginModel = new loginModel();
                    flag = loginModel.checkUser(userId, password);//����˺������Ƕ�Ӧ����ѧ��������ʦ
                    //�ж��û����������Ƿ���ȷ
                    if (flag == 0) {
                        //0Ϊ��ʦ����
                        new TeacherView();//������ʦ����
                        this.dispose();//�رյ�ǰ����
                    }
                    if (flag == 1) {
                        //1Ϊѧ������
                        new StuMainView();
                        this.dispose();
                    }
                    if (flag == 2) {
                        JOptionPane.showMessageDialog(this, "�û������������", "����", 2);
                    }
                }
            }
        }//�˳���ť
        else if (e.getSource() == jb2) {
            Object[] options = {"ȷ��", "ȡ��"};
            int respose = JOptionPane.showOptionDialog(this, "��ȷ��Ҫ�˳�ϵͳ��", "��ʾ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (respose == 0) {
                System.out.println("�㰴����ȷ�ϰ�ť��");
                System.exit(0);//�˳�ϵͳ
            } else if (respose == 1) {
                System.out.println("�㰴����ȡ����ť��");
                return;
            }
        }
    }
}
