package RoutePlanner.core.controller.dao;

import java.util.*;
import java.sql.*;

public class PointDAO {
    private Connection conn;
    private PreparedStatement ps;
    private final String URL = "jdbc:oracle:thin:@routeplanner_high?TNS_ADMIN=/Users/ingi/wallet/wallet";

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
        try {
            getConnection();    //오라클 연결
            String sql = "select * from incheon_play";

            ps = conn.prepareStatement(sql);  //쿼리 실행
            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장
            while (rs.next()) {
                if (rs.getRow() == 6) {
                    break;
                }
                PlayVO vo = new PlayVO();
                vo.setPlayno(rs.getString(1));
                vo.setPlaykind(rs.getString(2));
                vo.setPlaywhat(rs.getString(3));
                vo.setPlayname(rs.getString(4));
                vo.setPlayaddr(rs.getString(5));
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
        ArrayList<CafeteriaVO> list = new ArrayList<>();
        try {
            getConnection();    //오라클 연결
            String sql = "select * from incheon_cafeteria";

            ps = conn.prepareStatement(sql);  //쿼리 실행
            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장

            while (rs.next()) {
                if (rs.getRow() == 6) {
                    break;
                }
                CafeteriaVO vo = new CafeteriaVO();
                vo.setRestno(rs.getString(1));
                vo.setRestfrom(rs.getString(2));
                vo.setRestname(rs.getString(3));
                vo.setRestmenu(rs.getString(5));
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
            getConnection();    //오라클 연결
            String sql = "select * from incheon_cafe";

            ps = conn.prepareStatement(sql);  //쿼리 실행
            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장

            while (rs.next()) {
                if (rs.getRow() == 6) {
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
