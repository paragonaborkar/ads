package com.netapp.ads.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the controller release database table.
 * 
 */
@Entity
@Table(name="controller_release")
public class ControllerRelease implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="create_time", insertable=false, updatable=false)
	private Timestamp createTime;

	@Column(name="update_time", insertable=false, updatable=false)
	private Timestamp updateTime;

	@Column(name="processed")
	private boolean processed;

	//uni-directional one-to-one association to Controller
	@OneToOne
	@JoinColumn(name = "src_controller_id", nullable=false)
	private Controller srcController;

	//uni-directional one-to-one association to Controller
//	@Column(name="tgt_controller_id", insertable=false, updatable=false, nullable=false)
	@OneToOne
	@JoinColumn(name = "tgt_controller_id")
	private Controller tgtController;

	public ControllerRelease() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public Controller getSrcController() {
		return srcController;
	}

	public void setSrcController(Controller srcController) {
		this.srcController = srcController;
	}

	public Controller getTgtController() {
		return tgtController;
	}

	public void setTgtController(Controller tgtController) {
		this.tgtController = tgtController;
	}

	

}