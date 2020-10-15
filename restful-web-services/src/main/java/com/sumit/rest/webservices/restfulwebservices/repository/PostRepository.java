package com.sumit.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumit.rest.webservices.restfulwebservices.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

}
