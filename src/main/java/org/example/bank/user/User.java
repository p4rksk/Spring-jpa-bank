package org.example.bank.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;

    @CreationTimestamp // pc -> db (날짜주입)
    private LocalDateTime createdAt;

    //실무에서 updateAt도 들어가는데 이것은 변경된 시간을 저장하는 필드로 사용된다 지금은 만들지 말자

    @Builder
    public User(Integer id, String username, String password, String fullname, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.createdAt = createdAt;
    }
}