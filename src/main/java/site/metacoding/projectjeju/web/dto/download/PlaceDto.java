package site.metacoding.projectjeju.web.dto.download;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {
    private List<ResturantDto> list;
}
