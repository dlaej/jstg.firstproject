package first.service;

import java.util.List;

import first.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> selectNoticeList() throws Exception;
	public void insertNotice(BoardDto noticeDto) throws Exception;
	void updatenHitCount(int noticeIdx) throws Exception;
	public BoardDto selectNoticeDetail(int noticeIdx) throws Exception;
	void updateNotice(BoardDto noticeDto) throws Exception;
	void deleteNotice(int noticeIdx) throws Exception;
	
	public List<BoardDto> selectQnaList() throws Exception;
	public void insertQna(BoardDto qnaDto) throws Exception;
	void updateqHitCount(int qnaIdx) throws Exception;
	public BoardDto selectQnaDetail(int qnaIdx) throws Exception;
	void updateQna(BoardDto qnaDto) throws Exception;
	void deleteQna(int qnaIdx) throws Exception;
	
    


}
