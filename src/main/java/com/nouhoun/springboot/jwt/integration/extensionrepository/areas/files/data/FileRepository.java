package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.models.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
