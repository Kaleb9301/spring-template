package com.bankofabyssinia.spring_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.bankofabyssinia.spring_template.entity.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<?>, ID> extends JpaRepository<T, ID> {
}
