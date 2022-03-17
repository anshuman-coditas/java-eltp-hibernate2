package com;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "MusicInfo4")
public class Musicians {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="music")
    @TableGenerator(name="music",initialValue = 2,allocationSize = 1,table="idseq"
    )
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    @Column(name = "Instrument")
    private String inst;
}
