package com.blockchain.escrow.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "developer")
public class Developer implements Serializable {
    private static final long serialVersionUID = -4650977692338418463L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String developerName;

    @Column(unique=true)
    private String phoneNumber;

    private String address;

    @OneToMany(mappedBy="developer")
    private Set<DeveloperProject> developerProject;
}
