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
        sql = "select * from login where userId='" + userId + "'";//获取为userId的那一行
        sqlconn = new SqlConn();
        rs = sqlconn.sqlQuery(this.sql);

        //遍历，先获取userId，然后遍历获取它的密码和地位
        try {//try——catch解决异常
            while(this.rs.next()) {
                pwd = rs.getString(2);//获取当行中指定列的值，密码在表中为第二行
                position = rs.getString(3);//地位（学生或者老师）在表的第三列
                System.out.println("test1=" + this.position);
            }

            if (password.equals(this.pwd)) {
                if (this.position.equals("教师")) {
                    this.flag = 0;
                     a = userId;
                     b = password;
                } else if (this.position.equals("学生")) {
                    this.flag = 1;
                    a = userId;
                    b = password;
                }
            } else {
                this.flag = 2;
            }
        } catch (Exception var7) {
            //打印异常
            var7.printStackTrace();
        } finally {
            //关闭数据库
            this.sqlconn.closeSqlConn();
        }

        return this.flag;
    }
}

