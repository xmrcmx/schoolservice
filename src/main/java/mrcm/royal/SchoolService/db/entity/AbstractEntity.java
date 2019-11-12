package mrcm.royal.SchoolService.db.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@MappedSuperclass
@Data
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@JsonIgnore
	private int version;


	protected AbstractEntity() {}

	protected AbstractEntity(long id, int version) {
		this.id = id;
		this.version = version;
	}

	@JsonIgnore
	public boolean isNew() {
		return id == null;
	}

}