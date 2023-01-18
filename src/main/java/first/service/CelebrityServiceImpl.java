package first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first.dto.CelebrityDto;
import first.dto.MemberDto;
import first.mapper.CelebrityMapper;

@Service
public class CelebrityServiceImpl implements CelebrityService {
	
	@Autowired
	private CelebrityMapper celebrityMapper;

	@Override
	public List<CelebrityDto> selectCelebrityList() throws Exception {
		return celebrityMapper.selectCelebrityList();
	}

	@Override
	public CelebrityDto selectOneCelebrityByCelebrityIdx(int celebrityIdx) throws Exception {
		return celebrityMapper.selectOneCelebrityByCelebrityIdx(celebrityIdx);
	}
	

	@Override
	public List<CelebrityDto> selectCelebrity() throws Exception {
		
		return celebrityMapper.selectCelebrity();	}

	@Override
	public List<CelebrityDto> selectType() throws Exception {
		return celebrityMapper.selectType();
	}	

	@Override
	public MemberDto selectMember(int memberIdx) throws Exception {
		return celebrityMapper.selectMember(memberIdx);
	}

	@Override
	public List<MemberDto> selectMemberByCelebrityIdx(int celebrityIdx) throws Exception {
		return celebrityMapper.selectMemberByCelebrityIdx(celebrityIdx);
	}

	@Override
	public MemberDto selectOneMemberByCelebrityIdx(int celebrityIdx) throws Exception {
		return celebrityMapper.selectOneMemberByCelebrityIdx(celebrityIdx);
	}

	@Override
	public List<CelebrityDto> selectActor() throws Exception {
		return celebrityMapper.selectActor();
	}

	@Override
	public List<CelebrityDto> selectFanboardList(int celebrityIdx) throws Exception {
		return celebrityMapper.selectFanboardList(celebrityIdx);
	}

	@Override
	public CelebrityDto selectCelebrityName(int celebrityIdx) throws Exception {
		return celebrityMapper.selectCelebrityName(celebrityIdx);
	}

	@Override
	public List<CelebrityDto> selectFanList() throws Exception {
		return celebrityMapper.selectFanList();
	}

	@Override
	public void insertFan(CelebrityDto fanDto) throws Exception {
		celebrityMapper.insertFan(fanDto);
		
	}

	@Override
	public void updatefHitCount(int fanIdx) throws Exception {
		celebrityMapper.updatefHitCount(fanIdx);
		
	}

	@Override
	public CelebrityDto selectFanDetail(int fanIdx) throws Exception {
		return celebrityMapper.selectFanDetail(fanIdx);
	}

	

}
