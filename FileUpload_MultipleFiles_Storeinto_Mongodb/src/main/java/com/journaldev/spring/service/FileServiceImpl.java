package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.spring.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository filerepository;
	public void storefile(byte[] bytes) {
		
		filerepository.storefile(bytes);
	}

}
