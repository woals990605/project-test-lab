package site.metacoding.projectjeju.web.dto.download;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.projectjeju.domain.resturant.Resturant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResturantDto {

    private String thumUrl; // 썸네일
    private String name; // 가게 이름
    private String address; // 주소
    private String telDisplay; // 전화번호
    private String bizhourInfo; // 영업시간
    private String homePage; // 홈페이지
    private List<String> category; // 카테고리
    private String menuInfo; // 메뉴
    private String x; // 위도
    private String y; // 경도

    public Resturant toEntity() {
        Resturant resturant = new Resturant();
        resturant.setThumUrl(thumUrl);
        resturant.setName(name);
        resturant.setAddress(address);
        resturant.setTelDisplay(telDisplay);
        resturant.setBizhourInfo(bizhourInfo);
        resturant.setHomePage(homePage);
        resturant.setMenuInfo(menuInfo);
        resturant.setX(x);
        resturant.setY(y);

        String categoryGubun = "";
        for (String temp : category) {
            categoryGubun += temp + ";";
        }

        resturant.setCategory(categoryGubun);

        return resturant;
    }
}
