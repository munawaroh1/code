/*
 * package com.bcaf.project.model;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.Table; import
 * javax.persistence.TableGenerator;
 * 
 * @Entity
 * 
 * @Table public class User_Module {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.TABLE, generator =
 * "tbl_user_module_index")
 * 
 * @TableGenerator(name = "tbl_user_module_index", table = "tbll_index",
 * pkColumnName = "index_id", valueColumnName = "index_value", allocationSize =
 * 1, initialValue = 0)
 * 
 * @Column(name = "id", nullable = false) private Long id;
 * 
 * @Column(name = "user_id", nullable = false) private Long userId;
 * 
 * @Column(name = "module_id", nullable = false) private Long moduleId;
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public Long getUserId() { return userId; }
 * 
 * public void setUserId(Long userId) { this.userId = userId; }
 * 
 * public Long getModuleId() { return moduleId; }
 * 
 * public void setModuleId(Long moduleId) { this.moduleId = moduleId; }
 * 
 * 
 * }
 */