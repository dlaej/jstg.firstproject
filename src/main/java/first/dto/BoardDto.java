package first.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int noticeIdx;
	private String ntitle;
	private String ncontents;
	private int nhitCnt;
	private String ncreatedDt;
	private String ncreatedId;
	private String nupdatedDt;
	private String nupdatedId;
	
	private int qnaIdx;
	private String qtitle;
	private String qcontents;
	private int qhitCnt;
	private String qcreatedDt;
	private String qcreatedId;
	private String qupdatedDt;
	private String qupdatedId;
	
	
	

}
