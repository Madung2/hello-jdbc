package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;


/*JDBC 메니저 사용*/
@Slf4j
public class MemberRepositoryV0 {
    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;//연결할 커넥션
        PreparedStatement pstmt = null;//이걸가지고 db에 쿼리를 날리는 것임
        try {
            con = getConnection();//DBConnectionUtil.getConnection()
            pstmt =con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());//파라미터 바인딩
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;

        } catch (SQLException e) {
            log.error("db error", e);
//            e.printStackTrace("db error", e);
            throw e;
            //throw: try문에서 발생한 error에 대한 정보 전달
        } finally {
            //에러가 나면 close가 터질 수 있기 때문에 다시 if문을 사용해서 정의해줘야한다.
            close(con, pstmt, null);
            //쿼리를 실행하고 나면 리소스를 반환해줘야 함.=> close

        }
    }
    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs!= null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }
    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
