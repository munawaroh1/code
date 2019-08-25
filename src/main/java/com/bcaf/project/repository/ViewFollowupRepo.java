//package com.bcaf.project.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.bcaf.project.model.ViewFollowup;
//
//public interface ViewFollowupRepo extends JpaRepository<ViewFollowup, Long>{
//
//	@Query("SELECT a FROM ViewFolloup a")
//	public List<ViewFollowup> findByKategori();
//	
//}
