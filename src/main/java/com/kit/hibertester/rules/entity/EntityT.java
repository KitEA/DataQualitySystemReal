package com.kit.hibertester.rules.entity;

import javax.persistence.*;

/**
 * Created by Eldest on 27.03.2016.
 */

@Entity
@Table(name="entity")
public class EntityT {
    @Id
    @Column(name = "entity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int entity_id;

    @Column(name = "name")
    private String name;

    public EntityT() {
    }

    public int getEntity_id() {
        return entity_id;
    }

    public String getName() {
        return name;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
