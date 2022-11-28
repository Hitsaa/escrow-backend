package com.blockchain.escrow.entity;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "project")
public class Project implements Serializable{
    private static final long serialVersionUID = -4650977692338418463L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;
    private String projectName;

    @ManyToOne(fetch = FetchType.LAZY)
    Client client;
}
