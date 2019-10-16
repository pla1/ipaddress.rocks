package ipaddress.rocks;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class Utils {
    public static String getHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder sb = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            String message = String.format("Header Name - %s Value - %s\n", headerName, request.getHeader(headerName));
            sb.append(message);
        }
        return sb.toString();
    }
}
