package com.project.HealthyCare.common.base;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.HealthyCare.common.constant.MessageCode;


public abstract class BaseServiceImpl<E, R extends BaseRepository<E>> implements BaseService<E> {

	private final R repository;

	private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	public BaseServiceImpl(R repository) {
		this.repository = repository;
	}

	@Override
	public ServiceResponse<E> save(E entity) {
		try {
			E obj = repository.save(entity);
//			log.info("Saved " + obj.getClass().getName() + ". ID = " + obj.getId());
			return new ServiceResponse<E>(MessageCode.SUCCESS, obj);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return new ServiceResponse<E>(MessageCode.FAILED, null);
		}

	}

	@Override
	public ServiceResponse<List<E>> saveAll(List<E> entities) {
		try {
			List<E> obj = repository.saveAll(entities);
			log.info("Saved list " + obj.getClass().getName());
			return new ServiceResponse<List<E>>(MessageCode.SUCCESS, obj);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return new ServiceResponse<List<E>>(MessageCode.FAILED, null);
		}

	}

	@Override
	public ServiceResponse<E> update(E entity) {
		E obj = repository.save(entity);
		if (obj != null) {
			return new ServiceResponse<E>(MessageCode.SUCCESS, obj);
		}
		return new ServiceResponse<E>(MessageCode.FAILED, null);
	}

	@Override
	public ServiceResponse<E> get(Long id) {
		try {
			E obj = repository.findById(id).get();
			return new ServiceResponse<E>(MessageCode.SUCCESS, obj);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return new ServiceResponse<E>(MessageCode.FAILED, null);
		}
	}

	@Override
	public ServiceResponse<Page<E>> getPaging(Pageable pageable) {
		Page<E> obj = repository.findAll(pageable);
		if (obj != null) {
			return new ServiceResponse<Page<E>>(MessageCode.SUCCESS, obj);
		}
		return new ServiceResponse<Page<E>>(MessageCode.FAILED, null);
	}

	@Override
	public ServiceResponse<List<E>> getAll() {
		List<E> obj = repository.findAll();
		if (obj != null) {
			log.info("Fetch list successfully");
			return new ServiceResponse<List<E>>(MessageCode.SUCCESS, obj);
		}
		log.error("Can not fetch list ");
		return new ServiceResponse<List<E>>(MessageCode.FAILED, null);
	}

	@Override
	public ServiceResponse<Boolean> deleteById(Long id) {

		E obj = repository.findById(id).get();

		if (obj != null) {
			repository.delete(obj);
			log.info("Deleted " + obj.getClass().getName() + " with id = " + id);
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS, true);
		} else {
			log.error("Not found");
			return new ServiceResponse<Boolean>(MessageCode.FAILED, false);
		}

	}

	@Override
	public ServiceResponse<Boolean> deleteAll() {
		try {
			repository.deleteAll();
			log.info("Delete all success");
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS, true);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return new ServiceResponse<Boolean>(MessageCode.FAILED, false);
		}

	}
	
	@Override
	public ServiceResponse<Boolean> deleteAllBatch(Long[] ids) {
		try {
			List<E> objList = new ArrayList<>();
			for (int i = 0; i < ids.length; i++) {
				objList.add(repository.findById(ids[i]).get());
			}
			repository.deleteInBatch(objList);
			log.info("Delete all success");
			return new ServiceResponse<Boolean>(MessageCode.SUCCESS, true);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return new ServiceResponse<Boolean>(MessageCode.FAILED, false);
		}

	}
}
