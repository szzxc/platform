package com.zhouxc.base.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/3/26.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                       @RequestParam(value = "upload", required = false) MultipartFile file) {
        try {
            String path = session.getServletContext().getRealPath("/");
            path += "upload" + File.separator + "images" + File.separator + file.getOriginalFilename().toLowerCase();
            File file1 = new File(path);
            file.transferTo(file1);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            // 将上传的图片的url返回给ckeditor
            //不能存d:\这种地址,要url

            String url = "http://" + request.getServerName() + ":" + request.getServerPort() +
                    request.getContextPath() + "/upload/images/" + file.getOriginalFilename().toLowerCase();
            String callback = request.getParameter("CKEditorFuncNum");
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                    + ",'" + url + "',''" + ")");
            printWriter.println("</script>");
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {

        }
    }
}
