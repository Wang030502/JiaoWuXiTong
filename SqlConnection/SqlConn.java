package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlConn {
    Connection ct = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://localhost:3306/stu";
    String userName = "root";
    String password = "wb030502";

    //ʵ����ӣ��޸Ĺ��ܵķ���
    public void sqlUpdate(String sql) {
        try {
            //��������
            Class.forName(driver);
            ct = DriverManager.getConnection(dburl, userName, password);//��ȡ����
            ps = ct.prepareStatement(sql);//������̬���󣬲���Ϊsql���
            //ִ����ӣ����²���
            int i = ps.executeUpdate();//����һ��ֵ�����Ϊ1���ʾ��ӳɹ���
            if (i == 1) {
                System.out.println("������ӳɹ���");
            } else {
                System.out.println("�������ʧ�ܣ�");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    //��ѯ����
    public ResultSet sqlQuery(String sql) {

        try {
            //��������
            Class.forName(driver);
            ct = DriverManager.getConnection(dburl, userName, password);//��ȡ����
            ps = ct.prepareStatement(sql);//������̬���󣬲���Ϊsql���
            rs = ps.executeQuery();//ִ�в�ѯ���ܣ��������ݼ������浽����rs��

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return rs;
    }
    //ʵ��ɾ��ѧ����¼�ķ���
    public void sqlDelete(String sql) {
        try {
            //��������
            System.out.println("ok");
            Class.forName(driver);
            ct = DriverManager.getConnection(dburl, userName, password);
            ps = ct.prepareStatement(sql);
            System.out.println("ok1");
            //ִ����ӣ����²���
            int i = ps.executeUpdate();//����һ��ֵ�����Ϊ1���ʾɾ���ɹ���
            if (i == 1) {
                System.out.println("����ɾ���ɹ���");
            } else {
                System.out.println("����ɾ��ʧ�ܣ�");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    //ʵ�ֹر����ݿ����ӵĹ���
    public void closeSqlConn() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (ct != null) ct.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}





