package in.aman.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.aman.entity.CoNoticeEntity;
import in.aman.entity.EligEntity;
import in.aman.repo.CoNoticeRepo;
import in.aman.repo.EligRepo;
import in.aman.utils.EmialUtils;

@Service
public class CoServiceImpl implements CoService {

	@Autowired
	private CoNoticeRepo coNoticeRepo;

	@Autowired
	private EligRepo eligRepo;
	
	@Autowired
	private EmialUtils emialUtils;

	@Override
	public void processPendingTriggers() {

		List<CoNoticeEntity> records = coNoticeRepo.findByNoticeStatus("P");

		for (CoNoticeEntity entity : records) {
			processEachRecord(entity);
		}
	}

	private void processEachRecord(CoNoticeEntity entity) {

		Long caseNum = entity.getCaseNum();

		EligEntity eligEntity = eligRepo.findByCaseNum(caseNum);
		String planStatus = eligEntity.getPlanStatus();

		File pdfFile = null;

		if ("AP".equals(planStatus)) {

			pdfFile = generateApprovedNotices(eligEntity);

		} else if ("DN".equals(planStatus)) {
			pdfFile = generateDeniedNotices(eligEntity);

		}

		String fileUrl = storeOdfInS3(pdfFile);

		boolean isUpdated = updateProcessRecord(entity, fileUrl);
		
		if(isUpdated) {
			emialUtils.sendEmail(fileUrl, planStatus, fileUrl, pdfFile); 
		}
	}

	private boolean updateProcessRecord(CoNoticeEntity entity, String fileUrl) {
		
		entity.setNoticeStatus("H");
		entity.setNoticeUrl(fileUrl);
		
		coNoticeRepo.save(entity);
		
		return true;
	}

	private String storeOdfInS3(File pdfFile2) {

		return null;
	}

	private File generateDeniedNotices(EligEntity eligEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	private File generateApprovedNotices(EligEntity eligEntity) {
		// TODO Auto-generated method stub
		return null;

	}
}
