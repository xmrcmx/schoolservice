package mrcm.royal.SchoolService.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import mrcm.royal.SchoolService.db.entity.AbstractEntity;


@Transactional
public abstract class AbstractService<T extends AbstractEntity> {

	protected abstract JpaRepository<T, Long> getRepository();
	

	public T save(T entity) {
		return getRepository().save(entity);
	}
	
	public List<T> saveAll(Iterable<T> entities) {
		return getRepository().saveAll(entities);
	}

	public void deleteById(Long id) {
		getRepository().deleteById(id);
	}
	
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	public Optional<T> findById(Long id) {
		return getRepository().findById(id);
	}
	
	public List<T> findAll() {
		return getRepository().findAll();
	}
	
	public List<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable).getContent();
	}
	
	public Long count() {
		return getRepository().count();
	}

}