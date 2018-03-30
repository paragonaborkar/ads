package com.netapp.ads.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qtree_disposition")
public class QtreeDisposition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(name = "qtree_id", insertable=false, updatable=false)
	private String reportName;

	@Column(name = "disposition")
	private String disposition;
	
	@Column(name = "justification")
	private String justification;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;
	
	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;
	
	//bi-directional one-to-one association to Qtree
	@ManyToOne
	@JoinColumn(name="qtree_id", nullable=false)
	private Qtree qtree;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * @return the disposition
	 */
	public String getDisposition() {
		return disposition;
	}

	/**
	 * @param disposition the disposition to set
	 */
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	/**
	 * @return the justification
	 */
	public String getJustification() {
		return justification;
	}

	/**
	 * @param justification the justification to set
	 */
	public void setJustification(String justification) {
		this.justification = justification;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the qtree
	 */
	public Qtree getQtree() {
		return qtree;
	}

	/**
	 * @param qtree the qtree to set
	 */
	public void setQtree(Qtree qtree) {
		this.qtree = qtree;
	}
	
	
}
