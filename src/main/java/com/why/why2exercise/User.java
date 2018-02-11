package com.why.why2exercise;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 小慧莹 on 2018/1/25.
 */
@Entity
public class User {
    @Index
    private Long id;
    @Property(nameInDb = "NAME")//表示该属性将作为表的一个字段，其中nameInDb看名字就知道这个属性在数据库中对应的数据名称
    @NotNull
    private String name;
    @NotNull
    private String age;

    @Transient //注解表示这个属性将不会作为数据表中的一个字段
    private int tempUsageCount; // not persisted

    @Generated(hash = 2054556472)
    public User(Long id, @NotNull String name, @NotNull String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
