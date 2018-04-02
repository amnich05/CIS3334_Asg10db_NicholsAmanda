package edu.css.amanda.cis3334_asg10db_nicholsamanda;

/**
 * Created by Amanda on 4/1/2018.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface UserDao {

    // INSERT user INTO user TABLE
    // if conflict (duplicate?) replace
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    /* SELECT ALL
     * FROM user TABLE
     */
    @Query("select * from user")
    public List<User> getAllUser();

    /* SELECT ALL
     * FROM user TABLE
     * WHERE id = userID
     */
    @Query("select * from user where id = :userId")
    public List<User> getUser(long userId);

    // UPDATE user TABLE
    // if conflict (duplicate?) REPLACE
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

    /* DELETE ALL
     * FROM user TABLE
     */
    @Query("delete from user")
    void removeAllUsers();
}

