package first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import first.dto.BoardDto;
import first.dto.CelebrityDto;
import first.dto.MemberDto;

@Mapper
public interface CelebrityMapper {
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
	void insertFan(CelebrityDto fanDto) throws Exception;
	void updatefHitCount(int fanIdx) throws Exception;
	CelebrityDto selectFanDetail(int fanIdx) throws Exception;
	void updateFan(CelebrityDto fanDto) throws Exception;
	void deleteFan(int fanIdx) throws Exception;
	CelebrityDto selectOneFanByFanId(int fanIdx) throws Exception;
	
	


}
