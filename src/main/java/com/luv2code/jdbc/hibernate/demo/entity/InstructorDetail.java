package com.luv2code.jdbc.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    public InstructorDetail() {

    }

    public InstructorDetail(String youtube_channel, String hobby) {
        this.youtubeChannel = youtube_channel;
        this.hobby = hobby;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" + "id=" + id + ", youtube_channel='" + youtubeChannel + '\'' + ", hobby='" + hobby
                + '\'' + '}';
    }
}
