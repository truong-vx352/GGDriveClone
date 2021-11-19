package com.project.GGDriveClone.service;

import com.project.GGDriveClone.entity.FileEntity;
import com.project.GGDriveClone.entity.UserEntity;
import com.project.GGDriveClone.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public FileEntity addFile(Long size, String name, String type, String path){
        FileEntity fileEntity = new FileEntity(size, name, type, path);
        fileEntity.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        fileEntity.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
        return fileEntity;
    }

    public FileEntity findFile(long id){
        return fileRepository.findFileEntityById(id);
    }

    public List<FileEntity> findAllByUser(UserEntity userEntity) { return fileRepository.findFileEntitiesByUserEntitiesIs(userEntity);}

}
