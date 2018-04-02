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
public interface TrophyDao {

    // INSERT trophy INTO trophy TABLE
    // if conflict (duplicate?) replace
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrophy(Trophy trophy);

    /* SELECT ALL
     * FROM trophy TABLE
     * WHERE userId = userId
     */
    @Query("SELECT * FROM trophy WHERE userId=:userId")
    List<Trophy> findTrophiesForUser(int userId);

    // UPDATE trophy TABLE
    // if conflict (duplicate?) REPLACE
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTrophy(Trophy trophy);

    /* DELETE
     * FROM trophy TABLE
     * WHERE id = id
     */
    @Query("delete from trophy where id = :id")
    void delete(long id);

}
