package site.metacoding.projectjeju.domain.comment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.projectjeju.domain.resturant.Resturant;
import site.metacoding.projectjeju.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "restId")
    @ManyToOne
    private Resturant resturant;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @Lob
    @Column(nullable = false)
    private String content;

    @CreatedDate
    private LocalDateTime createDate;
}
