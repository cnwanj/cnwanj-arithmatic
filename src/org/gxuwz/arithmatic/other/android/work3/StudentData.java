package org.gxuwz.arithmatic.other.android.work3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentData extends DBUtil {

    // 添加
    public int add(Student stu) throws SQLException {
        try {
            String sql = "insert into student values(?, ?, ?, ?, ?)";
            Object[] arr = {stu.getsNo(), stu.getsName(), stu.getsSex(), stu.getsClass(), stu.getsBirthday()};
            return executeUpdate(sql, arr);
        } catch (SQLException e) {
            throw new SQLException("添加操作失败！" + e.getMessage(), e);
        } finally {
            close(stmt, conn);
        }
    }

    // 删除
    public int delete(Integer sNo) throws SQLException {
        try {
            String sql = "delete from student where s_no = ?";
            Object[] arr = {sNo};
            return executeUpdate(sql, arr);
        } catch (SQLException e) {
            throw new SQLException("删除操作失败！" + e.getMessage(), e);
        } finally {
            close(stmt, conn);
        }
    }

    // 修改
    public int update(Student stu) throws SQLException {
        try {
            String sql = "update student set s_name = ?, " +
                    "s_sex = ?, s_class = ?, s_birthday = ? where s_no = ?";
            Object[] arr = {stu.getsName(), stu.getsSex(), stu.getsClass(), stu.getsBirthday(), stu.getsNo()};
            return executeUpdate(sql, arr);
        } catch (SQLException e) {
            throw new SQLException("修改操作失败！" + e.getMessage(), e);
        } finally {
            close(stmt, conn);
        }
    }

    // 查询所有
    public List<Student> find() throws SQLException {
        List<Student> listStu = new ArrayList<>();
        try {
            String sql = "select * from student where 1=1";
            rs = executeQuery(sql, null);
            while (rs.next()) {
                Student stu = new Student(rs.getInt("s_no"),
                        rs.getString("s_name"), rs.getInt("s_sex"),
                        rs.getString("s_class"), rs.getString("s_birthday"));
                listStu.add(stu);
            }
        } catch (SQLException e) {
            throw new SQLException("查询数据库失败！" + e.getMessage(), e);
        } finally {
            close(rs, stmt, conn);
        }
        return listStu;
    }
}
