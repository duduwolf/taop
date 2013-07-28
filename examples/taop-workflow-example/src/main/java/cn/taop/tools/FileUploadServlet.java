package cn.taop.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		log.debug("upload running......");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug(request.getPathInfo());
		log.debug("" + request.getAttribute("id"));
		
		try {
			String filePath = System.getProperty("user.home") + "/" + ".taop" + "/";
			request.setCharacterEncoding("UTF-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置临时内存缓冲区大小
			factory.setSizeThreshold(10240);
			//设置临时存放本地目录
			//factory.setRepository(new File(System.getProperty("user.home") + "/" + ".taop"));
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置单文件最大长度，当前设置为1GB
			upload.setFileSizeMax(1024 * 1024 * 1024);
			//设置一个request请求中可上传文件的最大长度，当前设置为10GB
			//upload.setSizeMax(1024 * 1024 * 1024 * 1024);
			List items = (List) upload.parseRequest(request);
			
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (item.isFormField()) {	//处理一并提交的非上传的表单域
					String name = item.getFieldName();
					String value = item.getString();
					log.debug("name = " + name);
					log.debug("value = " + value);
					log.warn("有表单域一并上传，未作处理！");
				} else {	//处理上传表单
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					
					log.debug("fieldName = " + fieldName);
					log.debug("fileName = " + fileName);
					log.debug("contentType = " + contentType);
					log.debug("isInMemory = " + isInMemory);
					log.debug("sizeInBytes = " + sizeInBytes);
					log.debug("br");
					
					File uploadFile = new File(filePath + fileName);
					item.write(uploadFile);
				}
			}
			log.debug("-------- final--------");
		} catch (Exception e) {
			log.error("", e.fillInStackTrace());
		}
	}
	
	public List getListInSession(HttpServletRequest request) {
		List result = (List) request.getSession().getAttribute("_result");
		if (result == null) {
			result = new ArrayList();
			request.getSession().setAttribute("_result", result);
		}
		return result;

	}

	static final Logger log = LoggerFactory.getLogger(FileUploadServlet.class);
}
