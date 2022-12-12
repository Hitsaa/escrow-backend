package com.blockchain.escrow.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "developer_project")
public class DeveloperProject implements Serializable{
    private static final long serialVersionUID = -4650977692338418463L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
