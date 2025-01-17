package com.sillimfive.mymap.web.dto.roadmap;

import com.sillimfive.mymap.domain.roadmap.RoadMap;
import com.sillimfive.mymap.web.dto.tag.TagDto;
import com.sillimfive.mymap.web.dto.user.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@ToString
public class RoadMapDetailResponseDto {
    @Schema(example = "1")
    private Long roadMapId;
    private List<RoadMapNodeResponseDto> roadMapNodes;
    private UserDto creator;
    private UserDto origin;
    private Long categoryId;
    @Schema(example = "JPA")
    private String categoryName;
    private List<TagDto> tags;
    @Schema(example = "JPA 기본편 완전정복")
    private String title;
    @Schema(example = "화이팅!!!")
    private String description;
    @Min(1) @Schema(example = "1")
    private Long imageId;
    @Schema(example = "https://aws-northeast-mymap.s3.ap-northeast-2.amazonaws.com/ROADMAPS/202310222336511")
    private String imageDownloadPath;
    @Schema(example = "DEFAULT")
    private String theme;

    public RoadMapDetailResponseDto(RoadMap roadMap) {
        this.roadMapId = roadMap.getId();
        this.roadMapNodes = roadMap.getRoadMapNodes().stream()
                                .map(RoadMapNodeResponseDto::new)
                                .collect(Collectors.toList());
        this.creator = new UserDto(roadMap.getCreator());
        this.origin = new UserDto(roadMap.getOrigin());
        this.categoryId = roadMap.getCategory().getId();
        this.categoryName = roadMap.getCategory().getName();
        this.title = roadMap.getTitle();
        this.description = roadMap.getDescription();
        this.imageId = roadMap.getImage().getId();
        this.imageDownloadPath = roadMap.getImage().getPath();
        this.theme = roadMap.getTheme().toString();
    }

    public void addTags(List<TagDto> tags) {
        this.tags = tags;
    }
}
