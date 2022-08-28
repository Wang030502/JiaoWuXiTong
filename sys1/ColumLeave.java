package sys1;
//?????????

import SqlConnection.SqlConn;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class ColumLeave extends JDialog implements ActionListener {

        JPanel jp, jp2;
        JButton jb1, jb2, jb3, jb4;
        JLabel jlb1;
        TableModel tm;
        JTable jtb;
        JScrollPane jsp;
        public static int i = 0;
        JComboBox cmb2 = new JComboBox();//????????

    public void addView() {
        jlb1 = new JLabel("???????????:");
        jlb1.setFont(MyFont.f1);

        jb1 = new JButton("?? ??");
        jb1.setFont(MyFont.f1);
        jb1.setSize(80, 25);
        jb1.addActionListener(this);

        jb3 = new JButton("????");
        jb3.setFont(MyFont.f1);
        jb3.setSize(80, 25);
        jb3.addActionListener(this);

        jb2 = new JButton("?? ??");
        jb2.setFont(MyFont.f1);
        jb2.setSize(80, 25);
        jb2.addActionListener(this);

        jb4 = new JButton("??????");
        jb4.setFont(MyFont.f1);
        jb4.setSize(80, 25);
        jb4.addActionListener(this);

        jp2 = new JPanel();
        jp2.add(jlb1);
        JLabel jl2 = new JLabel("     ");
        jp2.add(jl2);
        jp2.add(cmb2);
        jp2.add(jl2);
        jp2.add(jb3);

        jp = new JPanel();
        jp.add(jb1);
        JLabel jl = new JLabel("            ");
        jp.add(jl);
        jp.add(jb4);
        JLabel jl3 = new JLabel("           ");
        jp.add(jl3);
        jp.add(jb2);
        this.add(jp2, BorderLayout.NORTH);
        this.add(jp, BorderLayout.SOUTH);
        this.add(jsp, "Center");

        //????
        ImageIcon bi1 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\???.png");
        ImageIcon bi2 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\???.png");
        ImageIcon bi3 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\???.png");
        ImageIcon bi4 = new ImageIcon("E:\\Java(IDEA)\\IntelliJ IDEA Community Edition 2021.3.2\\SYSTEM\\system\\src\\images2\\???.png");

        ScalePhoto(bi1,15,15);
        ScalePhoto(bi2,15,15);
        ScalePhoto(bi3,15,15);
        ScalePhoto(bi4,15,15);

        jb1.setIcon(bi1);//???
        jb2.setIcon(bi2);//???
        jb3.setIcon(bi3);//????
        jb4.setIcon(bi4);//??????
    }

    public ColumLeave(Frame Main, String title, boolean model) {
        //???????????????????????
        super(Main, title, model);

        //?????????????????
        cmb2.addItem("--?????--");
        cmb2.addItem("?????");
        cmb2.addItem("?????");
        cmb2.addItem("??????");
        cmb2.addItem("??????");
        cmb2.addItem("??????");
        cmb2.addItem("??????");
        cmb2.addItem("??????");
        cmb2.addItem("?????");
        cmb2.addItem("?????");
        cmb2.addItem("?????");
        cmb2.addItem("??????");
        cmb2.addItem("???????");
        cmb2.addItem("???????");
        cmb2.addItem("???????");
        cmb2.addItem("???????");
        cmb2.addItem("???????");
        cmb2.addItem("???????");
        cmb2.addItem("???????");

        //????????????
        jtb = new JTable();
        tm = new TeacherColumModel(null, "?????", 0);
        //?????????????????
        jtb.setModel(tm);
        //??????????
        jtb.setVisible(true);
        jsp = new JScrollPane(jtb);
        //????????????????
        this.addView();

        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    //???????
    public static void ScalePhoto(ImageIcon imageIcon, int width, int height) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == jb3) {
            //????????????????????????????
            String Week = (String) cmb2.getSelectedItem();
            if (Week.equals("--?????--")) {
                JOptionPane.showMessageDialog(this, "???????????????", "???", 1);
                return;
            } else {
                if (Week.equals("?????") || Week.equals("??????") || Week.equals("??????") || Week.equals("??????") || Week.equals("?????") || Week.equals("??????") || Week.equals("???????") || Week.equals("???????") || Week.equals("???????")) {
                    i = 1;
                } else {
                    i = 2;
                }
                tm = new TeacherColumModel(null, Week, i);
                jtb.setModel(tm);
            }//?????????
        } else if (arg0.getSource() == jb1) {
            //???????????????????????????????????????????
            String Week = (String) cmb2.getSelectedItem();
            //????????????????????
            int rowNo = jtb.getSelectedRow();
            //????????????????????
            int lie = jtb.getSelectedColumn();
            //?????????????????????????????????????????-1????????????
            if (rowNo == -1 && lie == -1) {
                JOptionPane.showMessageDialog(this, "????????????????????", "???", 1);
                return;
            } else if (rowNo == -1) {
                JOptionPane.showMessageDialog(this, "??????????????", "???", 1);
                return;
            } else if (lie == 0) {
                JOptionPane.showMessageDialog(this, "??????????", "???", 1);
                return;
            } else {
                String sql = null,sql2 = null;//sql???????????sql2????????????
                String Leave = "??????(X)";
                String Teacher = "??????";
                String time = (String) tm.getValueAt(rowNo, 0);
                //???????
                String LeaveColum = (String) tm.getValueAt(rowNo, lie);
                if (LeaveColum == null) {
                    JOptionPane.showMessageDialog(this, "???????????", "???", 1);
                    return;
                } else {
                    if (Week.equals("?????") || Week.equals("??????") || Week.equals("??????") || Week.equals("??????") || Week.equals("?????") || Week.equals("??????") || Week.equals("???????") || Week.equals("???????") || Week.equals("???????")) {
                        System.out.println(time);
                        //??????????????????
                        //mysql???????????,??????where?????????
                        if (lie == 1) {
                            //??????????????????????
                            sql = "update TeacherColum set Sunday='" + Leave + "'where JiShuWeek= '" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 2) {
                            sql = "update TeacherColum set Monday='" + Leave + "'where JiShuWeek= '" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "?????" + "','" + time + "')";
                        } else if (lie == 3) {
                            sql = "update TeacherColum set Tuesday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "?????" + "','" + time + "')";
                        } else if (lie == 4) {
                            sql = "update TeacherColum set Wednesday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 5) {
                            sql = "update TeacherColum set Thursday'" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 6) {
                            sql = "update TeacherColum set Friday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 7) {
                            sql = "update TeacherColum set Saturday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        }
                        Object[] options = {"???", "???"};
                        int respose = JOptionPane.showOptionDialog(this, "????????", "???", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
                        if (respose == 0) {
                            //?????????
                            SqlConn sqlconn = new SqlConn();
                            sqlconn.sqlUpdate(sql);
                            sqlconn.sqlUpdate(sql2);
                            //???********?????????????????????????????????????????????????????????????????????????????
                            sqlconn.closeSqlConn();
                            tm = new TeacherColumModel(null, Week, i);
                            jtb.setModel(tm);
                        } else if (respose == 1) {
                            return;
                        }
                    } else {//?????
                        if (lie == 1) {
                            //??????????????????????
                            sql = "update TeacherColum2 set Sunday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 2) {
                            sql = "update TeacherColum2 set Monday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "?????" + "','" + time + "')";
                        } else if (lie == 3) {
                            sql = "update TeacherColum2 set Tuesday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "?????" + "','" + time + "')";
                        } else if (lie == 4) {
                            sql = "update TeacherColum2 set Wednesday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 5) {
                            sql = "update TeacherColum2 set Thursday'" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 6) {
                            sql = "update TeacherColum2 set Friday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        } else if (lie == 7) {
                            sql = "update TeacherColum2 set Saturday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "insert into StopClass values('" + LeaveColum + "','" + Teacher + "','" + Week + "','" + "??????" + "','" + time + "')";
                        }
                        Object[] options = {"???", "???"};
                        int respose = JOptionPane.showOptionDialog(this, "????????", "???", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
                        if (respose == 0) {
                            //?????????
                            SqlConn sqlconn = new SqlConn();
                            sqlconn.sqlUpdate(sql);
                            sqlconn.sqlUpdate(sql2);
                            //???********?????????????????????????????????????????????????????????????????????????????
                            sqlconn.closeSqlConn();
                            tm = new TeacherColumModel(null, Week, i);
                            jtb.setModel(tm);
                        } else if (respose == 1) {
                            return;
                        }
                    }
                }
            }
        }//????????????,?????????????????
        else if (arg0.getSource() == jb4) {
//???????????????????????????????????????????
            String Week = (String) cmb2.getSelectedItem();
            //????????????????????
            int rowNo = jtb.getSelectedRow();
            //????????????????????
            int lie = jtb.getSelectedColumn();
            //?????????????????????????????????????????-1????????????
            if (rowNo == -1 && lie == -1) {
                JOptionPane.showMessageDialog(this, "???????????????????????", "???", 1);
                return;
            } else if (rowNo == -1) {
                JOptionPane.showMessageDialog(this, "?????????????????", "???", 1);
                return;
            } else if (lie == 0) {
                JOptionPane.showMessageDialog(this, "??????????", "???", 1);
                return;
            } else {
                String sql = null,sql2 = null;
                String Leave = "??????";
                String time = (String) tm.getValueAt(rowNo, 0);
                //???????
                String LeaveColum = (String) tm.getValueAt(rowNo, lie);
                if (LeaveColum == null) {
                    JOptionPane.showMessageDialog(this, "???????????", "???", 1);
                    return;
                } else {
                    if (Week.equals("?????") || Week.equals("??????") || Week.equals("??????") || Week.equals("??????") || Week.equals("?????") || Week.equals("??????") || Week.equals("???????") || Week.equals("???????") || Week.equals("???????")) {
                        System.out.println(time);
                        //??????????????????
                        //mysql???????????,??????where?????????
                        if (lie == 1) {
                            //??????????????????????
                            sql = "update TeacherColum set Sunday='" + Leave + "'where JiShuWeek= '" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 2) {
                            sql = "update TeacherColum set Monday='" + Leave + "'where JiShuWeek= '" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "?????" + "')and (Section='" + time + "')";
                        } else if (lie == 3) {
                            sql = "update TeacherColum set Tuesday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "?????" + "')and (Section='" + time + "')";
                        } else if (lie == 4) {
                            sql = "update TeacherColum set Wednesday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 5) {
                            sql = "update TeacherColum set Thursday'" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 6) {
                            sql = "update TeacherColum set Friday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 7) {
                            sql = "update TeacherColum set Saturday='" + Leave + "'where JiShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        }
                        Object[] options = {"???", "???"};
                        int respose = JOptionPane.showOptionDialog(this, "????????", "???", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
                        if (respose == 0) {
                            //?????????
                            SqlConn sqlconn = new SqlConn();
                            sqlconn.sqlUpdate(sql);
                            sqlconn.sqlDelete(sql2);
                            //???********?????????????????????????????????????????????????????????????????????????????
                            sqlconn.closeSqlConn();
                            tm = new TeacherColumModel(null, Week, i);
                            jtb.setModel(tm);
                        } else if (respose == 1) {
                            return;
                        }
                    } else {//?????
                        if (lie == 1) {
                            //??????????????????????
                            sql = "update TeacherColum2 set Sunday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 2) {
                            sql = "update TeacherColum2 set Monday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "?????" + "')and (Section='" + time + "')";
                        } else if (lie == 3) {
                            sql = "update TeacherColum2 set Tuesday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "?????" + "')and (Section='" + time + "')";
                        } else if (lie == 4) {
                            sql = "update TeacherColum2 set Wednesday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 5) {
                            sql = "update TeacherColum2 set Thursday'" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 6) {
                            sql = "update TeacherColum2 set Friday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        } else if (lie == 7) {
                            sql = "update TeacherColum2 set Saturday='" + Leave + "'where OuShuWeek='" + time + "'";
                            sql2 = "delete from StopClass where Week='" + Week + "'and (Day='" + "??????" + "')and (Section='" + time + "')";
                        }
                        Object[] options = {"???", "???"};
                        int respose = JOptionPane.showOptionDialog(this, "????????", "???", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
                        if (respose == 0) {
                            //?????????
                            SqlConn sqlconn = new SqlConn();
                            sqlconn.sqlUpdate(sql);
                            sqlconn.sqlDelete(sql2);
                            //???********?????????????????????????????????????????????????????????????????????????????
                            sqlconn.closeSqlConn();
                            tm = new TeacherColumModel(null, Week, i);
                            jtb.setModel(tm);
                        } else if (respose == 1) {
                            return;
                        }
                    }
                }
            }
        }//?????????
        else if (arg0.getSource() == jb2){
            this.dispose();
        }
    }
}
