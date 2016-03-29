package com.kit.hibertester.rules.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Eldest on 27.03.2016.
 */

@Entity
@Table(name="section")
public class Section {
    @Id
    @Column(name = "section_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int section_id;

    @Column(name = "name")
    private String name;

    public Section() {
    }

    public int getSection_id() {
        return section_id;
    }

    public String getName() {
        return name;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
