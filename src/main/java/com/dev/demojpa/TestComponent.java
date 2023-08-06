package com.dev.demojpa;

import com.dev.demojpa.entity.BoardEntity;
import com.dev.demojpa.entity.PostEntity;
import com.dev.demojpa.repository.BoardRepository;
import com.dev.demojpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestComponent {
    public TestComponent(
            @Autowired BoardRepository boardRepository,
            @Autowired PostRepository postRepository
            ) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new board");

        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
        System.out.println(newBoardEntity.getName());

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("Hello ORM");
        postEntity.setContent("This Entity is created by hibernate!");
        postEntity.setWriter("Test user");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        List<PostEntity> postEntityList = postRepository.findAllByWriter("Test user");

        System.out.println(postEntityList.size());
    }
}
