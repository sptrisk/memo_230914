package com.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component  // spring bean
public class FileManagerService {

	// 실제 업로드 된 이미지가 저장될 경로(서버)
	public static final String FILE_UPLOAD_PATH = "D:\\kimjonghwi\\6_spring_project\\MEMO\\memo_workspace\\images/";
	
	
	// input : file 원본, userLoginId(폴더명)   output : 이미지 경로
	public String saveFile(String loginId, MultipartFile file) {
		// 폴더(디렉토리) 생성
		// 예 : aaaa_123123123/sun.png
		String directoryName = loginId + "_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName; // D:\\kimjonghwi\\6_spring_project\\MEMO\\memo_workspace\\images/aaaa_123123123
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 생성 실패 시 이미지 경로 null 리턴
			return null;
		}
		
		// 파일 업로드 : byte 단위로 업로드
		try {
			byte[] bytes = file.getBytes();
			// ★★★★★ 한글 이름 이미지는 올릴 수 없으므로 나중에 영문자로 바꿔서 올리기 
			Path path = Paths.get(filePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes); // 실제 파일 업로드
			
		} catch (IOException e) {
			e.printStackTrace();
			return null; // 이미지 업로드 실패시 return null
		}
		
		// 파일 업로드가 성공했으면 웹 이미지 url path를 리ㅣ턴
		// 주소는 이렇게 될 것이다.
		// images/aaaa_123123123/sun.png
		return null;
	}
	
	
	
}
