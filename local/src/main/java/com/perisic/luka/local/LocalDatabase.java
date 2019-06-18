package com.perisic.luka.local;

import androidx.room.Database;

import com.perisic.luka.local.data.TokenModel;
import com.perisic.luka.local.data.UserModel;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Database(entities = {UserModel.class, TokenModel.class}, version = 1, exportSchema = false)
public abstract class LocalDatabase extends BaseLocalDatabase{


}