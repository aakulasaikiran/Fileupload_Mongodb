package com.journaldev.spring.repository;

import java.io.File;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

@Repository
public class FileRepositoryImpl implements FileRepository {

	public void storefile(byte[] bytes) {
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB mongoDB = mongoClient.getDB("tutorial");
			DBCollection collection = mongoDB.getCollection("Files");

			//File file = new File("/Users/thomasjaspers/Downloads/mongodb-osx-x86_64-2-1.2.1.tgz");

			GridFS gridfs = new GridFS(mongoDB, "downloads");
			GridFSInputFile gfsFile = gridfs.createFile(bytes);
			gfsFile.setFilename("File3");
			gfsFile.save();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

	}
}