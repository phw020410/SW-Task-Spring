package com.prototype.demo.dao;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private Long idx;
    @Column(name = "name")
    private String username;
    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime createdAt;
    private String author;
    private String content;

    @Override
    public String toString() {
        return "Project{" +
                "idx=" + idx +
                ", username='" + username + '\'' +
                ", createdAt=" + createdAt +
                ", author='" + author + '\'' +
                ", context='" + content + '\'' +
                '}';
    }
}
