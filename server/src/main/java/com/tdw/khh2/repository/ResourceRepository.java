package com.tdw.khh2.repository;

import com.tdw.khh2.entity.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResourceRepository extends PagingAndSortingRepository<Resource, String> {
}