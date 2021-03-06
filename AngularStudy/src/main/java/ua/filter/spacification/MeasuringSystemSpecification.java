package ua.filter.spacification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.MeasuringSystem;
import ua.filter.BasicFilter;

public class MeasuringSystemSpecification implements Specification<MeasuringSystem>{

	private final BasicFilter filter;

	public MeasuringSystemSpecification(BasicFilter filter) {
		this.filter = filter;
	}
	
	@Override
	public Predicate toPredicate(Root<MeasuringSystem> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("name"), filter.getSearch()+"%");
	}
}
