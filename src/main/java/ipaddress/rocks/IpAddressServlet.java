package ipaddress.rocks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class IpAddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        if (request.getHeader("accept") != null && request.getHeader("accept").contains("text/html")) {
            html(request, response);
        } else {
            plain(request, response);
        }
    }

    private void plain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.format("Plain %s\n", request.getRemoteAddr());
        PrintWriter pw = response.getWriter();
        pw.write(request.getRemoteAddr());
        pw.flush();
        pw.close();
    }

    private void html(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.format("HTML %s\n", request.getRemoteAddr());
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String ipAddress = request.getRemoteAddr();
        pw.write("<!DOCTYPE html>\n");
        pw.write("<html lang='en'>\n<head>\n<title>");
        pw.write(ipAddress);
        pw.write("</title>\n");
        pw.write("<meta name=\"Description\" content=\"Your IP address\">\n");
        pw.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF8\">\n");
        pw.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        pw.write("<style>\nh1\n{\nposition:absolute;\nmargin:0;\ntop:0;\nleft:0;\nfont-size:10vw;\nfont-family:Arial;\n}\n</style>\n");
        pw.write("</head>\n<body>\n<h1>");
        pw.write(ipAddress);
        pw.write("</h1>\n</body>\n</html>\n");
        pw.flush();
        pw.close();

    }
}
