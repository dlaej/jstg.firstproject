package first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first.dto.BoardDto;
import first.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectNoticeList() throws Exception {
		return boardMapper.selectNoticeList();
	}

	@Override
	public void insertNotice(BoardDto noticeDto) throws Exception {
		boardMapper.insertNotice(noticeDto);	
	}
	
	@Override
	public void updatenHitCount(int noticeIdx) throws Exception {
		boardMapper.updatenHitCount(noticeIdx);
		
	}

	@Override
	public BoardDto selectNoticeDetail(int noticeIdx) throws Exception {
		boardMapper.updatenHitCount(noticeIdx);			
		return boardMapper.selectNoticeDetail(noticeIdx);
	}

	@Override
	public List<BoardDto> selectQnaList() throws Exception {
		return boardMapper.selectQnaList();
	}

	@Override
	public void insertQna(BoardDto qnaDto) throws Exception {
		boardMapper.insertQna(qnaDto);
				
	}

	@Override
	public void updateqHitCount(int qnaIdx) throws Exception {
		boardMapper.updateqHitCount(qnaIdx);
		
	}

	@Override
	public BoardDto selectQnaDetail(int qnaIdx) throws Exception {
		boardMapper.updateqHitCount(qnaIdx);
		return boardMapper.selectQnaDetail(qnaIdx);
	}

	@Override
	public void updateNotice(BoardDto noticeDto) throws Exception {
		boardMapper.updateNotice(noticeDto);
		
	}

	@Override
	public void deleteNotice(int noticeIdx) throws Exception {
		boardMapper.deleteNotice(noticeIdx);
		
	}

	@Override
	public void updateQna(BoardDto qnaDto) throws Exception {
		boardMapper.updateQna(qnaDto);
		
	}

	@Override
	public void deleteQna(int qnaIdx) throws Exception {
		boardMapper.deleteQna(qnaIdx);
		
	}
	


	

}
