package com.netapp.ads.controllers.discover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.hhcc.main.CIFSSessionCollector;
import com.netapp.ads.hhcc.utils.ADSRestUtils;

@RestController
@RequestMapping(value = "/api")
public class ConnectionsController {

	private static final Logger log = LoggerFactory.getLogger(ConnectionsController.class);

	@Autowired
	CIFSSessionCollector c;
	
	@RequestMapping(value = "/cifsSession", method = RequestMethod.POST)
	public ResponseEntity<?> cifsSession() {
		c.collectCFSSessions();
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "CIFS Session"), HttpStatus.OK);
	}

	@RequestMapping(value = "/nfsDataCollector", method = RequestMethod.POST)
	public ResponseEntity<?> nfsDataCollector() {
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "NFS Data Collector"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/showMount", method = RequestMethod.POST)
	public ResponseEntity<?> showMount() {
		return new ResponseEntity(TalendConstants.STR_JOB_SUBMITTED.replaceFirst("PLACEHOLDER", "Show Mount"), HttpStatus.OK);
	}
	
}