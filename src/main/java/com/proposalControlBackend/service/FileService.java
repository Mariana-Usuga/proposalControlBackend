/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proposalControlBackend.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService{
    
    public void save(MultipartFile file) throws Exception;
	
	public Resource load(String name) throws Exception;
	
	public void save(List<MultipartFile> files) throws Exception;
	
	public Stream<Path> loadAll() throws Exception;
    
}
