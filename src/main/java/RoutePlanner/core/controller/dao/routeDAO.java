package RoutePlanner.core.controller.dao;

import java.util.*;
import java.sql.*;

public class routeDAO {
    private Connection conn;
    private PreparedStatement ps;
    private final String URL = "jdbc:oracle:thin:@routeplanner_high?TNS_ADMIN=D://swClone//wallet";

    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getConnection(){
        try{
            conn = DriverManager.getConnection(URL, "admin","Rkdqorrl123!@");
        }catch (Exception e){}
    }
    public void disConnection(){
        try{
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }catch (Exception e){}
    }
    
    public ArrayList<routeVO> routeAllData(){
        ArrayList<routeVO> list = new ArrayList<>();
        try{
            getConnection();    //오라클 연결
            String sql = "select * from incheon_play where playname like '%연평%'";

            ps = conn.prepareStatement(sql);  //쿼리 실행
            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장

            while(rs.next()){
                routeVO vo = new routeVO();
                vo.setPlayno(rs.getString(1));
                vo.setPlaykind(rs.getString(2));
                vo.setPlaywhat(rs.getString(3));
                vo.setPlayname(rs.getString(4));
                vo.setPlayaddr(rs.getString(5));
                vo.setPlaygroup(rs.getString(6));
                list.add(vo); //list에 삽입
            }
            rs.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            disConnection();    //종료
        }
        return list;
    }
}
