package com.dev.demojpa.service;

import com.dev.demojpa.dao.PostDao;
import com.dev.demojpa.dto.PostDto;
import com.dev.demojpa.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;

    public PostService(
            @Autowired PostDao postDao
     ) {
        this.postDao = postDao;
    }

    public void createPost(PostDto dto) {
        this.postDao.createPost(dto);
    }

    public PostDto readPost(int id) {
        PostEntity postEntity = this.postDao.readPost(id);
        // entity -> dto 로 변환
        PostDto postDto = new PostDto(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ?
                        0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
        return postDto;
    }

    public List<PostDto> readPostAll() {
        Iterator<PostEntity> postEntityIterator = this.postDao.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();

        while(postEntityIterator.hasNext()) {
            PostEntity postEntity = postEntityIterator.next();
            postDtoList.add(new PostDto(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null ?
                            0 : Math.toIntExact(postEntity.getBoardEntity().getId())
            ));
        }

        return postDtoList;
    }

    public void updatePost(int id, PostDto dto) {
        this.postDao.updatePost(id, dto);
    }

    public void deletePost(int id) {
        this.postDao.deletePost(id);
    }
}
