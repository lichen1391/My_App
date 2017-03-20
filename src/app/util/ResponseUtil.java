package app.util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理 json 数据类
 * @author 李晨
 * @date 2017-02-26
 *
 */

public class ResponseUtil {
	public static void write(HttpServletResponse response,Object object)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(object);
		out.flush();
		out.close();
	}
}
