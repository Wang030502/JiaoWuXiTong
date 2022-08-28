package sys1;

import SqlConnection.SqlConn;

import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

//ѧ����Ϣ
public class ShowStuMessageModel extends AbstractTableModel {
    //����������Ҫ�ļ���
    Vector rowData, row, column;
    //����һ����¼�������ڽ��մ����ݿⷵ�����ļ�¼��
    ResultSet rs;
    //����һ�������������ݿ�Ķ���
    SqlConn conn;

    //ѧ���˵���ʾ������Ϣ
    public ShowStuMessageModel(String sql, String Id) {
        if (sql == null) {
            sql = "select * from StuMessage where Id ='" + Id + "'";
        }
        //���ñ�������
        column = new Vector();
        column.add("ѧ��");
        column.add("����");
        column.add("�Ա�");
        column.add("����");
        column.add("��ַ");
        column.add("רҵ");
        column.add("�༶");
        column.add("��ѧ��");

        //������ļ�¼��
        rowData = new Vector();
        //�������ݿ�����
        conn = new SqlConn();
        rs = conn.sqlQuery(sql);
        try {
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getString(8));
                rowData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public ShowStuMessageModel(String sql) {
        if (sql == null) {
            sql = "select * from StuMessage";
        }
        //���ñ�������
        column = new Vector();
        column.add("ѧ��");
        column.add("����");
        column.add("�Ա�");
        column.add("����");
        column.add("��ַ");
        column.add("רҵ");
        column.add("�༶");
        column.add("��ѧ��");

        //������ļ�¼��
        rowData = new Vector();
        //�������ݿ�����
        conn = new SqlConn();
        rs = conn.sqlQuery(sql);
        try {
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getString(8));
                rowData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    //���ñ������
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String) this.column.get(column);
    }

    @Override
    //�õ�������
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.column.size();
    }

    //�õ�������
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }

    @Override
    //�õ�ĳ��ĳ�е�ֵ
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return ((Vector) this.rowData.get(arg0)).get(arg1);

    }
}
