package first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import first.dto.BoardDto;
import first.dto.CelebrityDto;
import first.dto.MemberDto;
import first.service.CelebrityService;


@Controller
public class CelebrityController {
	
	@Autowired
	private CelebrityService celebrityService;
	
	@GetMapping("/openCelebrityIndex.do")
	public ModelAndView openIndex() throws Exception {
		ModelAndView mv = new ModelAndView("/first/celebrityIndex");
		
		List<CelebrityDto> celebrity = celebrityService.selectCelebrity();
		mv.addObject("celebrity", celebrity);
		
		return mv;
	}
	
	@GetMapping("/openCelebrityList.do")
	public ModelAndView openCelebrityList() throws Exception {
		ModelAndView mv = new ModelAndView("/first/celebrityList");
		
		List<CelebrityDto> celebrityList = celebrityService.selectCelebrityList();
		mv.addObject("celebrityList", celebrityList);
		
		List<CelebrityDto> type = celebrityService.selectType();
		mv.addObject("type", type);
		
		List<CelebrityDto> celebrity = celebrityService.selectCelebrity();
		mv.addObject("celebrity", celebrity);
			
		return mv;
	}
	
	@GetMapping("/openActorList.do")
	public ModelAndView openActorList() throws Exception {
		ModelAndView mv = new ModelAndView("/first/actorList");
				
		List<CelebrityDto> type = celebrityService.selectType();
		mv.addObject("type", type);
		
		List<CelebrityDto> actor = celebrityService.selectActor();
		mv.addObject("actor", actor);
			
		return mv;
	}
	
	@GetMapping("/openMember.do")
	public ModelAndView openMember(@RequestParam int celebrityIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/first/member");
		
		List<CelebrityDto> celebrity = celebrityService.selectCelebrity();
		mv.addObject("celebrity", celebrity);
				
		CelebrityDto celebrityDto = celebrityService.selectOneCelebrityByCelebrityIdx(celebrityIdx);
		mv.addObject("celebrityDto",celebrityDto);		
		
		List<MemberDto> one = celebrityService.selectMemberByCelebrityIdx(celebrityIdx);
		mv.addObject("one", one);		
		
		MemberDto memberDto = celebrityService.selectOneMemberByCelebrityIdx(celebrityIdx);
		mv.addObject("member", memberDto);	
		
		return mv;
	
	}
	
	@GetMapping("/getMember.do")
	public ModelAndView getMember(@RequestParam int memberIdx) throws Exception {				
		ModelAndView mv = new ModelAndView("/first/profile");		
		
		MemberDto memberDto = celebrityService.selectMember(memberIdx);
		mv.addObject("member", memberDto);
		
		return mv;
	}
	
	
	
//	@GetMapping("/openFanList.do")
//	public ModelAndView openFanList() throws Exception {
//		ModelAndView mv = new ModelAndView("/first/fanList");
//		
//		List<BoardDto> list = boardService.selectFanList();
//		mv.addObject("list", list);
//		
//		return mv;
//	}
	
	@RequestMapping("/openFanWrite.do")
	public String openFanWrite() throws Exception {
		return "/first/fanWrite";
	}
	
	// 글 저장 처리에 대한 요청을 처리
	@RequestMapping("/insertFan.do")
	public String insertFan(CelebrityDto fanDto) throws Exception {
		celebrityService.insertFan(fanDto);
		return "redirect:/openFanList.do";
	}
	
	@GetMapping("/openFanDetail.do")	
	public ModelAndView openFanDetail(@RequestParam int fanIdx) throws Exception {	
		ModelAndView mv = new ModelAndView("/first/fanDetail");
	
		CelebrityDto fanDto = celebrityService.selectFanDetail(fanIdx);
		mv.addObject("fan", fanDto);
		
		return mv;
	}
	
	@GetMapping("/openFan.do")
	public ModelAndView openFanList(int celebrityIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/first/fanList");
		
		List<CelebrityDto> list = celebrityService.selectFanboardList(celebrityIdx);
		mv.addObject("list", list);
		
		CelebrityDto celebName = celebrityService.selectCelebrityName(celebrityIdx);
		mv.addObject("celebName", celebName);		
		
		
		return mv;
	}

}
