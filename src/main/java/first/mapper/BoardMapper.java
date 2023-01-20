package first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import first.dto.BoardDto;
import first.dto.CelebrityDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectNoticeList() throws Exception;
	void insertNotice(BoardDto noticeDto) throws Exception;
	void updatenHitCount(int noticeIdx) throws Exception;
	BoardDto selectNoticeDetail(int noticeIdx) throws Exception;
	void updateNotice(BoardDto noticeDto) throws Exception;
	void deleteNotice(int noticeIdx) throws Exception;
	
	List<BoardDto> selectQnaList() throws Exception;
	void insertQna(BoardDto qnaDto) throws Exception;
	void updateqHitCount(int qnaIdx) throws Exception;
	BoardDto selectQnaDetail(int qnaIdx) throws Exception;
	void updateQna(BoardDto qnaDto) throws Exception;
	void deleteQna(int qnaIdx) throws Exception;
	
	
	



}
