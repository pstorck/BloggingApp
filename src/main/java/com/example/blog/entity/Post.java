package com.example.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "Title can not be empty.")
    private String title;
    @NotEmpty(message = "Author can not be empty.")
    private String author;
    @NotEmpty(message = "Content can not be empty.")
    @Lob
    private String content;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post() {
    }

    public Post(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}
