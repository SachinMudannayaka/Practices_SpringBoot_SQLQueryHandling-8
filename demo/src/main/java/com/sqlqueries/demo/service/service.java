package com.sqlqueries.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqlqueries.demo.dto.Dto;
import com.sqlqueries.demo.entity.User;
import com.sqlqueries.demo.repository.Repo;

@Service
public class service {
    @Autowired
    private Repo repo;
 
    @Autowired
    private ModelMapper modelMapper;

public Dto postUser(Dto dto){
repo.save(modelMapper.map(dto, User.class));
return dto;
}

public List<Dto> getUser(){
    List<User>allUser=repo.findAll();
    return modelMapper.map(allUser,new TypeToken<List<Dto>>(){}.getType());
}

public Dto editUser(Dto dto){
    repo.save(modelMapper.map(dto, User.class));
    return dto;
}

public Boolean deleteUser(Dto dto){
    repo.delete(modelMapper.map(dto,User.class));
    return true;

}

public Dto getUserByUserId(String userId){
  User user=  repo.getUserByUserId(userId);
  return modelMapper.map(user ,Dto.class);

}
}
