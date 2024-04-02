package com.projetowebspring.course.repositories;

import com.projetowebspring.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Long> {

}
