package com.facesecure.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] faceEmbedding;
    
    @Column(name = "created_at")
    private Long createdAt;
    
    @Column(name = "updated_at")
    private Long updatedAt;
}