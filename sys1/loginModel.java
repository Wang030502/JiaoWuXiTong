package sys1;

import SqlConnection.SqlConn;
import java.sql.ResultSet;

public class loginModel {
    SqlConn sqlconn;
    ResultSet rs;
    String sql;
    String position;
    String pwd;
    int flag;
    public static String a,b;

    public loginModel() {
    }

    public int checkUser(String userId, String password) {
        flag = 0;
        sql = "select * from login where userId='" + userId + "'";//��ȡΪuserId����һ��
        sqlconn = new SqlConn();
        rs = sqlconn.sqlQuery(this.sql);

        //�������Ȼ�ȡuserId��Ȼ�������ȡ��������͵�λ
        try {//try����catch����쳣
            while(this.rs.next()) {
                pwd = rs.getString(2);//��ȡ������ָ���е�ֵ�������ڱ���Ϊ�ڶ���
                position = rs.getString(3);//��λ��ѧ��������ʦ���ڱ�ĵ�����
                System.out.println("test1=" + this.position);
            }

            if (password.equals(this.pwd)) {
                if (this.position.equals("��ʦ")) {
                    this.flag = 0;
                     a = userId;
                     b = password;
                } else if (this.position.equals("ѧ��")) {
                    this.flag = 1;
                    a = userId;
                    b = password;
                }
            } else {
                this.flag = 2;
            }
        } catch (Exception var7) {
            //��ӡ�쳣
            var7.printStackTrace();
        } finally {
            //�ر����ݿ�
            this.sqlconn.closeSqlConn();
        }

        return this.flag;
    }
}

