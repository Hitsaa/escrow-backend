package com.blockchain.escrow.entity;

import java.io.Serializable;
import java.util.Set;

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
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = -4650977692338418463L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String clientName;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy="client")
    private Set<Project> project;
}
