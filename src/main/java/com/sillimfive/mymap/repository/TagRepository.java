package com.sillimfive.mymap.repository;

import com.sillimfive.mymap.domain.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByIdIn(List<Long> ids);
}
