package first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import first.dto.BoardDto;
import first.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/main.do")
	public ModelAndView main() throws Exception {
		ModelAndView mv = new ModelAndView("/first/main");		
		
		return mv;
	}
	
	@GetMapping("/index.do")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView("/first/index");		
		
		return mv;
	}
	
	@GetMapping("/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/first/about");		
		
		return mv;
	}
	@GetMapping("/history.do")
	public ModelAndView history() throws Exception {
		ModelAndView mv = new ModelAndView("/first/history");		
		
		return mv;
	}
	@GetMapping("/contact.do")
	public ModelAndView contact() throws Exception {
		ModelAndView mv = new ModelAndView("/first/contact");		
		
		return mv;
	}
	
	
	@GetMapping("/openNoticeList.do")
	public ModelAndView openNoticeList() throws Exception {
		ModelAndView mv = new ModelAndView("/first/noticeList");
		
		List<BoardDto> list = boardService.selectNoticeList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/openNoticeWrite.do")
	public String openNoticeWrite() throws Exception {
		return "/first/noticeWrite";
	}
	
	// 글 저장 처리에 대한 요청을 처리
	@RequestMapping("/insertNotice.do")
	public String insertNotice(BoardDto noticeDto) throws Exception {
		boardService.insertNotice(noticeDto);
		return "redirect:/openNoticeList.do";
	}
	
	@GetMapping("/openNoticeDetail.do")	
	public ModelAndView openNoticeDetail(@RequestParam int noticeIdx) throws Exception {	
		ModelAndView mv = new ModelAndView("/first/noticeDetail");
	
		BoardDto noticeDto = boardService.selectNoticeDetail(noticeIdx);
		mv.addObject("notice", noticeDto);
		
		return mv;
	}
	
	@PostMapping("/updateNotice.do")
	public String updateNotice(BoardDto noticeDto) throws Exception {
		boardService.updateNotice(noticeDto);
		return "redirect:/openNoticeList.do";
	}
	
	@PostMapping("/deleteNotice.do")
	public String deleteBoard(BoardDto noticeDto) throws Exception {
		boardService.deleteNotice(noticeDto.getNoticeIdx());
		return "redirect:/openNoticeList.do";
	}
	
	@GetMapping("/openQnaList.do")
	public ModelAndView openQnaList() throws Exception {
		ModelAndView mv = new ModelAndView("/first/qnaList");
		
		List<BoardDto> list = boardService.selectQnaList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/openQnaWrite.do")
	public String openQnaWrite() throws Exception {
		return "/first/qnaWrite";
	}
	
	// 글 저장 처리에 대한 요청을 처리
	@RequestMapping("/insertQna.do")
	public String insertQna(BoardDto qnaDto) throws Exception {
		boardService.insertQna(qnaDto);
		return "redirect:/openQnaList.do";
	}
	
	@GetMapping("/openQnaDetail.do")	
	public ModelAndView openQnaDetail(@RequestParam int qnaIdx) throws Exception {	
		ModelAndView mv = new ModelAndView("/first/qnaDetail");
	
		BoardDto qnaDto = boardService.selectQnaDetail(qnaIdx);
		mv.addObject("qna", qnaDto);
		
		return mv;
	}
	
	@PostMapping("/updateQna.do")
	public String updateQna(BoardDto qnaDto) throws Exception {
		boardService.updateQna(qnaDto);
		return "redirect:/openQnaList.do";
	}
	
	@PostMapping("/deleteQna.do")
	public String deleteQna(BoardDto qnaDto) throws Exception {
		boardService.deleteQna(qnaDto.getQnaIdx());
		return "redirect:/openQnaList.do";
	}





}
