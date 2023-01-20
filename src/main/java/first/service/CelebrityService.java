package first.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import first.dto.CelebrityDto;
import first.dto.MemberDto;

public interface CelebrityService {
	List<CelebrityDto> selectCelebrityList() throws Exception;
	CelebrityDto selectOneCelebrityByCelebrityIdx(int celebrityIdx) throws Exception;
	List<CelebrityDto> selectCelebrity() throws Exception;
	List<CelebrityDto> selectType() throws Exception;	
	MemberDto selectMember(int memberIdx) throws Exception;
	List<MemberDto> selectMemberByCelebrityIdx(int celebrityIdx) throws Exception;
	MemberDto selectOneMemberByCelebrityIdx(int celebrityIdx) throws Exception;
	
	List<CelebrityDto> selectActor() throws Exception;
	
	public List<CelebrityDto> selectFanboardList(int celebrityIdx) throws Exception;	
	public CelebrityDto selectCelebrityName(int celebrityIdx) throws Exception;
	
	List<CelebrityDto> selectFanList() throws Exception;
	void insertFan(CelebrityDto fanDto,  MultipartFile file) throws Exception;
	void updatefHitCount(int fanIdx) throws Exception;
	CelebrityDto selectFanDetail(int fanIdx) throws Exception;
	void updateFan(CelebrityDto fanDto) throws Exception;
	void deleteFan(int fanIdx) throws Exception;
	String saveFile(MultipartFile file) throws Exception;
	CelebrityDto selectOneFanByFanId(int fanIdx) throws Exception;


}
