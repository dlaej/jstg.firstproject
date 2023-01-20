package first.service;



import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import first.dto.CelebrityDto;
import first.dto.MemberDto;
import first.mapper.CelebrityMapper;

@Service
public class CelebrityServiceImpl implements CelebrityService {
	
	@Value("${application.upload-path}")
	private String uploadPath;

	
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
	public void insertFan(CelebrityDto fanDto,  MultipartFile file) throws Exception {
		String savedFilePath = saveFile(file);
		fanDto.setFimage(savedFilePath);
		
		celebrityMapper.insertFan(fanDto);
		
	}

	@Override
	public void updatefHitCount(int fanIdx) throws Exception {
		celebrityMapper.updatefHitCount(fanIdx);
		
	}

	@Override
	public CelebrityDto selectFanDetail(int fanIdx) throws Exception {
		celebrityMapper.updatefHitCount(fanIdx);
		return celebrityMapper.selectFanDetail(fanIdx);
	}

	@Override
	public void updateFan(CelebrityDto fanDto) throws Exception {
		celebrityMapper.updateFan(fanDto);
		
	}

	@Override
	public void deleteFan(int fanIdx) throws Exception {
		celebrityMapper.deleteFan(fanIdx);
				
	}

	@Override
	public String saveFile(MultipartFile file) throws Exception {
		String savedFilePath = uploadPath + file.getOriginalFilename();		
		
		File uploadFile = new File(savedFilePath);
		file.transferTo(uploadFile);
		
		return savedFilePath;

	}

	@Override
	public CelebrityDto selectOneFanByFanId(int fanIdx) throws Exception {
		return celebrityMapper.selectOneFanByFanId(fanIdx);
	}

	

}
