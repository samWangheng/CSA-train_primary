import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class homework_5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "165195183wsh";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建student表
            String createTableSql = "CREATE TABLE student (" +
                    "SNO VARCHAR(20), " +
                    "Name VARCHAR(10), " +
                    "Age INTEGER, " +
                    "Collage VARCHAR(30)" +
                    ")";
            PreparedStatement createTableStmt = conn.prepareStatement(createTableSql);
            createTableStmt.executeUpdate();
            createTableStmt.close();
            System.out.println("student表创建成功！");

            // 插入数据
            String insertDataSql = "INSERT INTO student (SNO, Name, Age, Collage) VALUES (?, ?, ?, ?)";
            PreparedStatement insertDataStmt = conn.prepareStatement(insertDataSql);
            insertDataStmt.setString(1, "s001");
            insertDataStmt.setString(2, "老大");
            insertDataStmt.setInt(3, 20);
            insertDataStmt.setString(4, "计算机学院");
            insertDataStmt.executeUpdate();

            insertDataStmt.setString(1, "s002");
            insertDataStmt.setString(2, "老二");
            insertDataStmt.setInt(3, 19);
            insertDataStmt.setString(4, "计算机学院");
            insertDataStmt.executeUpdate();

            insertDataStmt.setString(1, "s003");
            insertDataStmt.setString(2, "老三");
            insertDataStmt.setInt(3, 18);
            insertDataStmt.setString(4, "计算机学院");
            insertDataStmt.executeUpdate();

            insertDataStmt.setString(1, "s004");
            insertDataStmt.setString(2, "老四");
            insertDataStmt.setInt(3, 17);
            insertDataStmt.setString(4, "计算机学院");
            insertDataStmt.executeUpdate();

            insertDataStmt.close();
            System.out.println("数据插入成功！");

            // 查询表中的所有信息并输出到控制台
            String querySql = "SELECT * FROM student";
            PreparedStatement queryStmt = conn.prepareStatement(querySql);
            ResultSet rs = queryStmt.executeQuery();
            while (rs.next()) {
                String sno = rs.getString("SNO");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String collage = rs.getString("Collage");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", Collage: " + collage);
            }
            rs.close();
            queryStmt.close();

            // 删除SNO为"s004"的记录
            String deleteSql = "DELETE FROM student WHERE SNO = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
            deleteStmt.setString(1, "s004");
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("已成功删除SNO为's004'的记录！");
            } else {
                System.out.println("未找到SNO为's004'的记录，删除失败！");
            }
            deleteStmt.close();

            // 查询SNO为"s003"的记录
            String queryS003Sql = "SELECT * FROM student WHERE SNO = ?";
            PreparedStatement queryS003Stmt = conn.prepareStatement(queryS003Sql);
            queryS003Stmt.setString(1, "s003");
            ResultSet rsS003 = queryS003Stmt.executeQuery();
            if (rsS003.next()) {
                String sno = rsS003.getString("SNO");
                String name = rsS003.getString("Name");
                int age = rsS003.getInt("Age");
                String collage = rsS003.getString("Collage");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", Collage: " + collage);
            } else {
                System.out.println("未找到SNO为's003'的记录！");
            }
            rsS003.close();
            queryS003Stmt.close();
            // 修改SNO为"s001"的记录
            String updateSql = "UPDATE student SET Collage = ? WHERE SNO = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, "通信学院");
            updateStmt.setString(2, "s001");
            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("已成功修改SNO为's001'的记录！");
            } else {
                System.out.println("未找到SNO为's001'的记录，修改失败！");
            }
            updateStmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

