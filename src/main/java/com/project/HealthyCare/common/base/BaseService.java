package com.project.HealthyCare.common.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BaseService<E> {

	ServiceResponse<E> save(E entity);

	ServiceResponse<List<E>> saveAll(List<E> entities);

	ServiceResponse<E> update(E entity);

	ServiceResponse<E> get(Long id);

	ServiceResponse<Page<E>> getPaging(Pageable pageable);
    
	ServiceResponse<List<E>> getAll();

	ServiceResponse<Boolean> deleteById(Long id);

	ServiceResponse<Boolean> deleteAll();
	
	ServiceResponse<Boolean> deleteAllBatch(Long[] entityIds);
}
