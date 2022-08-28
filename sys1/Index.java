package sys1;

import javax.swing.*;
import java.awt.*;

public class Index extends JWindow implements Runnable{
    //�������������ص����
    JProgressBar jpb;//���������
    JLabel jl1;//�����ڴ���ı�����һ��ͼƬ���ϲ��ǽ�����

    public static void main(String []args){
        Index index=new Index();
        //����index�߳�
        Thread t=new Thread(index);
        //�����߳�
        t.start();
    }
    //���캯��
    public Index()
    {
        //������ǩ,���ڱ�ǩ�Ϸ���һ��ͼƬ
        jl1=new JLabel(new ImageIcon("E:\\IDEAUI\\IntelliJ IDEA 2022.1.3\\SYSTEM\\system\\src\\images\\index4.png"));

        //����������
        jpb=new JProgressBar();
        //���ý���������
        jpb.setStringPainted(true);//��ʾ��ǰ����ֵ��Ϣ
        jpb.setIndeterminate(false);//ȷ��������ִ����ɺ����ع���
        jpb.setBorderPainted(false);//���ý������߿���ʾ
        jpb.setBackground(Color.darkGray);//���ý������ı���ɫ

        //������
        this.add(jl1,BorderLayout.NORTH);
        this.add(jpb,BorderLayout.SOUTH);

        //���ô�������
        this.setSize(490,363);
        //���ô�����ʾ��λ��
        this.setLocationRelativeTo(null);
        //���ô�����ʾ
        this.setVisible(true);
    }
    //�������̵߳�run���������������̵߳�����
    public void run() {

        //����һ�����飬��Ž�������ʾʱ��Ҫ������
        int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
        for(int i=0;i<progressValue.length;i++)
        {
            try {
                //����0.2�룬��ִ��
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jpb.setValue(progressValue[i]);//ȡ�������еĽ���ֵ
        }
        //�رս���������
        this.dispose();
        //��������ɺ�ִ����Ӧ�Ĳ��������л��������Ĵ��ڣ�ͬʱ�رս��������ڵ�
        new Login();
    }
}
