package com.sillimfive.mymap.web.dto.roadmap;

import com.sillimfive.mymap.domain.roadmap.RoadMap;
import com.sillimfive.mymap.web.dto.tag.TagDto;
import com.sillimfive.mymap.web.dto.user.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class RoadMapDetailResponseDto {
    @Schema(example = "1")
    private Long id;
    private List<RoadMapNodeResponseDto> roadMapNodes;
    private UserDto user;
    private UserDto creator;
    @Schema(example = "JPA")
    private String category;
    private List<TagDto> tags;
    @Schema(example = "JPA 기본편 완전정복")
    private String title;
    @Schema(example = "화이팅!!!")
    private String description;
    @Schema(example = "/home/mymap/roadmap/202310160133221")
    private String imageDownloadPath;

    public RoadMapDetailResponseDto(RoadMap roadMap) {
        this.id = roadMap.getId();
        this.roadMapNodes = roadMap.getRoadMapNodes().stream()
                                .map(RoadMapNodeResponseDto::new)
                                .collect(Collectors.toList());
        this.user = new UserDto(roadMap.getUser());
        this.creator = new UserDto(roadMap.getCreator());
        this.category = roadMap.getCategory().getName();
        this.title = roadMap.getTitle();
        this.description = roadMap.getDescription();
        this.imageDownloadPath = roadMap.getImage().getPath();
    }

    public void addTags(List<TagDto> tags) {
        this.tags = tags;
    }
}