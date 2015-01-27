package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoDownloadController {

   @RequestMapping(value = "/download.html", method = {RequestMethod.GET})
   @ResponseBody
   public ResponseEntity<byte[]> download(@RequestParam String filename,
         HttpServletResponse resp) throws IOException {
      // HTTP헤더
      HttpHeaders headers = new HttpHeaders();
      File serverFile = new File("c:/video/", filename);
      InputStream inputStream = null;
      try {
         inputStream = new FileInputStream(serverFile);
      } catch (FileNotFoundException e) {
         String msg = "그런파일없다";
         headers.setContentType(MediaType.TEXT_PLAIN);
         return new ResponseEntity<byte[]>(msg.getBytes(),
               HttpStatus.NOT_FOUND);
      }

      // resp.setContentType("video/mp4"); 크롬자체실행가능
      filename = URLEncoder.encode(filename, "utf8");
      resp.setContentType("application/octet-stream"); // 다운로드창이뜸
      resp.setHeader("Content-Disposition", "attachment;filename=\""
            + filename + "\"");

      // 다운로드
      Long fileSize = serverFile.length();
      resp.setContentLength(fileSize.intValue());

      // OutputStream 생성
      OutputStream outputStream = null;
      try {
         outputStream = resp.getOutputStream();
      } catch (IOException e) {
         String msg = "다운로드안댐";
         headers.setContentType(MediaType.TEXT_PLAIN);
         return new ResponseEntity<byte[]>(msg.getBytes(), HttpStatus.NOT_FOUND);
      }
      // 다운로드
      byte[] buffer = new byte[1024]; // 한번에 1mb씩받겠다?
      int read = 0;
      try {
         while ((read = inputStream.read(buffer)) != -1) {// 더이상 읽을게 없다.
            outputStream.write(buffer, 0, read); // 읽어들인 바이트수
         }
         // close해서 메모리 누수 방지
         outputStream.flush(); // 물내리는거?
         outputStream.close();
         inputStream.close();
      } catch (Exception e) {
         String msg = "다운로드안댐2";
         headers.setContentType(MediaType.TEXT_PLAIN);
         return new ResponseEntity<byte[]>(msg.getBytes(),
               HttpStatus.NOT_FOUND);
      }
      String ok = "정상종료";
      return new ResponseEntity<byte[]>(ok.getBytes(), HttpStatus.OK);
   }

}