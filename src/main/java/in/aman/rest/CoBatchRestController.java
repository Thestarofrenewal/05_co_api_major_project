package in.aman.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.aman.service.CoService;

@RestController
public class CoBatchRestController {

	@Autowired
	private CoService coService;
	
	@GetMapping("/notices")
	public String processNotices() {
		coService.processPendingTriggers();
		return "success";
	}
	
}
