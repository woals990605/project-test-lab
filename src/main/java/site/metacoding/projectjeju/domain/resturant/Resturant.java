package site.metacoding.projectjeju.domain.resturant;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Resturant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String thumUrl; // 썸네일
    @Column(length = 300, nullable = false, unique = true)
    private String name; // 가게 이름
    private String address; // 주소
    private String telDisplay; // 전화번호
    private String bizhourInfo; // 영업시간
    private String homePage; // 홈페이지
    private String menuInfo; // 메뉴
    private String x; // 위도
    private String y; // 경도
    private String category; // 한식;전복요리;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

}
