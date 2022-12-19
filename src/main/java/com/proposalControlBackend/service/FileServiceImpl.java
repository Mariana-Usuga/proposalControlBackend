/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proposalControlBackend.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
    
    private final Path rootFolder = Paths.get("uploads");
    
    @Override
	public javax.annotation.Resource load(String name) throws Exception {
		Path file = rootFolder.resolve(name);
		Resource resource = new UrlResource(file.toUri());
		return (javax.annotation.Resource) resource;
	}


	@Override
	public void save(List<MultipartFile> files) throws Exception {
		for (MultipartFile file : files) {
			this.save((List<MultipartFile>) file);
		}
	}

	@Override
	public Stream<Path> loadAll() throws Exception {
		return Files.walk(rootFolder, 1).filter(path -> !path.equals(rootFolder)).map(rootFolder::relativize);
	}

    @Override
    public void save(MultipartFile file) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
