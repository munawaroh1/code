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
 * @Table(name = "tbl_module") public class Module {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.TABLE, generator =
 * "tbl_module_index")
 * 
 * @TableGenerator(name = "tbl_module_index", table = "tbl_index", pkColumnName
 * = "index_id", valueColumnName = "index_value", allocationSize = 1,
 * initialValue = 0)
 * 
 * @Column(name = "id", nullable = false) private Long id;
 * 
 * @Column(name = "nama_module", nullable = false) private String namaModule;
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getNamaModule() { return namaModule; }
 * 
 * public void setNamaModule(String namaModule) { this.namaModule = namaModule;
 * }
 * 
 * 
 * }
 */