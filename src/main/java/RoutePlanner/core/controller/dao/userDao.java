////package RoutePlanner.core.controller.dao;
////
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.stereotype.Component;
////
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.util.ArrayList;
////
////@Component
////public class userDao {
////    private Connection conn;
////    private PreparedStatement ps;
////    private final String URL = "jdbc:oracle:thin:@routeplanner_high?TNS_ADMIN=/Users/ingi/wallet/wallet";
////
////    {
////        try {
////            Class.forName("oracle.jdbc.driver.OracleDriver");
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////        }
////    }
////
////    public void getConnection() {    //DriverManager를 이용하여 url에 해당하는 디비에 로그인
////        try {
////            conn = DriverManager.getConnection(URL, "admin", "Rkdqorrl123!@");
////        } catch (Exception e) {
////        }
////    }
////
////    public void disConnection() {    //연결해제
////        try {
////            if (ps != null) ps.close();
////            if (conn != null) conn.close();
////        } catch (Exception e) {
////        }
////    }
////
////    public ArrayList<userVO> userAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
////        ArrayList<userVO> list = new ArrayList<>();
////        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        UserDetails userDetails = (UserDetails) principaluser;
////        String idUser = userDetails.getUsername();
////
////        try {
////            getConnection();    //오라클 연결
////            String sql = ("select * from survey" +
////                    "    where userid = (select userid from site_user where userid=?)");
////
////            ps = conn.prepareStatement(sql.toString());
////            ps.setString(1, idUser);
////
////
//////            ps = conn.prepareStatement(sql);  //쿼리 실행
////            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장
////
////            while (rs.next()) {
////                if (rs.getRow() == 5) {
////                    break;
////                }
////                userVO va = new userVO();
////                va.setId(rs.getString(1));
////                va.setUSERID(rs.getString(2));
////                va.setUSER_EMAIL(rs.getString(3));
////                va.setUSER_NAME(rs.getString(4));
////                va.setUSER_GENDER(rs.getString(5));
////
////                list.add(va); //list에 삽입
////            }
////            rs.close();
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////        } finally {
////            disConnection();    //종료
////        }
////        return list;
////    }
////}
//
//
//
//package RoutePlanner.core.controller.dao;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//@Component
//public class userDao {
//    private Connection conn;
//    private PreparedStatement ps;
//    private final String URL = "jdbc:oracle:thin:@routeplanner_high?TNS_ADMIN=/Users/ingi/wallet/wallet";
//
//    {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void getConnection() {    //DriverManager를 이용하여 url에 해당하는 디비에 로그인
//        try {
//            conn = DriverManager.getConnection(URL, "admin", "Rkdqorrl123!@");
//        } catch (Exception e) {
//        }
//    }
//
//    public void disConnection() {    //연결해제
//        try {
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public ArrayList<userVO> userAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
//        ArrayList<userVO> list = new ArrayList<>();
//        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserDetails userDetails = (UserDetails) principaluser;
//        String idUser = userDetails.getUsername();
//
//        try {
//            getConnection();    //오라클 연결
//            String sql = ("select * from survey" +
//                    "    where userid = (select userid from site_user where userid=?)");
//
//            ps = conn.prepareStatement(sql.toString());
//            ps.setString(1, idUser);
//
//
////            ps = conn.prepareStatement(sql);  //쿼리 실행
//            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장
//
//            while (rs.next()) {
//                if (rs.getRow() == 5) {
//                    break;
//                }
//                userVO va = new userVO();
//                va.setId(rs.getString(1));
//                va.setUSERID(rs.getString(2));
//                va.setUSER_EMAIL(rs.getString(3));
//                va.setUSER_NAME(rs.getString(4));
//                va.setUSER_GENDER(rs.getString(5));
//
//                list.add(va); //list에 삽입
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            disConnection();    //종료
//        }
//        return list;
//    }
//}




//package RoutePlanner.core.controller.dao;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//@Component
//public class userDao {
//    private Connection conn;
//    private PreparedStatement ps;
//    private final String URL = "jdbc:oracle:thin:@routeplanner_high?TNS_ADMIN=/Users/ingi/wallet/wallet";
//
//    {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void getConnection() {    //DriverManager를 이용하여 url에 해당하는 디비에 로그인
//        try {
//            conn = DriverManager.getConnection(URL, "admin", "Rkdqorrl123!@");
//        } catch (Exception e) {
//        }
//    }
//
//    public void disConnection() {    //연결해제
//        try {
//            if (ps != null) ps.close();
//            if (conn != null) conn.close();
//        } catch (Exception e) {
//        }
//    }
//
//    public ArrayList<userVO> userAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
//        ArrayList<userVO> list = new ArrayList<>();
//        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserDetails userDetails = (UserDetails) principaluser;
//        String idUser = userDetails.getUsername();
//
//        try {
//            getConnection();    //오라클 연결
//            String sql = ("select * from survey" +
//                    "    where userid = (select userid from site_user where userid=?)");
//
//            ps = conn.prepareStatement(sql.toString());
//            ps.setString(1, idUser);
//
//
////            ps = conn.prepareStatement(sql);  //쿼리 실행
//            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장
//
//            while (rs.next()) {
//                if (rs.getRow() == 5) {
//                    break;
//                }
//                userVO va = new userVO();
//                va.setId(rs.getString(1));
//                va.setUSERID(rs.getString(2));
//                va.setUSER_EMAIL(rs.getString(3));
//                va.setUSER_NAME(rs.getString(4));
//                va.setUSER_GENDER(rs.getString(5));
//
//                list.add(va); //list에 삽입
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            disConnection();    //종료
//        }
//        return list;
//    }
//}



package RoutePlanner.core.controller.dao;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class userDao {
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

    public ArrayList<surveyVO> surveyAllData() {    // 값을 저장한 VO들을 저장할 ArrayList
        ArrayList<surveyVO> list = new ArrayList<>();
        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principaluser;
        String idUser = userDetails.getUsername();

        try {
            getConnection();    //오라클 연결
            String sql = ("select * from survey" +
                    "    where userid = (select userid from site_user where userid=?)");

            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, idUser);


//            ps = conn.prepareStatement(sql);  //쿼리 실행
            ResultSet rs = ps.executeQuery();   //ResultSet객체로 결과 저장

            while (rs.next()) {
                if (rs.getRow() == 5) {
                    break;
                }
                surveyVO va = new surveyVO();
                va.setID(rs.getString(1));
                va.setUserID(rs.getString(2));
                va.setUserWhere(rs.getString(3));
                va.setUserWhat(rs.getString(4));
                va.setUserWho(rs.getString(5));

                list.add(va); //list에 삽입
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
