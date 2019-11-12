package mrcm.royal.SchoolService.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="student")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractEntity {

    @Column(unique = true)
    private int schoolNo;

    @Column(unique = true)
    private String name;

    @ManyToOne
	@JoinColumn(name="school_id", nullable=false)
	private School school;
    
}