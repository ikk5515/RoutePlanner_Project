package RoutePlanner.core.Service.DAO;

import RoutePlanner.core.Service.VO.CafeVO;
import RoutePlanner.core.Service.VO.CafeteriaVO;
import RoutePlanner.core.Service.VO.PlayVO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.sql.*;

public class PointDAO {
    private Connection conn;
    private PreparedStatement ps;
    public static String totalAddr;
    private final String URL = "jdbc:oracle:thin:@routeplanner_high?TNS_ADMIN=D://swClone//wallet";

    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getConnection() {    //DriverManager를 이용하여 url에 해당하는 디비에 로그인
        try {
            conn = DriverManager.getConnection(URL, "admin", "Rkdqorrl123!@");
        } catch (Exception e) {
        }
    }

    public void disConnection() {    //연결해제
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
        }
    }

    //play테이블 IO
    public ArrayList<PlayVO> playAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
        ArrayList<PlayVO> list = new ArrayList<>();
        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principaluser;
        String idUser = userDetails.getUsername();

        try {
            String newPlayAddr = "";
            if (totalAddr != null) {
                String playSplitAddr = totalAddr;
                String playSplitArr[] = playSplitAddr.split(" ");

                for (int i = 0; i < 2; i ++)  {
                    if (i == 0) {
                        continue;
                    }
                    newPlayAddr += playSplitArr[i];
                }
            }

            getConnection();    //오라클 연결
            String sql = "select * from incheon_play where PLAYGROUP like '%' || (select USERWHAT from SURVEY where USERID = ?) || '%' and PLAYADDR like '%' || ? || '%' order by dbms_random.value";

            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, idUser);
            ps.setString(2, newPlayAddr);

            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장
            while (rs.next()) {
                if (rs.getRow() == 2) {
                    break;
                }
                PlayVO vo = new PlayVO();
                vo.setPlayno(rs.getString(1));
                vo.setPlaykind(rs.getString(2));
                vo.setPlaywhat(rs.getString(3));
                vo.setPlayname(rs.getString(4));
                vo.setPlayaddr(rs.getString(5));
                totalAddr = rs.getString(5);
                vo.setPlaygroup(rs.getString(6));
                list.add(vo); //list에 삽입
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            disConnection();    //종료
        }
        return list;
    }

    //cafeteria테이블 IO
    public ArrayList<CafeteriaVO> cafeteriaAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
        ArrayList<CafeteriaVO> list = new ArrayList<>();;

        try {
            String playSplitAddr = totalAddr;
            String newPlayAddr = "";
            String playSplitArr[] = playSplitAddr.split(" ");

            for (int i = 0; i < 2; i ++)  {
                if (i == 0) {
                    continue;
                }
                newPlayAddr += playSplitArr[i];
            }

            getConnection();    //오라클 연결
            String sql = "select * from incheon_cafeteria where RESTFROM like '%' || ? || '%' order by dbms_random.value";


            ps = conn.prepareStatement(sql.toString());  //쿼리 실행
            ps.setString(1, newPlayAddr);
            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장

            while (rs.next()) {
                if (rs.getRow() == 2) {
                    break;
                }
                CafeteriaVO vo = new CafeteriaVO();
                vo.setRestno(rs.getString(1));
                vo.setRestfrom(rs.getString(2));
                vo.setRestname(rs.getString(3));
                vo.setRestmenu(rs.getString(4));
                vo.setRestaddr(rs.getString(5));
                vo.setRestgroup(rs.getString(6));
                list.add(vo); //list에 삽입
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            disConnection();    //종료
        }
        return list;
    }

    //cafe테이블 IO
    public ArrayList<CafeVO> cafeAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
        ArrayList<CafeVO> list = new ArrayList<>();

        try {
            String playSplitAddr = totalAddr;
            String newPlayAddr = "";
            String playSplitArr[] = playSplitAddr.split(" ");

            for (int i = 0; i < 2; i ++)  {
                if (i == 0) {
                    continue;
                }
                newPlayAddr += playSplitArr[i];
            }

            getConnection();    //오라클 연결
            String sql = "select * from incheon_cafe where CAFEFROM like '%' || ? || '%' order by dbms_random.value";


            ps = conn.prepareStatement(sql.toString());  //쿼리 실행
            ps.setString(1, newPlayAddr);
            ResultSet rs = ps.executeQuery();           //ResultSet객체로 결과 저장

            while (rs.next()) {
                if (rs.getRow() == 2) {
                    break;
                }
                CafeVO vo = new CafeVO();
                vo.setCafeno(rs.getString(1));
                vo.setCafefrom(rs.getString(2));
                vo.setCafename(rs.getString(3));
                vo.setCafekind(rs.getString(4));
                vo.setCafemenu(rs.getString(5));
                vo.setCafeaddr(rs.getString(6));
                list.add(vo); //list에 삽입
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            disConnection();    //종료
        }
        return list;
    }
}
