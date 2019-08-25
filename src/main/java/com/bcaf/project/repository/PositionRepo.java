package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Position;

@Repository

public interface PositionRepo extends JpaRepository<Position, Long>{
//	@Query("SELECT a.id, a.level,(select b.position from tbl_position b where id=a.parent_id)as parent_name, position FROM tbl_position a ")
//	public List<Position> findAllByParent();
//	
	
}
