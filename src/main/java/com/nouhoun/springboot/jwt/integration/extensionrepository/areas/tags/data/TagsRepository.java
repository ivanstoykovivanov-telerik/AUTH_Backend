package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.models.Tag;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Long> {
    Tag findTagByTagname(String tagname);
}
