package com.kit.hibertester.rules.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Eldest on 16.03.2016.
 */

@Entity
@Table(name="rule")
public class Rules {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rule_Id;

    @Column(name = "name", unique = true, nullable = false)
    private String rule_Name;

    @Column(unique = true, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "entity_id",
            foreignKey = @ForeignKey(name = "rule_entity_id_fkey"))
    private int entity_id;

    private String query_text;

    @ManyToOne
    @JoinColumn(name = "section_id",
            foreignKey = @ForeignKey(name = "rule_section_id_fkey"))
    private int section_id;

    public Rules() {}

    public int getRule_Id() {
        return rule_Id;
    }

    public String getRule_Name() {
        return rule_Name;
    }

    public String getDescription() {
        return description;
    }

    public int getEntity_id() {
        return entity_id;
    }

    public String getQuery_text() {
        return query_text;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setRule_Id(int rule_Id) {
        this.rule_Id = rule_Id;
    }

    public void setRule_Name(String rule_Name) {
        this.rule_Name = rule_Name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public void setQuery_text(String query_text) {
        this.query_text = query_text;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }
}
