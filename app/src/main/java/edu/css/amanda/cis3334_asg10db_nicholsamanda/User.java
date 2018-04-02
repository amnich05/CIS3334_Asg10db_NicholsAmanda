package edu.css.amanda.cis3334_asg10db_nicholsamanda;

/**
 * Created by Amanda on 4/1/2018.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by vogella on 06.09.17.
 */
@Entity
public class User {

    // initialize the variables to identify user
    @PrimaryKey
    public final int id;
    public String name;
    public int level;
    public long skillPoints;


    // declare (set) the variables to identify user
    public User(int id, String name, long skillPoints) {
        this.id = id;
        this.name = name;
        this.skillPoints  = skillPoints;
        this.level = 0;
    }

}