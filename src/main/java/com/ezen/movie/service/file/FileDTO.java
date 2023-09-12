package com.ezen.movie.service.file;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;


@Alias("fileDTO")
public class FileDTO extends CommDTO {
	
	private String fileIdx;		//파일IDX
	private int tableIdx;	//테이블IDX
	private String filePath;	//파일패스
	private String fileName;	//파일이름
	private String tableGb;		//테이블구분
	public String getFileIdx() {
		return fileIdx;
	}
	public int getTableIdx() {
		return tableIdx;
	}
	public void setTableIdx(int tableIdx) {
		this.tableIdx = tableIdx;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTableGb() {
		return tableGb;
	}
	public void setTableGb(String tableGb) {
		this.tableGb = tableGb;
	}
	public void setFileIdx(String fileIdx) {
		this.fileIdx = fileIdx;
	}
	
	
}
