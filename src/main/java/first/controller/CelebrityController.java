package first.controller;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import first.dto.CelebrityDto;
import first.dto.MemberDto;
import first.service.CelebrityService;
import jakarta.servlet.http.HttpServletResponse;


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
	

	
	@RequestMapping("/openFanWrite.do")
	public ModelAndView openFanWrite(@RequestParam int celebrityIdx) throws Exception {		
		ModelAndView mv = new ModelAndView("/first/fanWrite");
	
		mv.addObject("celebrityIdx", Integer.toString(celebrityIdx));
		
		return mv;
	}

	
	@GetMapping("/openFanDetail.do")	
	public ModelAndView openFanDetail(@RequestParam int fanIdx) throws Exception {	
		ModelAndView mv = new ModelAndView("/first/fanDetail");
	
		CelebrityDto fanDto = celebrityService.selectFanDetail(fanIdx);
		mv.addObject("fan", fanDto);
		
		
		return mv;
	}
	
	@GetMapping("/openFanList.do")
	public ModelAndView openFanList(@RequestParam int celebrityIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/first/fanList");
		
		CelebrityDto celebrityDto = celebrityService.selectOneCelebrityByCelebrityIdx(celebrityIdx);
		mv.addObject("celebrityDto",celebrityDto);	
		
		List<CelebrityDto> list = celebrityService.selectFanboardList(celebrityIdx);
		mv.addObject("list", list);
		
		CelebrityDto celebName = celebrityService.selectCelebrityName(celebrityIdx);
		mv.addObject("celebName", celebName);		
		
		
		return mv;
	}
	
	@PostMapping("/updateFan.do")
	public String updateFan(CelebrityDto fanDto) throws Exception {
		celebrityService.updateFan(fanDto);
		return "redirect:/openFanList.do?celebrityIdx=" + fanDto.getCelebrityIdx();
	}
	
	@PostMapping("/deleteFan.do")
	public String deleteFan(CelebrityDto fanDto) throws Exception {
		celebrityService.deleteFan(fanDto.getFanIdx());
		return "redirect:/openFanList.do?celebrityIdx=" + fanDto.getCelebrityIdx();
	}
	
	@PostMapping("/insertFan.do")
	public String insertFan(@RequestParam("imageFile") MultipartFile file, CelebrityDto fanDto, int celebrityIdx) throws Exception {
				
		// TODO. file 객체의 내용을 지정된 디렉터리에 저장 후 해당 정보를 DB에 저장
		celebrityService.insertFan(fanDto, file);
		
		return "redirect:openFanList.do?celebrityIdx=" + fanDto.getCelebrityIdx();
	}	
	
	@GetMapping("/download.do")
	public void downloadFile(@RequestParam int fanIdx, HttpServletResponse response) throws Exception {
		// topicId에 해당하는 기사 정보 조회
		CelebrityDto fanDto = celebrityService.selectOneFanByFanId(fanIdx);
				
		// 기사 정보에서 topicImage 정보를 추출
		String fanImage = fanDto.getFimage();
		
		// topicImage 정보에 해당하는 파일을 읽어서 response 객체를 통해서 클라이언트로 전달
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			response.setHeader("Content-Disposition", "inline;");
			
			byte[] buf = new byte[1024];
			fis = new FileInputStream(fanImage);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			int read;
			while((read = bis.read(buf, 0, 1024)) != -1) {
				bos.write(buf, 0, read);
			}
		} finally {
			bos.close();
			bis.close();
			fis.close();
		}
	}	



}
