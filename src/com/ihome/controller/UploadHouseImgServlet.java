package com.ihome.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ihome.entity.House;
import com.ihome.entity.User;
import com.ihome.service.AddHouseService;
import com.ihome.service.UserService;
import com.ihome.service.impl.AddHouseServiceImpl;
import com.ihome.service.impl.UserServiceImpl;

/*
 * 上传房间 图片
 */
@WebServlet("/UploadHouseImgServlet")
public class UploadHouseImgServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = "download";

	// 上传配置
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * 上传数据及保存文件
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 假装自己有用户
		User existUser = (User) request.getSession().getAttribute("existUser");

		// 获取到刚刚添加房源的ID
		House realHouse = null;
		AddHouseService houseService = new AddHouseServiceImpl();
		List<House> housesList = null;
		try {
			housesList = houseService.findHouseIdByUserId(existUser);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		int size = housesList.size();
		realHouse = housesList.get(size - 1);

		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是则停止
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return;
		}

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		factory.setRepository(new File("download"));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// 中文处理
		upload.setHeaderEncoding("UTF-8");

		// 构造临时路径来存储上传的文件
		// 这个路径相对当前应用的目录
		String uploadPath = request.getServletContext().getRealPath(".") + File.separator + UPLOAD_DIRECTORY;

		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// 解析请求的内容提取文件数据
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						// 在控制台输出文件的上传路径
						System.out.println(filePath);
						// 保存文件到硬盘
						item.write(storeFile);
						request.setAttribute("message", "文件上传成功!");

						InputStream is = null;
						OutputStream os = null;
						String srcString = "upload/home" + realHouse.getId() + ".jpg";
						try {
							is = new FileInputStream(filePath);

							os = new FileOutputStream(
									"D:\\workplace\\java\\xiangmu\\ihome\\WebContent\\upload\\home" + realHouse.getId() + ".jpg");
							// 3.操作：分段读取并写出
							int len; // 接收长度
							byte[] flush = new byte[1024]; // 缓冲容器，一次读写1k
							while ((len = is.read(flush)) != -1) {
								os.write(flush, 0, len);
							}
							os.flush(); // 写完手动刷新，避免数据在缓冲容器中（当然当流关闭时会自动刷新）
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							// 4.关闭流，分别关闭，先打开的后关闭
							try {
								if (os != null) { // 判断是否为空，避免空指针异常
									os.close();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							try {
								if (is != null) { // 判断是否为空，避免空指针异常
									is.close();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						// 创建Dao存储
						realHouse.setIndexImageUrl(srcString);
						houseService.setHouseImg(realHouse, srcString);

					}
				}
			}
		} catch (Exception ex) {
			request.setAttribute("message", "错误信息: " + ex.getMessage());
		}
		// 跳转到 message.jsp
		response.sendRedirect("my.jsp");
	}

}
