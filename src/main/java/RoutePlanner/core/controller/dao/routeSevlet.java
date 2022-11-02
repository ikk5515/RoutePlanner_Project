package RoutePlanner.core.controller.dao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.ServletConfig;

public class routeSevlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=EUC-KR");
        PrintWriter out=res.getWriter();
        // 데이터 읽기
        routeDAO dao = new routeDAO();
        ArrayList<routeVO> list = dao.routeAllData();
        // out = s.getOutputStream()
        // 브라우저에서 메모리에 출력된 HTML을 읽어 간다
        out.println("<html>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Data Info</h1>");
        out.println("<table width=1200 border=1 bodercolor=black>");
        out.println("<tr>");
        out.println("<th>playNo</th>");
        out.println("<th>playKind</th>");
        out.println("<th>playWhat</th>");
        out.println("<th>playName</th>");
        out.println("<th>playAddr</th>");
        out.println("<th>playGroup</th>");
        out.println("</tr>");
        // for
        for(routeVO vo : list)
        {
            out.println("<tr>");
            out.println("<td>" +vo.getPlayno()+"</td>");
            out.println("<td>"+vo.getPlaykind()+"</td>");
            out.println("<td>" +vo.getPlaywhat()+"</td>");
            out.println("<td>" +vo.getPlayname()+"</td>");
            out.println("<td>" +vo.getPlayaddr()+"</td>");
            out.println("<td>" +vo.getPlaygroup()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
