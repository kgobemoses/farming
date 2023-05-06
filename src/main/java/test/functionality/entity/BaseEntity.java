package test.functionality.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 8083235829218185882L;
	private static final String ID_GEN_TABLE_NAME = "id_gen";
	
	@Id
	@TableGenerator(initialValue=50, name = BaseEntity.ID_GEN_TABLE_NAME)
	@GeneratedValue(generator=BaseEntity.ID_GEN_TABLE_NAME)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
