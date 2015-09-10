package com.mycompany.debater;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {

  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
      MySQLiteHelper.COLUMN_COMMENT };

  public CommentsDataSource(Context context) {
    dbHelper = new MySQLiteHelper(context);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }

  public Topics createTopics(String Topics) {
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.COLUMN_COMMENT, Topics);
    long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Topics newTopics = cursorToTopics(cursor);
    cursor.close();
    return newTopics;
  }

  public void deleteTopics(Topics Topics) {
    long id = Topics.getId();
    System.out.println("Topics deleted with id: " + id);
    database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
        + " = " + id, null);
  }

  public List<Topics> getAllTopicss() {
    List<Topics> Topicss = new ArrayList<Topics>();

    Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
        allColumns, null, null, null, null, null);

    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Topics Topics = cursorToTopics(cursor);
      Topicss.add(Topics);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return Topicss;
  }

  private Topics cursorToTopics(Cursor cursor) {
    Topics Topics = new Topics();
    Topics.setId(cursor.getLong(0));
    //Topics.settopics(cursor.getString(1));
    return Topics;
  }
}