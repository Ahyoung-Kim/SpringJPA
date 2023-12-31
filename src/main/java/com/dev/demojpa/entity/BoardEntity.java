package com.dev.demojpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 얘만 쓰면 테이블 이름이 base_entity 로 됨
@Table(name = "board") // 얘도 쓰면 board 로
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_name")
    private String name;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "boardEntity"
    )
    private List<PostEntity> postEntityList = new ArrayList<>();

    public BoardEntity() {

    }

    public BoardEntity(Long id, String name, List<PostEntity> postEntityList) {
        this.id = id;
        this.name = name;
        this.postEntityList = postEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(List<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postEntityList=" + postEntityList +
                '}';
    }
}
